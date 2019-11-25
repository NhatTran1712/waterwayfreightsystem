package org.apptopia.waterwayfreightsystem.api.api.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apptopia.waterwayfreightsystem.api.api.application.usecases.cargo.RawCargoInput;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.cargo.RawCargoMapper;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.cargo.RawCargoOutput;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.search.cargo.SearchByIdCargoInput;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.search.cargo.SearchByIdCargoOutput;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.search.cargo.SearchByOwnerFullnameInput;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.search.cargo.SearchByOwnerFullnameOutput;
import org.apptopia.waterwayfreightsystem.api.api.authentication.account.Account;
import org.apptopia.waterwayfreightsystem.api.api.authentication.account.AccountRepository;
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
	public void initDataCargo() {
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
					.describe("Tui giay mau nau")
					.build();
			
			cargoRepository.save(cargo1);
			Cargo cargo2 = Cargo.builder()
					.idCargo(null)
					.owner(owner)
					.cargoWeight((float)2.0)
					.describe("Hop nhua chu nhat mau trang")
					.build();
			
			cargoRepository.save(cargo2);
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
					.describe("Hop vuong nho mau trang duc")
					.build();
			
			cargoRepository.save(cargo3);
			Cargo cargo4 = Cargo.builder()
					.idCargo(null)
					.owner(owner)
					.cargoWeight((float)2.0)
					.describe("Hop vuong nho goi giay bao")
					.build();
			
			cargoRepository.save(cargo4);
		}
	}

	@Override
	public List<RawCargoOutput> findAllCargos() {
		List<Cargo> cargos = cargoRepository.findAll();
		List<RawCargoOutput> rawCargoOutputs = new ArrayList<>();
		RawCargoOutput rawCargoOutput = new RawCargoOutput();
		
		for(Cargo cargo : cargos) {
			rawCargoOutput = RawCargoMapper.INSTANCE.fromCargo(cargo);
			rawCargoOutput.setIdOwner(RawCargoMapper.INSTANCE.fromAccount(cargo.getOwner()));
			rawCargoOutputs.add(rawCargoOutput);
		}
		return rawCargoOutputs;
	}
	
	@Override
	public RawCargoOutput findCargoByIdCargo(Long idCargo) {
		Optional<Cargo> existingOne = cargoRepository.findById(idCargo);
		
		if(!existingOne.isPresent()) {
			throw new IllegalArgumentException("Cargo not existed!");
		}
		Cargo cargo = existingOne.get();
		RawCargoOutput rawCargoOutput = RawCargoMapper.INSTANCE.fromCargo(cargo);

		rawCargoOutput.setIdOwner(RawCargoMapper.INSTANCE.fromAccount(cargo.getOwner()));
		return rawCargoOutput;
	}

	@Override
	public SearchByOwnerFullnameOutput searchCargoByOwnerFullname(
			SearchByOwnerFullnameInput searchByOwnerFullnameInput) {
		List<Account> accounts = accountRepository.findByFullnameContaining
			(searchByOwnerFullnameInput.getOwnerFullname());
		SearchByOwnerFullnameOutput searchByOwnerFullnameOutput=new SearchByOwnerFullnameOutput();
		List<RawCargoOutput> rawCargoOutputs = new ArrayList<>();
		
		for(Account account : accounts) {
			List<Cargo> cargos = cargoRepository.findByOwner(account);
			
			for(Cargo cargo : cargos) {
				RawCargoOutput rawAccountOutput = RawCargoMapper.INSTANCE.fromCargo(cargo);
				rawAccountOutput.setIdOwner(RawCargoMapper.INSTANCE.fromAccount(cargo.getOwner()));
				rawCargoOutputs.add(rawAccountOutput);
			}
		}
		searchByOwnerFullnameOutput.setRawCargoOutputs(rawCargoOutputs);
		return searchByOwnerFullnameOutput;
	}
	
	@Override
	public SearchByIdCargoOutput findCargoByIdCargo(SearchByIdCargoInput searchByIdCargoInput) {
		Optional<Cargo> existingOne = cargoRepository.findById(searchByIdCargoInput.getIdCargo());
		SearchByIdCargoOutput searchByIdCargoOutput = new SearchByIdCargoOutput();
		
		if(!existingOne.isPresent()) {
			throw new IllegalArgumentException("Cargo not existed!");
		}
		Cargo cargo = existingOne.get();
		
		if(cargo.getOwner().getUsername().equals(searchByIdCargoInput.getOwnerUsername())) {
			RawCargoOutput rawCargoOutput = RawCargoMapper.INSTANCE.fromCargo(cargo);
			
			rawCargoOutput.setIdOwner(RawCargoMapper.INSTANCE.fromAccount(cargo.getOwner()));
			searchByIdCargoOutput.setRawCargoOutput(rawCargoOutput);
		}
		return searchByIdCargoOutput;
	}
	
	@Override
	public List<RawCargoOutput> getCargosOfCustomer(String username) {
		Optional<Account> existingOne = accountRepository.findByUsername(username);
		List<RawCargoOutput> rawCargoOutputs = new ArrayList<>();
		RawCargoOutput rawCargoOutput;
		
		if(!existingOne.isPresent()) {
			throw new IllegalArgumentException("Account not existed");
		}
		List<Cargo> cargos = cargoRepository.findByOwner(existingOne.get());
		
		for(Cargo cargo : cargos) {
			rawCargoOutput = RawCargoMapper.INSTANCE.fromCargo(cargo);
			rawCargoOutput.setIdOwner(RawCargoMapper.INSTANCE.fromAccount(cargo.getOwner()));
			rawCargoOutputs.add(rawCargoOutput);
		}
		return rawCargoOutputs;
	}

	@Override
	public List<RawCargoOutput> changetoList(RawCargoOutput rawCargoOutput) {
		List<RawCargoOutput> rawCargoOutputs = new ArrayList<>();
		
		if(rawCargoOutput == null) {
			return rawCargoOutputs;
		}
		rawCargoOutputs.add(rawCargoOutput);
		return rawCargoOutputs;
	}
	
	@Override
	public RawCargoOutput newCargo(RawCargoInput rawCargoInput) {
		Cargo cargo = RawCargoMapper.INSTANCE.fromRawInput(rawCargoInput);
		
		cargo.setOwner(RawCargoMapper.INSTANCE.toAccount(rawCargoInput.getIdOwner()));
		cargoRepository.save(cargo);
		RawCargoOutput rawCargoOutput = RawCargoMapper.INSTANCE.fromCargo(cargo);
		
		rawCargoOutput.setIdOwner(RawCargoMapper.INSTANCE.fromAccount(cargo.getOwner()));
		return rawCargoOutput;
	}

	@Override
	public RawCargoOutput updateCargo(RawCargoInput rawCargoInput) {
		Optional<Cargo> existingOne = cargoRepository.findById(rawCargoInput.getIdCargo());
		RawCargoOutput rawCargoOutput = new RawCargoOutput();
		
		if(!existingOne.isPresent()) {
			throw new IllegalArgumentException("Cargo not existed");
		}
		Cargo cargo = RawCargoMapper.INSTANCE.fromRawInput(rawCargoInput);
		System.out.println("Cargo: " + cargo.toString());
		cargo.setOwner(RawCargoMapper.INSTANCE.toAccount(rawCargoInput.getIdOwner()));
		cargoRepository.save(cargo);
		rawCargoOutput = RawCargoMapper.INSTANCE.fromCargo(cargo);
		rawCargoOutput.setIdOwner(RawCargoMapper.INSTANCE.fromAccount(cargo.getOwner()));
		System.out.println("RawCargoOutput " + rawCargoOutput.toString());
		return rawCargoOutput;
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
