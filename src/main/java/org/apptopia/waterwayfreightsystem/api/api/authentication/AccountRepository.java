package org.apptopia.waterwayfreightsystem.api.api.authentication;

import org.springframework.data.jpa.repository.JpaRepository;
import org.apptopia.waterwayfreightsystem.api.api.authentication.Account;

public interface AccountRepository extends JpaRepository<Account, String> {
	
	Account findByUsername(String username);
	
}
