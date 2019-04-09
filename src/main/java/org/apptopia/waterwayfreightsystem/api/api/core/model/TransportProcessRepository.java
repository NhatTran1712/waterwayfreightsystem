package org.apptopia.waterwayfreightsystem.api.api.core.model;

import java.util.List;

public interface TransportProcessRepository {
	
	TransportProcess save(TransportProcess transportProcess);
	List<TransportProcess> findAll();
}
