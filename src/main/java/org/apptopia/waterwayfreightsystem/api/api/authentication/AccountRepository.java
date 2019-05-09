package org.apptopia.waterwayfreightsystem.api.api.authentication;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

import org.apptopia.waterwayfreightsystem.api.api.authentication.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
	
	Optional<Account> findByUsername(String username);
	default Optional<Account> findOne(Long idUser) {
		return findById(idUser);
	}
	List<Account> findByAccountType(AccountType accountType);
	Optional<Account> findByIdUser(Long id);
}
