package org.apptopia.waterwayfreightsystem.api.api.ship;

import java.util.List;

public interface ShipRepository {
	
	Ship save(Ship ship);
	List<Ship> findAll();
}
