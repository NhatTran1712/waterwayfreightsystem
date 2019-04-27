package org.apptopia.waterwayfreightsystem.api.api.core.calculator;

import org.apptopia.waterwayfreightsystem.api.api.application.TransportProcessService;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.UseCase;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.transportprocess.RawTransportProcessInput;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.transportprocess.RawTransportProcessOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransportProcessInformationCalculator implements UseCase<RawTransportProcessInput,
	RawTransportProcessOutput> {
	@Autowired TransportProcessService transportProcessService;
	
	@Override
	public RawTransportProcessOutput handle(RawTransportProcessInput input) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public RawTransportProcessOutput handle(Integer idTransportProcess) {
		return transportProcessService.calculateTransportProcessInformation(idTransportProcess);
	}

}
