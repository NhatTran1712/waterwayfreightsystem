package org.apptopia.waterwayfreightsystem.api.api.application;

import java.util.ArrayList;
import java.util.List;

import org.apptopia.waterwayfreightsystem.api.api.application.usecases.account.RawAccountInput;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.account.RawAccountMapper;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.cargo.RawCargoMapper;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.cargo.RawCargoOutput;
import org.apptopia.waterwayfreightsystem.api.api.authentication.Account;
import org.apptopia.waterwayfreightsystem.api.api.core.model.Cargo;
import org.apptopia.waterwayfreightsystem.api.api.core.model.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class CargoServiceImpl implements CargoService {
	private CargoRepository cargoRepository;
	
	@Autowired
	public void setCargoService(@Qualifier("PostgresCargoRepository")
		CargoRepository cargoRepository) {
		this.cargoRepository = cargoRepository;
	}
	
	@Override
	public List<RawCargoOutput> getCargosOfCustomer(RawAccountInput rawAccountInput) {
		Account account = RawAccountMapper.INSTANCE.fromRawInput(rawAccountInput);
		List<Cargo> cargos = cargoRepository.findByOwner(account);
		List<RawCargoOutput> rawCargoOutputs = new ArrayList<>();
		
		for(Cargo cargo : cargos) {
			rawCargoOutputs.add(RawCargoMapper.INSTANCE.fromCargo(cargo));
		}
		return rawCargoOutputs;
	}

}
