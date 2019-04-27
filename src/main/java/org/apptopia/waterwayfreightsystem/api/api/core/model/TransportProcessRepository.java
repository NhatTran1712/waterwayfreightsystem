package org.apptopia.waterwayfreightsystem.api.api.core.model;

import java.util.List;
import java.util.Optional;

public interface TransportProcessRepository {
	
	TransportProcess save(TransportProcess transportProcess);
	List<TransportProcess> findAll();
	Optional<TransportProcess> findById(Integer idTransportProcess);
}
