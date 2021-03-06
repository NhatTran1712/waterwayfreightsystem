package org.apptopia.waterwayfreightsystem.api.api.application;

import java.util.List;

import org.apptopia.waterwayfreightsystem.api.api.application.usecases.account.RawAccountInput;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.account.RawAccountOutput;

public interface AccountService {
	void initDataRole();
	void initDataAccount();
//	RawAccountOutput newCustomerAccount(RawAccountInput rawAccountInput);
//	RawAccountOutput newStaffAccount(RawAccountInput rawAccountInput);
	RawAccountOutput newAccount(RawAccountInput input);
	RawAccountOutput findAccountByUserName(String username);
	RawAccountOutput updateAccount(RawAccountInput rawAccountInput);
	List<RawAccountOutput> findAccountByAccountType(String accountType);
	List<RawAccountOutput> findAllAccount();
	List<RawAccountOutput> searchAccountByFullname(String fullname);
	RawAccountOutput deleteAccount(String username);
}
