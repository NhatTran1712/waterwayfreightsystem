package org.apptopia.waterwayfreightsystem.api.api;

import java.util.List;

import org.apptopia.waterwayfreightsystem.api.api.application.ShipService;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.ship.RawShipOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/ship")
public class ShipController {
	private ShipService shipService;
	
	@Autowired
	public void setShipService(ShipService shipService) {
		this.shipService = shipService;
	}
	
	@RequestMapping(value = {"/",""}, produces = "application/json",
		consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	@ResponseBody
	public List<RawShipOutput> getAllShips(){
		return shipService.findAllShips();
	}
}
