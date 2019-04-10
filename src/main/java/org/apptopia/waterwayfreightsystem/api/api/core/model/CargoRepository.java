package org.apptopia.waterwayfreightsystem.api.api.core.model;

import java.util.List;

public interface CargoRepository {

	Cargo save(Cargo cargo);
	List<Cargo> findAll();
}
