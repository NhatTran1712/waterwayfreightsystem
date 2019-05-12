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
	private AccountRepository accountRepository;
	
	@Autowired
	public void setCargoRepository(@Qualifier("PostgresCargoRepository")
		CargoRepository cargoRepository, AccountRepository accountRepository) {
		this.cargoRepository = cargoRepository;
		this.accountRepository = accountRepository;
	}
	

	@Override
	public List<RawCargoOutput> initDataCargo() {
		List<RawCargoOutput> rawCargoOutputs = new ArrayList<>();
		Optional<Account> account = accountRepository.findByUsername("user");
		
		if(!account.isPresent()) {
			throw new IllegalArgumentException("Account user not exist!");
		}
		Account owner = account.get();
		List<Cargo> cargos = cargoRepository.findByOwner(owner);
		
		if(cargos.size() < 2) {
			Cargo cargo1 = Cargo.builder()
					.idCargo(null)
					.owner(owner)
					.cargoWeight((float)1.0)
					.build();
			
			cargoRepository.save(cargo1);
			rawCargoOutputs.add(RawCargoMapper.INSTANCE.fromCargo(cargo1));
			Cargo cargo2 = Cargo.builder()
					.idCargo(null)
					.owner(owner)
					.cargoWeight((float)2.0)
					.build();
			
			cargoRepository.save(cargo2);
			rawCargoOutputs.add(RawCargoMapper.INSTANCE.fromCargo(cargo2));
		}
		account = accountRepository.findByUsername("nhat");
		
		if(!account.isPresent()) {
			throw new IllegalArgumentException("Account nhat not exist!");
		}
		owner = account.get();
		cargos = cargoRepository.findByOwner(owner);
		
		if(cargos.size() < 2) {
			Cargo cargo3 = Cargo.builder()
					.idCargo(null)
					.owner(owner)
					.cargoWeight((float)1.0)
					.build();
			
			cargoRepository.save(cargo3);
			rawCargoOutputs.add(RawCargoMapper.INSTANCE.fromCargo(cargo3));
			Cargo cargo4 = Cargo.builder()
					.idCargo(null)
					.owner(owner)
					.cargoWeight((float)2.0)
					.build();
			
			cargoRepository.save(cargo4);
			rawCargoOutputs.add(RawCargoMapper.INSTANCE.fromCargo(cargo4));
		}
		return rawCargoOutputs;
	}

	@Override
	public List<RawCargoOutput> findAllCargos() {
		List<Cargo> cargos = cargoRepository.findAll();
		List<RawCargoOutput> rawCargoOutputs = new ArrayList<>();
		
		for(Cargo cargo : cargos) {
			RawCargoOutput rawCargoOutput = RawCargoMapper.INSTANCE.fromCargo(cargo);
			rawCargoOutput.setIdOwner(RawCargoMapper.INSTANCE.fromAccount(cargo.getOwner()));
			rawCargoOutputs.add(rawCargoOutput);
		}
		return rawCargoOutputs;
	}
	
	@Override
	public List<RawCargoOutput> getCargosOfCustomer(Long idUser) {
		Optional<Account> existingOne = accountRepository.findById(idUser);
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
	public RawCargoOutput newCargo(RawCargoInput rawCargoInput) {
		Cargo cargo = RawCargoMapper.INSTANCE.fromRawInput(rawCargoInput);
		Account account = RawCargoMapper.INSTANCE.toAccount(rawCargoInput.getIdOwner());
		
		cargo.setOwner(account);
		cargoRepository.save(cargo);
		return RawCargoMapper.INSTANCE.fromCargo(cargo);
	}

	@Override
	public RawCargoOutput updateCargo(RawCargoInput rawCargoInput) {
		Optional<Cargo> existingOne = cargoRepository.findById(rawCargoInput.getIdCargo());
		
		if(!existingOne.isPresent()) {
			throw new IllegalArgumentException("Cargo not existed");
		}
		Cargo cargo = RawCargoMapper.INSTANCE.fromRawInput(rawCargoInput);
		
		cargoRepository.save(cargo);
		return RawCargoMapper.INSTANCE.fromCargo(cargo);
	}

	@Override
	public RawCargoOutput deleteCargo(Long idCargo) {
		Optional<Cargo> existingOne = cargoRepository.findById(idCargo);
		
		if(!existingOne.isPresent()) {
			throw new IllegalArgumentException("Cargo not existed!");
		}
		cargoRepository.deleteById(idCargo);
		System.out.println("Delete cargo " + idCargo + "successful");
		return RawCargoMapper.INSTANCE.fromCargo(existingOne.get());
	}
}
