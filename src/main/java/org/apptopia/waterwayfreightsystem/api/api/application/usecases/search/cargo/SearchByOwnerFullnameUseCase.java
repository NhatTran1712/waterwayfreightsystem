package org.apptopia.waterwayfreightsystem.api.api.application.usecases.search.cargo;

import org.apptopia.waterwayfreightsystem.api.api.application.CargoService;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.UseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SearchByOwnerFullnameUseCase implements UseCase<SearchByOwnerFullnameInput,
	SearchByOwnerFullnameOutput>{
	@Autowired CargoService cargoService;
	
	@Override
	public SearchByOwnerFullnameOutput handle(SearchByOwnerFullnameInput input) {
		return cargoService.searchCargoByOwnerFullname(input);
	}
}
