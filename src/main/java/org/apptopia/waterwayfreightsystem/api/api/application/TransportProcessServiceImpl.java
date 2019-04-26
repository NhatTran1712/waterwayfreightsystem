package org.apptopia.waterwayfreightsystem.api.api.application;

import java.util.ArrayList;
import java.util.List;

import org.apptopia.waterwayfreightsystem.api.api.application.usecases.transportprocess.RawTransportProcessMapper;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.transportprocess.RawTransportProcessOutput;
import org.apptopia.waterwayfreightsystem.api.api.core.model.TransportProcess;
import org.apptopia.waterwayfreightsystem.api.api.core.model.TransportProcessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class TransportProcessServiceImpl implements TransportProcessService {
	private TransportProcessRepository transportProcessRepository;
	
	@Autowired
	public void setTransportProcessService(@Qualifier("PostgresTransportProcessRepository")
		TransportProcessRepository transportProcessRepository) {
		this.transportProcessRepository = transportProcessRepository;
	}
	
	@Override
	public List<RawTransportProcessOutput> findAllTransportProcesses() {
		List<TransportProcess> transportProcesses = transportProcessRepository.findAll();
		List<RawTransportProcessOutput> transportProcessOutputs = new ArrayList<>();
		
		for(TransportProcess transportProcess : transportProcesses) {
			transportProcessOutputs.add(RawTransportProcessMapper.INSTANCE
				.fromTransportProcess(transportProcess));
		}
		return transportProcessOutputs;
	}
	
}
