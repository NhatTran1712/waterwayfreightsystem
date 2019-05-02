package org.apptopia.waterwayfreightsystem.api.api.ship.model;

import java.util.List;
import java.util.Optional;

public interface ShipRepository {
	
	Ship save(Ship ship);
	List<Ship> findAll();
	Optional<Ship> findById(Integer idShip);
}
