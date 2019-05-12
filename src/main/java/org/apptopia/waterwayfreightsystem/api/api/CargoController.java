package org.apptopia.waterwayfreightsystem.api.api;

import org.apptopia.waterwayfreightsystem.api.api.application.AccountService;
import org.apptopia.waterwayfreightsystem.api.api.application.CargoService;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.cargo.RawCargoInput;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.cargo.RawCargoOutput;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.delete.DeleteCargoUseCase;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.rawinput.AddNewCargoUseCase;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.rawupdate.UpdateCargoUseCase;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.search.cargo.SearchByIdCargoInput;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.search.cargo.SearchByOwnerFullnameInput;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.search.cargo.SearchByOwnerFullnameUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@CrossOrigin
@RequestMapping("/cargo")
public class CargoController {
	private CargoService cargoService;
	private AccountService accountService;
	private AddNewCargoUseCase addNewCargoUseCase;
	private UpdateCargoUseCase updateCargoUseCase;
	private DeleteCargoUseCase deleteCargoUseCase;
	private SearchByOwnerFullnameUseCase searchByOwnerFullnameUseCase;
	
	@Autowired
	public void setService(CargoService cargoService, AccountService accountService) {
		this.cargoService = cargoService;
		this.accountService = accountService;
	}
	
	@Autowired
	public void setCargoUseCase(AddNewCargoUseCase addNewCargoUseCase,
		UpdateCargoUseCase updateCargoUseCase,DeleteCargoUseCase deleteCargoUseCase,
		SearchByOwnerFullnameUseCase searchByOwnerFullnameUseCase) {
		
		this.addNewCargoUseCase = addNewCargoUseCase;
		this.updateCargoUseCase = updateCargoUseCase;
		this.deleteCargoUseCase = deleteCargoUseCase;
		this.searchByOwnerFullnameUseCase = searchByOwnerFullnameUseCase;
	}
	
	@RequestMapping(value = {"/",""}, method = RequestMethod.GET)
//	@PreAuthorize("hasRole('ROLE_MANAGER')")
	public String getAllCargos(Model model){
		model.addAttribute("cargos", cargoService.findAllCargos());
		model.addAttribute("accounts", accountService.findAllAccount());
		return "show-all-cargos";
	}

	@RequestMapping(value = {"/search-owner-fullname"}, method = RequestMethod.GET)
	public String searchCargoByOwnerFullname(SearchByOwnerFullnameInput searchByOwnerFullnameInput,
		Model model){
		if(searchByOwnerFullnameInput == null) {
			return "redirect:/cargo";
		}
		model.addAttribute("cargos", searchByOwnerFullnameUseCase.handle(searchByOwnerFullnameInput)
			.getRawCargoOutputs());
		model.addAttribute("accounts", accountService.findAllAccount());
		return "show-all-cargos";
	}
	
	@RequestMapping(value = {"/add/","/add"}, method = RequestMethod.GET)
//	@PreAuthorize("hasRole('ROLE_MANAGER')")
	public String addNewCargo(Model model) {
		model.addAttribute("rawCargoInput", new RawCargoInput());
		model.addAttribute("accounts", accountService.findAccountByAccountType("user"));
		return "add-cargo";
	}
	
	@RequestMapping(value = {"/add"}, method = RequestMethod.POST)
//	@PreAuthorize("hasRole('ROLE_MANAGER')")
	public String addNewCargo(RawCargoInput rawCargoInput) {
		RawCargoOutput rawCargoOutput = addNewCargoUseCase.handle(rawCargoInput);
		return "redirect:/cargo/show?id=" + rawCargoOutput.getIdCargo();
	}
	
	@RequestMapping(value = {"/update"}, method = RequestMethod.GET)
//	@PreAuthorize("hasRole('ROLE_MANAGER')")
	public String updateCargo(@RequestParam("id") Long idCargo, Model model) {
		model.addAttribute("cargo", cargoService.findCargoByIdCargo(idCargo));
		model.addAttribute("accounts", accountService.findAccountByAccountType("user"));
		return "update-cargo";
	}

    @RequestMapping(value = {"/update"}, method = RequestMethod.POST)
    public String updateCargo(RawCargoInput rawCargoInput, Model model) { 
    	model.addAttribute("cargo", updateCargoUseCase.handle(rawCargoInput));
    	model.addAttribute("accounts", accountService.findAllAccount());
        return "show-cargo";
    }
	
	@RequestMapping(value = {"/delete"}, method = RequestMethod.GET)
	public String deleteCargo(@RequestParam("id") Long idCargo, RedirectAttributes redirect) {
		deleteCargoUseCase.handle(idCargo);
		redirect.addFlashAttribute("success", "Xoa tai khoan thanh cong!");
		return "redirect:/cargo";
	}
	
	@RequestMapping(value = {"/show-customer-cargos"}, method = RequestMethod.GET)
//	@PreAuthorize("hasRole('ROLE_USER' || 'ROLE_MANAGER')")
	public String getCargosOfCustomer(@RequestParam("username") String username, Model model){
		 if(username.equals("")) {
			 return "redirect:/home";
		 }
		 model.addAttribute("cargos", cargoService.getCargosOfCustomer(username));
		 return "show-customer-cargos";
	}

	@RequestMapping(value = {"/search-id"}, method = RequestMethod.GET)
	public String searchCargoByIdCargo(SearchByIdCargoInput searchByIdCargoInput, Model model){
		if(searchByIdCargoInput.getIdCargo() == null || searchByIdCargoInput.getIdCargo() == 0) {
			return "redirect:/cargo/show-customer-cargos?username="+searchByIdCargoInput
				.getOwnerUsername();
		}
		model.addAttribute("cargos", cargoService.changetoList(cargoService.findCargoByIdCargo
			(searchByIdCargoInput).getRawCargoOutput()));
		return "show-customer-cargos";
	}
	
	@RequestMapping(value = {"/show"}, method = RequestMethod.GET)
	public String getCargo(@RequestParam("id") Long idCargo, Model model){
		 if(idCargo == null || idCargo == 0) {
			 return "redirect:/cargo/add";
		 }
		 model.addAttribute("cargo", cargoService.findCargoByIdCargo(idCargo));
		 model.addAttribute("accounts", accountService.findAccountByAccountType("user"));
		 return "show-cargo";
	}
}
