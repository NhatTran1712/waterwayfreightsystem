package org.apptopia.waterwayfreightsystem.api.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.apptopia.waterwayfreightsystem.api.api.application.TransportProcessService;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.transportprocess.RawTransportProcessOutput;
import org.apptopia.waterwayfreightsystem.api.api.core.calculator.TransportProcessInformationCalculator;

@RestController
@CrossOrigin
@RequestMapping("/transport-process")
public class TransportProcessController {
	private TransportProcessService transportProcessService;
	private TransportProcessInformationCalculator transportProcessInformationCalculator;
	
	@Autowired
	public void setTransportProcessService(TransportProcessService transportProcessService,
		TransportProcessInformationCalculator transportProcessInformationCalculator) {
		
		this.transportProcessService = transportProcessService;
		this.transportProcessInformationCalculator = transportProcessInformationCalculator;
	}
	
	@RequestMapping(value = {"/",""}, produces = "application/json",
		consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	@ResponseBody
	public List<RawTransportProcessOutput> getAllTransportProcesses(){
		return transportProcessService.findAllTransportProcesses();
	}
	
	@RequestMapping(value = {"/{id}/","/{id}"}, produces = "application/json",
		consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
	@ResponseBody
	public RawTransportProcessOutput showTransportProcess(@PathVariable("id")
		Integer idTransportProcess) {
		return transportProcessInformationCalculator.handle(idTransportProcess);
	}
}
