package org.apptopia.waterwayfreightsystem.api.api.application;

import java.util.List;

import org.apptopia.waterwayfreightsystem.api.api.application.usecases.cargo.RawCargoInput;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.cargo.RawCargoOutput;

public interface CargoService {
	List<RawCargoOutput> getCargosOfCustomer(Long idUser);
	List<RawCargoOutput> findAllCargos();
	RawCargoOutput newCargo(RawCargoInput rawCargoInput);
	RawCargoOutput updateCargo(RawCargoInput rawCargoInput);
}
