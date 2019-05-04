package org.apptopia.waterwayfreightsystem.api.api.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apptopia.waterwayfreightsystem.api.api.application.usecases.cargo.RawCargoInput;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.cargo.RawCargoMapper;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.cargo.RawCargoOutput;
import org.apptopia.waterwayfreightsystem.api.api.authentication.Account;
import org.apptopia.waterwayfreightsystem.api.api.authentication.AccountRepository;
import org.apptopia.waterwayfreightsystem.api.api.core.model.Cargo;
import org.apptopia.waterwayfreightsystem.api.api.core.model.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class CargoServiceImpl implements CargoService {
	private CargoRepository cargoRepository;
	private AccountRepository accoutRepository;
	
	@Autowired
	public void setCargoRepository(@Qualifier("PostgresCargoRepository")
		CargoRepository cargoRepository, AccountRepository accountRepository) {
		this.cargoRepository = cargoRepository;
		this.accoutRepository = accountRepository;
	}
	
	@Override
	public List<RawCargoOutput> getCargosOfCustomer(Integer idUser) {
		Optional<Account> existingOne = accoutRepository.findById(idUser);
		List<RawCargoOutput> rawCargoOutputs = new ArrayList<>();
		
		if(!existingOne.isPresent()) {
			throw new IllegalArgumentException("Account not existed");
		}
		List<Cargo> cargos = cargoRepository.findByOwner(existingOne.get());
		
		for(Cargo cargo : cargos) {
			rawCargoOutputs.add(RawCargoMapper.INSTANCE.fromCargo(cargo));
		}
		return rawCargoOutputs;
	}

	@Override
	public List<RawCargoOutput> findAllCargos() {
		List<Cargo> cargos = cargoRepository.findAll();
		List<RawCargoOutput> rawCargoOutputs = new ArrayList<>();
		
		for(Cargo cargo : cargos) {
			rawCargoOutputs.add(RawCargoMapper.INSTANCE.fromCargo(cargo));
		}
		return rawCargoOutputs;
	}

	@Override
	public RawCargoOutput newCargo(RawCargoInput rawCargoInput) {
		Cargo cargo = RawCargoMapper.INSTANCE.fromRawInput(rawCargoInput);
		Account account = RawCargoMapper.INSTANCE.toAccount(rawCargoInput.getIdOwner());
		
		cargo.setOwner(account);
		cargoRepository.save(cargo);
		return RawCargoMapper.INSTANCE.fromCargo(cargo);
	}

}
