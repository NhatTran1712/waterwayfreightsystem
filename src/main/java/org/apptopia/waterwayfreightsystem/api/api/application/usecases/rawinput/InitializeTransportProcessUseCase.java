package org.apptopia.waterwayfreightsystem.api.api.application.usecases.rawinput;

import org.apptopia.waterwayfreightsystem.api.api.application.TransportProcessService;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.UseCase;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.transportprocess.RawTransportProcessInput;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.transportprocess.RawTransportProcessOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InitializeTransportProcessUseCase implements UseCase<RawTransportProcessInput,
	RawTransportProcessOutput>{
	@Autowired TransportProcessService transportProcessService;
	
	public RawTransportProcessOutput handle(Integer idTransportProcess) {
		return transportProcessService.initializeTransportProcessInformation(idTransportProcess);
	}
	
	@Override
	public RawTransportProcessOutput handle(RawTransportProcessInput input) {
		// TODO Auto-generated method stub
		return null;
	}

}
