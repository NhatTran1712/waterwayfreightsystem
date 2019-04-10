package org.apptopia.waterwayfreightsystem.api.api.application;

import org.apptopia.waterwayfreightsystem.api.api.applications.usecases.addaccount.RawAccountInput;
import org.apptopia.waterwayfreightsystem.api.api.applications.usecases.addaccount.RawAccountMapper;
import org.apptopia.waterwayfreightsystem.api.api.applications.usecases.addaccount.RawAccountOutput;
import org.apptopia.waterwayfreightsystem.api.api.authentication.Account;
import org.apptopia.waterwayfreightsystem.api.api.authentication.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountServiceImpl implements AccountService {
	
	private AccountRepository accountRepository;
	
	@Autowired
	public void setAccountRepository(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}
	
	@Override
	@Transactional
	public RawAccountOutput newAccount(RawAccountInput rawAccountInput){
		Account account = RawAccountMapper.INSTANCE.fromRawInput(rawAccountInput);
		accountRepository.save(account);
		return RawAccountMapper.INSTANCE.fromAccount(account);
	}
}
