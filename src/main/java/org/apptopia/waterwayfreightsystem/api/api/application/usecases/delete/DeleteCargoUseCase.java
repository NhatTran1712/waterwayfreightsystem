package org.apptopia.waterwayfreightsystem.api.api.application.usecases.delete;

import org.apptopia.waterwayfreightsystem.api.api.application.CargoService;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.UseCase;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.cargo.RawCargoInput;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.cargo.RawCargoOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteCargoUseCase implements UseCase<RawCargoInput,RawCargoOutput> {
	@Autowired CargoService cargoService;
	
	@Override
	public RawCargoOutput handle(RawCargoInput input) {
		// TODO Auto-generated method stub
		return null;
	}

	public RawCargoOutput handle(Long idCargo) {
		return cargoService.deleteCargo(idCargo);
	}
}
