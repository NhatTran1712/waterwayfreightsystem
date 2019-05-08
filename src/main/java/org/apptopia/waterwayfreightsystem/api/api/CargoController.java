package org.apptopia.waterwayfreightsystem.api.api;

import java.util.List;

import org.apptopia.waterwayfreightsystem.api.api.application.CargoService;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.cargo.RawCargoInput;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.cargo.RawCargoOutput;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.rawinput.AddNewCargoUseCase;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.rawupdate.UpdateCargoUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/cargo")
public class CargoController {
	private CargoService cargoService;
	private AddNewCargoUseCase addNewCargoUseCase;
	private UpdateCargoUseCase updateCargoUseCase;
	
	@Autowired
	public void setCargoService(CargoService cargoService) {
		this.cargoService = cargoService;
	}
	
	@Autowired
	public void setCargoUseCase(AddNewCargoUseCase addNewCargoUseCase,
		UpdateCargoUseCase updateCargoUseCase) {
		
		this.addNewCargoUseCase = addNewCargoUseCase;
		this.updateCargoUseCase = updateCargoUseCase;
	}
	
	@RequestMapping(value = {"/",""}, produces = "application/json",
		consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	@ResponseBody
	@PreAuthorize("hasRole('ROLE_MANAGER')")
	public List<RawCargoOutput> getAllCargos(){
		return cargoService.findAllCargos();
	}
	
	@RequestMapping(value = {"/show-all/{id}","/{id}/"}, produces = "application/json",
		consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	@ResponseBody
	@PreAuthorize("hasRole('ROLE_USER' || 'ROLE_MANAGER')")
	public List<RawCargoOutput> getCargosOfCustomer(@PathVariable("id") Integer idUser){
		return cargoService.getCargosOfCustomer(idUser);
	}
	
	@RequestMapping(value = {"/add/","/add"}, produces = "application/json",
		consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	@ResponseBody
	@PreAuthorize("hasRole('ROLE_MANAGER')")
	public RawCargoOutput addNewCargo(@RequestBody RawCargoInput rawCargoInput) {
		return addNewCargoUseCase.handle(rawCargoInput);
	}
	
	@RequestMapping(value = {"/update/","/update"}, produces = "application/json",
		consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
	@ResponseBody
	@PreAuthorize("hasRole('ROLE_MANAGER')")
	public RawCargoOutput updateCargo(@RequestBody RawCargoInput rawCargoInput) {
		return updateCargoUseCase.handle(rawCargoInput);
	}
}
