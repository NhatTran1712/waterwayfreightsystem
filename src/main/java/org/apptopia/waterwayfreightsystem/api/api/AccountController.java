package org.apptopia.waterwayfreightsystem.api.api;

import java.util.List;
import java.util.Optional;

import org.apptopia.waterwayfreightsystem.api.api.application.AccountService;
import org.apptopia.waterwayfreightsystem.api.api.application.SecurityService;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.account.RawAccountInput;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.account.RawAccountMapper;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.account.RawAccountOutput;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.rawupdate.UpdateAccountUseCase;
import org.apptopia.waterwayfreightsystem.api.api.authentication.Account;
import org.apptopia.waterwayfreightsystem.api.api.authentication.AccountRepository;
import org.apptopia.waterwayfreightsystem.api.api.authentication.AccountType;
import org.apptopia.waterwayfreightsystem.api.api.authentication.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin
@RequestMapping("/account")
public class AccountController {
	private AccountService accountService;	
	private SecurityService securityService;
	private AccountRepository accountRepository;
	private UpdateAccountUseCase updateAccountUseCase;
    private UserValidator userValidator;
    private PasswordEncoder passwordEncoder;
    
	@Autowired
	public void setAccountService(AccountService accountService, SecurityService securityService) {
		this.accountService = accountService;
		this.securityService = securityService;
	}
	
	@Autowired
	public void setAccountRepository(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}
	
	@Autowired
	public void setAccountUseCase(UpdateAccountUseCase updateAccountUseCase) {

		this.updateAccountUseCase = updateAccountUseCase;
	}
	
	@Autowired
	public void setUserValidator(UserValidator userValidator) {
		this.userValidator = userValidator;
	}
	
	@Autowired
	public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

    @RequestMapping(value = {"/registration"}, method = RequestMethod.GET)
    public String addNewCustomerAccount(Model model) {
        
    	model.addAttribute("userForm", new Account());
        return "registration";
    }

    @RequestMapping(value = {"/registration"}, method = RequestMethod.POST)
    public String addNewCustomerAccount(@ModelAttribute("userForm") Account userForm,
    	BindingResult bindingResult) {
        
    	userValidator.validate(userForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        userForm.setAccountType(AccountType.USER);
        userForm.setPassword(passwordEncoder.encode(userForm.getPassword()));
        accountRepository.save(userForm);
        securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());
        return "redirect:/home";
    }

    @RequestMapping(value = {"/registration-staff"}, method = RequestMethod.GET)
    public String addNewStaffAccount(Model model) {

    	model.addAttribute("userForm", new Account());
    	model.addAttribute("accountTypeList", AccountType.values());
        return "registration-staff";
    }
    
    @RequestMapping(value = {"/registration-staff"}, method = RequestMethod.POST)
    public String addNewStaffAccount(@ModelAttribute("userForm") Account userForm,
    	BindingResult bindingResult) {
        
    	userValidator.validate(userForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "registration-staff";
        }
        userForm.setPassword(passwordEncoder.encode(userForm.getPassword()));
        accountRepository.save(userForm);
        return "redirect:/home-admin";
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
    
    @RequestMapping(value = {"/show"}, method = RequestMethod.GET)
	public String getAccount(@RequestParam("username") String username, Model model) {
    	model.addAttribute("account", accountService.findAccountByUserName(username));    	 
		return "show-account";
	}
    
//	@RequestMapping(value = {"/staff/","/staff"}, produces = "application/json", 
//		method = RequestMethod.GET)
//	@ResponseBody
//	public List<RawAccountOutput> getStaffAccount(){
//		return accountService.findAccountByAccountType("staff"); 
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
