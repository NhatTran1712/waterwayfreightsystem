package org.apptopia.waterwayfreightsystem.api.api;

import java.util.List;

import org.apptopia.waterwayfreightsystem.api.api.application.AccountService;
import org.apptopia.waterwayfreightsystem.api.api.application.CargoService;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.account.RawAccountOutput;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.cargo.RawCargoInput;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.cargo.RawCargoOutput;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.delete.DeleteCargoUseCase;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.rawinput.AddNewCargoUseCase;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.rawupdate.UpdateCargoUseCase;
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
	
	@Autowired
	public void setService(CargoService cargoService, AccountService accountService) {
		this.cargoService = cargoService;
		this.accountService = accountService;
	}
	
	@Autowired
	public void setCargoUseCase(AddNewCargoUseCase addNewCargoUseCase,
		UpdateCargoUseCase updateCargoUseCase,DeleteCargoUseCase deleteCargoUseCase) {
		
		this.addNewCargoUseCase = addNewCargoUseCase;
		this.updateCargoUseCase = updateCargoUseCase;
		this.deleteCargoUseCase = deleteCargoUseCase;
	}
	
	@RequestMapping(value = {"/",""}, method = RequestMethod.GET)
//	@PreAuthorize("hasRole('ROLE_MANAGER')")
	public String getAllCargos(Model model){
		model.addAttribute("cargos", cargoService.findAllCargos());
		model.addAttribute("accounts", accountService.findAllAccount());
		return "show-all-cargos";
	}
	
	@RequestMapping(value = {"/delete"}, method = RequestMethod.GET)
	public String deleteCargo(@RequestParam("id") Long idCargo, RedirectAttributes redirect) {
		deleteCargoUseCase.handle(idCargo);
		redirect.addFlashAttribute("success", "Xoa tai khoan thanh cong!");
		return "redirect:/cargo";
	}
//	
//	@RequestMapping(value = {"/show-all/{id}","/{id}/"}, produces = "application/json",
//		consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
//	@ResponseBody
//	@PreAuthorize("hasRole('ROLE_USER' || 'ROLE_MANAGER')")
//	public List<RawCargoOutput> getCargosOfCustomer(@PathVariable("id") Long idUser){
//		return cargoService.getCargosOfCustomer(idUser);
//	}
//	
//	@RequestMapping(value = {"/add/","/add"}, produces = "application/json",
//		consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
//	@ResponseBody
//	@PreAuthorize("hasRole('ROLE_MANAGER')")
//	public RawCargoOutput addNewCargo(@RequestBody RawCargoInput rawCargoInput) {
//		return addNewCargoUseCase.handle(rawCargoInput);
//	}
//	
//	@RequestMapping(value = {"/update/","/update"}, produces = "application/json",
//		consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
//	@ResponseBody
//	@PreAuthorize("hasRole('ROLE_MANAGER')")
//	public RawCargoOutput updateCargo(@RequestBody RawCargoInput rawCargoInput) {
//		return updateCargoUseCase.handle(rawCargoInput);
//	}
}
