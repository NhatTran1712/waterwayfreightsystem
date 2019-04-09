package org.apptopia.waterwayfreightsystem.api.api.port.model;

import java.util.List;

public interface PortRepository {
	
	Port save(Port port);
	List<Port> findAll();
}
