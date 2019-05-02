package org.apptopia.waterwayfreightsystem.api.api.application;

import java.util.List;

import org.apptopia.waterwayfreightsystem.api.api.application.usecases.account.RawAccountInput;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.cargo.RawCargoOutput;

public interface CargoService {
	List<RawCargoOutput> getCargosOfCustomer(RawAccountInput rawAccountInput);
	List<RawCargoOutput> findAllCargos();
}
