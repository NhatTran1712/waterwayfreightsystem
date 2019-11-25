package org.apptopia.waterwayfreightsystem.api.api.infrastructure;

import java.util.Optional;

import org.apptopia.waterwayfreightsystem.api.api.authentication.account.Account;
import org.apptopia.waterwayfreightsystem.api.api.authentication.account.AccountRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;;

@Service
@Qualifier("PostgresAccountRepository")
public interface PostgresAccountRepositoryImpl extends JpaRepository<Account, Long>, AccountRepository, 
	JpaSpecificationExecutor {
	default Optional<Account> findOne(Long idUser) {
		return findById(idUser);
	}
}
