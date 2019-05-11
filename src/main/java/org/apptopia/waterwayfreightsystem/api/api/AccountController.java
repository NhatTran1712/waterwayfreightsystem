package org.apptopia.waterwayfreightsystem.api.api;

import org.apptopia.waterwayfreightsystem.api.api.application.AccountService;
import org.apptopia.waterwayfreightsystem.api.api.application.SecurityService;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.account.RawAccountInput;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.account.RawAccountOutput;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.delete.DeleteAccountUseCase;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.rawinput.RegisterCustomerAccountUseCase;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.rawinput.RegisterStaffAccountUseCase;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.rawupdate.UpdateAccountUseCase;
import org.apptopia.waterwayfreightsystem.api.api.authentication.Account;
import org.apptopia.waterwayfreightsystem.api.api.authentication.AccountType;
import org.apptopia.waterwayfreightsystem.api.api.authentication.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@CrossOrigin
@RequestMapping("/account")
public class AccountController {
	private AccountService accountService;
	private UpdateAccountUseCase updateAccountUseCase;
	private RegisterCustomerAccountUseCase registerCustomerAccountUseCase;
	private RegisterStaffAccountUseCase registerStaffAccountUseCase;
	private DeleteAccountUseCase deleteAccountUseCase;
    private UserValidator userValidator;
    
	@Autowired
	public void setAccountService(AccountService accountService, SecurityService securityService) {
		this.accountService = accountService;
	}
	
	@Autowired
	public void setAccountUseCase(UpdateAccountUseCase updateAccountUseCase,
		RegisterCustomerAccountUseCase registerCustomerAccountUseCase,
		RegisterStaffAccountUseCase registerStaffAccountUseCase,
		DeleteAccountUseCase deleteAccountUseCase) {

		this.updateAccountUseCase = updateAccountUseCase;
		this.registerCustomerAccountUseCase = registerCustomerAccountUseCase;
		this.registerStaffAccountUseCase = registerStaffAccountUseCase;
		this.deleteAccountUseCase = deleteAccountUseCase;
	}
	
	@Autowired
	public void setUserValidator(UserValidator userValidator) {
		this.userValidator = userValidator;
	}

    @RequestMapping(value = {"/registration"}, method = RequestMethod.GET)
    public String addNewCustomerAccount(Model model) {
    	model.addAttribute("userForm", new RawAccountInput());
        return "registration";
    }

    @RequestMapping(value = {"/registration"}, method = RequestMethod.POST)
    public String addNewCustomerAccount(@ModelAttribute("userForm") RawAccountInput userForm,
    	BindingResult bindingResult) {
        
    	userValidator.validate(userForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        registerCustomerAccountUseCase.handle(userForm);
        return "redirect:/home";
    }

    @RequestMapping(value = {"/registration-staff"}, method = RequestMethod.GET)
    public String addNewStaffAccount(Model model) {
    	model.addAttribute("userForm", new Account());
    	model.addAttribute("accountTypeList", AccountType.values());
        return "registration-staff";
    }
    
    @RequestMapping(value = {"/registration-staff"}, method = RequestMethod.POST)
    public String addNewStaffAccount(@ModelAttribute("userForm") RawAccountInput userForm,
    	BindingResult bindingResult) {
        
    	userValidator.validate(userForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "registration-staff";
        }
        RawAccountOutput rawAccountOutput = registerStaffAccountUseCase.handle(userForm);
        return "redirect:/account/show?username=" + rawAccountOutput.getUsername();
    }
    
    @RequestMapping(value = {"/update"}, method = RequestMethod.GET)
	public String updateAccount(@RequestParam("username") String username, Model model) {
    	model.addAttribute("account", accountService.findAccountByUserName(username));
    	model.addAttribute("accountTypes", AccountType.values());
		return "update-account";
	}
    
    @RequestMapping(value = {"/update"}, method = RequestMethod.POST)
    public String updateAccount(RawAccountInput rawAccountInput, Model model) { 
    	model.addAttribute("account", updateAccountUseCase.handle(rawAccountInput));
        return "show-account";
    }
    
    @RequestMapping(value = {"/delete"}, method = RequestMethod.GET)
    public String deleteAccount(@RequestParam("username") String username,
    	RedirectAttributes redirect) {
    	deleteAccountUseCase.handle(username);
		redirect.addFlashAttribute("success", "Xoa tai khoan thanh cong!");
		return "redirect:/account";
    }
    
    @RequestMapping(value = {"/show"}, method = RequestMethod.GET)
	public String getAccount(@RequestParam("username") String username, Model model) {
    	model.addAttribute("account", accountService.findAccountByUserName(username));    	 
		return "show-account";
	}
    
    @RequestMapping(value = {"/",""}, method = RequestMethod.GET)
	public String getAllAccount(Model model){
		model.addAttribute("accounts",accountService.findAllAccount());
		return "show-accounts"; 
	}
    
    @RequestMapping(value= {"/search"}, method = RequestMethod.GET)
	public String searchAccountByFullname(@RequestParam("fullname") String fullname, Model model) {

    	if (fullname.equals("")) {
			return "redirect:/account";
    	}
    	model.addAttribute("accounts", accountService.searchAccountByFullname(fullname));
		return "show-accounts";
	}
//    
//	@RequestMapping(value = {"/show-all/staff/","/show-all/staff"}, method = RequestMethod.GET)
//	public String getStaffAccount(Model model){
//		model.addAttribute("accounts",accountService.findAccountByAccountType("staff"));
//		return "show-accounts"; 
//	}
//	
//	@RequestMapping(value = {"/customer/","/customer"}, produces = "application/json",
//		method = RequestMethod.GET)
//	@ResponseBody
//	public List<RawAccountOutput> getCustomerAccount(){
//		return accountService.findAccountByAccountType("user");
//	}
//	
}
