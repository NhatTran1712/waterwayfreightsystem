package org.apptopia.waterwayfreightsystem.api.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.apptopia.waterwayfreightsystem.api.api.application.TransportProcessService;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.transportprocess.RawTransportProcessOutput;

@RestController
@CrossOrigin
@RequestMapping("/transport-process")
public class TransportProcessController {
	
	private TransportProcessService transportProcessService;
	
	@Autowired
	public void setTransportProcessService(TransportProcessService transportProcessService) {
		
		this.transportProcessService = transportProcessService;
	}
	
	@RequestMapping(value = {"/",""}, produces = "application/json",
		consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	@ResponseBody
	public List<RawTransportProcessOutput> getAllTransportProcesses(){
		return transportProcessService.findAllTransportProcesses();
	}
}
