package org.apptopia.waterwayfreightsystem.api.api.application;

import java.util.List;

import org.apptopia.waterwayfreightsystem.api.api.application.usecases.ship.RawShipInput;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.ship.RawShipOutput;

public interface ShipService {
	List<RawShipOutput> findAllShips();
	RawShipOutput updateStatusForShip(RawShipInput rawShipInput);
}
