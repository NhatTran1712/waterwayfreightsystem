package org.apptopia.waterwayfreightsystem.api.api.application;

import java.util.List;

import org.apptopia.waterwayfreightsystem.api.api.application.usecases.ship.RawShipInput;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.ship.RawShipOutput;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.travelproblem.RawTravelProblemInput;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.travelproblem.RawTravelProblemOutput;

public interface ShipService {
	List<RawShipOutput> findAllShips();
	RawShipOutput updateStatusForShip(RawShipInput rawShipInput);
	RawTravelProblemOutput newTravelProblem(RawTravelProblemInput rawTravelProblemInput);
	RawTravelProblemOutput updateTravelProblem(RawTravelProblemInput rawTravelProblemInput);
}
