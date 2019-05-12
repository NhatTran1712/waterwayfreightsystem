package org.apptopia.waterwayfreightsystem.api.api.application;

import java.util.List;

import org.apptopia.waterwayfreightsystem.api.api.application.usecases.cargo.RawCargoInput;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.cargo.RawCargoOutput;

public interface CargoService {
	List<RawCargoOutput> initDataCargo();
	List<RawCargoOutput> findAllCargos();
	List<RawCargoOutput> getCargosOfCustomer(Long idUser);
	RawCargoOutput newCargo(RawCargoInput rawCargoInput);
	RawCargoOutput updateCargo(RawCargoInput rawCargoInput);
	RawCargoOutput deleteCargo(Long idCargo);
}
