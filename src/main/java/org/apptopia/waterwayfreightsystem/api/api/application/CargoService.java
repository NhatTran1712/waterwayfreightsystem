package org.apptopia.waterwayfreightsystem.api.api.application;

import java.util.List;
import java.util.Optional;

import org.apptopia.waterwayfreightsystem.api.api.application.usecases.cargo.RawCargoInput;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.cargo.RawCargoOutput;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.search.SearchByOwnerFullnameInput;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.search.SearchByOwnerFullnameOutput;
import org.apptopia.waterwayfreightsystem.api.api.core.model.Cargo;

public interface CargoService {
	List<RawCargoOutput> initDataCargo();
	List<RawCargoOutput> findAllCargos();
	SearchByOwnerFullnameOutput searchCargoByOwnerFullname(SearchByOwnerFullnameInput
		searchByOwnerFullnameInput);
	RawCargoOutput findCargoByIdCargo(Long idCargo);
//	List<RawCargoOutput> getCargosOfCustomer(Long idUser);
//	RawCargoOutput newCargo(RawCargoInput rawCargoInput);
	RawCargoOutput updateCargo(RawCargoInput rawCargoInput);
	RawCargoOutput deleteCargo(Long idCargo);
}
