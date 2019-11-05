package org.apptopia.waterwayfreightsystem.api.api.authentication.account;

import java.util.List;
import java.util.Optional;

public interface AccountRepository{
	Account save(Account account);
	Optional<Account> findByUsername(String username);
	Optional<Account> findOne(Long idUser);
	List<Account> findAll();
	List<Account> findByFullnameContaining(String fullname);
	Boolean existsByUsername(String username);
}
