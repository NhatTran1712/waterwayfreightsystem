package org.apptopia.waterwayfreightsystem.api.api.application;

import java.util.List;

import org.apptopia.waterwayfreightsystem.api.api.application.usecases.cargo.RawCargoInput;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.cargo.RawCargoOutput;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.search.cargo.SearchByIdCargoInput;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.search.cargo.SearchByIdCargoOutput;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.search.cargo.SearchByOwnerFullnameInput;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.search.cargo.SearchByOwnerFullnameOutput;

public interface CargoService {
	void initDataCargo();
	List<RawCargoOutput> findAllCargos();
	RawCargoOutput findCargoByIdCargo(Long idCargo);
	SearchByOwnerFullnameOutput searchCargoByOwnerFullname(SearchByOwnerFullnameInput
		searchByOwnerFullnameInput);
	SearchByIdCargoOutput findCargoByIdCargo(SearchByIdCargoInput searchByIdCargoInput);
	List<RawCargoOutput> getCargosOfCustomer(String username);
	List<RawCargoOutput> changetoList(RawCargoOutput rawCargoOutput);
	RawCargoOutput newCargo(RawCargoInput rawCargoInput);
	RawCargoOutput updateCargo(RawCargoInput rawCargoInput);
	RawCargoOutput deleteCargo(Long idCargo);
}
