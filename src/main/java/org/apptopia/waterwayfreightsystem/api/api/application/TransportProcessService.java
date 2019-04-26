package org.apptopia.waterwayfreightsystem.api.api.application;

import java.util.List;

import org.apptopia.waterwayfreightsystem.api.api.application.usecases.transportprocess.RawTransportProcessOutput;

public interface TransportProcessService {
	List<RawTransportProcessOutput> findAllTransportProcesses();
}
