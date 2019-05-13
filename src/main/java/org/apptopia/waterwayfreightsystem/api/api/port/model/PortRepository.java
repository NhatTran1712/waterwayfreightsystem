package org.apptopia.waterwayfreightsystem.api.api.port.model;

import java.util.List;
import java.util.Optional;

public interface PortRepository {
	
	Port save(Port port);
	List<Port> findAll();
	Optional<Port> findByNamePort(String namePort);
}
