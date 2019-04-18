package org.apptopia.waterwayfreightsystem.api.api.authentication;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

import org.apptopia.waterwayfreightsystem.api.api.authentication.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {
	
	Account findByUsername(String username);
	default Optional<Account> findOne(Integer idUser) {
		return findById(idUser);
	}
}
