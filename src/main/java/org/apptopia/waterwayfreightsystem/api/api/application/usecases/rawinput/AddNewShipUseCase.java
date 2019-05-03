package org.apptopia.waterwayfreightsystem.api.api.application.usecases.rawinput;

import org.apptopia.waterwayfreightsystem.api.api.application.ShipService;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.UseCase;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.ship.RawShipInput;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.ship.RawShipOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddNewShipUseCase implements UseCase<RawShipInput,RawShipOutput> {
	@Autowired ShipService shipService;
	
	@Override
	public RawShipOutput handle(RawShipInput rawShipInput) {
		return shipService.newShip(rawShipInput);
	}
	
}
