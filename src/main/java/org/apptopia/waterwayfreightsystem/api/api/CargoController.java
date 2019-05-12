package org.apptopia.waterwayfreightsystem.api.api;

import java.util.List;

import org.apptopia.waterwayfreightsystem.api.api.application.AccountService;
import org.apptopia.waterwayfreightsystem.api.api.application.CargoService;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.account.RawAccountInput;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.account.RawAccountOutput;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.cargo.RawCargoInput;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.cargo.RawCargoOutput;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.delete.DeleteCargoUseCase;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.rawinput.AddNewCargoUseCase;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.rawupdate.UpdateCargoUseCase;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.search.cargo.SearchByIdCargoInput;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.search.cargo.SearchByOwnerFullnameInput;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.search.cargo.SearchByOwnerFullnameOutput;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.search.cargo.SearchByOwnerFullnameUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
	
//	@RequestMapping(value = {"/add/","/add"}, produces = "application/json",
//		consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
//	@ResponseBody
//	@PreAuthorize("hasRole('ROLE_MANAGER')")
//	public RawCargoOutput addNewCargo(@RequestBody RawCargoInput rawCargoInput) {
//		return addNewCargoUseCase.handle(rawCargoInput);
//	}
}
