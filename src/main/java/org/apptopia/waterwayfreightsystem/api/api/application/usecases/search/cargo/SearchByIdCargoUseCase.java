package org.apptopia.waterwayfreightsystem.api.api.application.usecases.search.cargo;

import org.apptopia.waterwayfreightsystem.api.api.application.CargoService;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.UseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SearchByIdCargoUseCase implements UseCase<SearchByIdCargoInput,SearchByIdCargoOutput> {
	@Autowired CargoService cargoService;
	
	@Override
	public SearchByIdCargoOutput handle(SearchByIdCargoInput input) {
		return cargoService.findCargoByIdCargo(input);
	}

}
