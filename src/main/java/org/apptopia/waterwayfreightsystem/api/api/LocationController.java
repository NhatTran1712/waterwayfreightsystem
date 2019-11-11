package org.apptopia.waterwayfreightsystem.api.api;

import java.util.List;
import org.apptopia.waterwayfreightsystem.api.api.application.LocationService;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.location.RawCityOutput;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.location.RawDistrictOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/location")
public class LocationController {
	private LocationService locationService;
	
	@Autowired
	public void setLocationService(LocationService locationService) {
		this.locationService = locationService;
	}
	
	@RequestMapping(value = {"/city/", "/city"}, produces = "application/json",
		method = RequestMethod.GET)
	@ResponseBody
	public List<RawCityOutput> getAllCities() {
		return locationService.findAllCities();
	}
	
	@RequestMapping(value = {"/city/{id}"}, produces = "application/json",
    		consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    @ResponseBody
    public List<RawDistrictOutput> getDistrictsByCityID(@PathVariable("id") Long id) {
		return locationService.findDistrictByCityId(id);
	}
}
