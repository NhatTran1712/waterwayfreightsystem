package org.apptopia.waterwayfreightsystem.api.api.ship.model;

import java.util.List;

public interface ShipRepository {
	
	Ship save(Ship ship);
	List<Ship> findAll();
}
