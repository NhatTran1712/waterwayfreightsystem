package org.apptopia.waterwayfreightsystem.api.api;

import java.util.List;

import org.apptopia.waterwayfreightsystem.api.api.application.ShipService;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.rawinput.AddNewTravelProblemUseCase;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.rawupdate.UpdateStatusForShipUseCase;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.rawupdate.UpdateTravelProblemUseCase;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.ship.RawShipInput;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.ship.RawShipOutput;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.travelproblem.RawTravelProblemInput;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.travelproblem.RawTravelProblemOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/ship")
public class ShipController {
	private ShipService shipService;
	private UpdateStatusForShipUseCase updateStatusForShipUseCase;
	private AddNewTravelProblemUseCase addNewTravelProblemUseCase;
	private UpdateTravelProblemUseCase updateTravelProblemUseCase;
	
	@Autowired
	public void setShipService(ShipService shipService) {
		this.shipService = shipService;
	}
	
	@Autowired
	public void setShipUseCase(UpdateStatusForShipUseCase updateStatusForShipUseCase,
		AddNewTravelProblemUseCase addNewTravelProblemUseCase,
		UpdateTravelProblemUseCase updateTravelProblemUseCase) {
		
		this.updateStatusForShipUseCase = updateStatusForShipUseCase;
		this.addNewTravelProblemUseCase = addNewTravelProblemUseCase;
		this.updateTravelProblemUseCase = updateTravelProblemUseCase;
	}
	
	@RequestMapping(value = {"/",""}, produces = "application/json",
		consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	@ResponseBody
	public List<RawShipOutput> getAllShips(){
		return shipService.findAllShips();
	}
	
	@RequestMapping(value = {"/update-status/","/update-status"}, produces = "application/json",
		consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
	@ResponseBody
	public RawShipOutput updateStatusForShip(@RequestBody RawShipInput rawShipInput) {
		return updateStatusForShipUseCase.handle(rawShipInput);
	}
	
	@RequestMapping(value = {"/travel-problem/add","/travel-problem/add/"},
		produces = "application/json", consumes = MediaType.APPLICATION_JSON_VALUE,
		method = RequestMethod.POST)
	@ResponseBody
	public RawTravelProblemOutput addNewTravelProblem(@RequestBody RawTravelProblemInput
		rawTravelProblemInput) {
		return addNewTravelProblemUseCase.handle(rawTravelProblemInput);
	}
	
	@RequestMapping(value = {"/travel-problem/update","/travel-problem/update/"},
		produces = "application/json", consumes = MediaType.APPLICATION_JSON_VALUE,
		method = RequestMethod.PUT)
	@ResponseBody
	public RawTravelProblemOutput updateTravelProblem(@RequestBody RawTravelProblemInput
		rawTravelProblemInput) {
		return updateTravelProblemUseCase.handle(rawTravelProblemInput);
	}
}
