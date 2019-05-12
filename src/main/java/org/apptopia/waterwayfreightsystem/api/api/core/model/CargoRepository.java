package org.apptopia.waterwayfreightsystem.api.api.core.model;

import java.util.List;
import java.util.Optional;

import org.apptopia.waterwayfreightsystem.api.api.authentication.Account;

public interface CargoRepository {

	Cargo save(Cargo cargo);
	List<Cargo> findAll();
	List<Cargo> findByOwner(Account account);
	Optional<Cargo> findById(Long idCargo);
	void deleteById(Long idCargo);
}
