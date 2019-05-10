package org.apptopia.waterwayfreightsystem.api.api.application;

import java.util.List;

import org.apptopia.waterwayfreightsystem.api.api.application.usecases.account.RawAccountInput;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.account.RawAccountOutput;

public interface AccountService {
	
	RawAccountOutput newCustomerAccount(RawAccountInput rawAccountInput);
	RawAccountOutput newStaffAccount(RawAccountInput rawAccountInput);
	RawAccountOutput findAccountByUserName(String username);
	RawAccountOutput updateAccount(RawAccountInput rawAccountInput);
	List<RawAccountOutput> findAccountByAccountType(String accountType);
	RawAccountOutput findAccountById(Long idUser);
	List<RawAccountOutput> findAllAccount();
	List<RawAccountOutput> searchAccountByFullname(String fullname);
	void deleteAccount(String username);
}
