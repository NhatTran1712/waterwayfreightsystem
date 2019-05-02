package org.apptopia.waterwayfreightsystem.api.api;

import java.util.List;

import org.apptopia.waterwayfreightsystem.api.api.application.CargoService;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.account.RawAccountInput;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.cargo.RawCargoOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
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
	
	@Autowired
	public void setCargoService(CargoService cargoService) {
		this.cargoService = cargoService;
	}
	
	@RequestMapping(value = {"/",""}, produces = "application/json",
		consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	@ResponseBody
	public List<RawCargoOutput> getAllCargos(){
		return cargoService.findAllCargos();
	}
	
	@RequestMapping(value = {"/{id}","/{id}/"}, produces = "application/json",
		consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	@ResponseBody
	@PreAuthorize("hasRole('ROLE_USER' || 'ROLE_MANAGER')")
	public List<RawCargoOutput> getCargosOfCustomer(@RequestBody RawAccountInput rawAccountInput){
		return cargoService.getCargosOfCustomer(rawAccountInput);
	}
}
