package org.apptopia.waterwayfreightsystem.api.api.application.usecases.rawinput;

import org.apptopia.waterwayfreightsystem.api.api.application.ShipService;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.UseCase;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.travelproblem.RawTravelProblemInput;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.travelproblem.RawTravelProblemOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddNewTravelProblemUseCase implements UseCase<RawTravelProblemInput,
	RawTravelProblemOutput> {
	@Autowired ShipService shipService;
	
	@Override
	public RawTravelProblemOutput handle(RawTravelProblemInput rawTravelProblemInput) {
		return shipService.newTravelProblem(rawTravelProblemInput);
	}

}
