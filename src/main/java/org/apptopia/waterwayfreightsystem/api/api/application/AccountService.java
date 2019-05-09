package org.apptopia.waterwayfreightsystem.api.api.application;

import java.util.List;

import org.apptopia.waterwayfreightsystem.api.api.application.usecases.account.RawAccountInput;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.account.RawAccountOutput;

public interface AccountService {
	
	RawAccountOutput newAccount(RawAccountInput rawAccountInput);
	RawAccountOutput updateAccount(RawAccountInput rawAccountInput);
	List<RawAccountOutput> findAccountByAccountType(String accountType);
	RawAccountOutput findAccountByUserName(String username);
	RawAccountOutput findAccountById(Long idUser);
}
