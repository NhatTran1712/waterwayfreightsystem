package org.apptopia.waterwayfreightsystem.api.api.application.usecases.rawupdate;

import org.apptopia.waterwayfreightsystem.api.api.application.CargoService;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.UseCase;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.cargo.RawCargoInput;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.cargo.RawCargoOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateCargoUseCase implements UseCase<RawCargoInput,RawCargoOutput>{
	@Autowired CargoService cargoService;
	
	@Override
	public RawCargoOutput handle(RawCargoInput input) {
		return cargoService.updateCargo(input);
	}
}
