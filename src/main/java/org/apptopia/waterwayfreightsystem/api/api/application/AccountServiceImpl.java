package org.apptopia.waterwayfreightsystem.api.api.application;

import java.util.Optional;

import org.apptopia.waterwayfreightsystem.api.api.application.usecases.account.RawAccountInput;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.account.RawAccountMapper;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.account.RawAccountOutput;
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
	
	@Override
	@Transactional
	public RawAccountOutput updateAccount(RawAccountInput rawAccountInput) {
		
		if(rawAccountInput.getIdUser() == null) {
			throw new IllegalArgumentException("Account not exist!");
		}
		Optional<Account> existingOneOptional = accountRepository.findOne(
			rawAccountInput.getIdUser());
		
		if(! existingOneOptional.isPresent()) {
			throw new IllegalArgumentException("Account not exist!");
		}
		Account account = RawAccountMapper.INSTANCE.fromRawInput(rawAccountInput);
		accountRepository.save(account);
		return RawAccountMapper.INSTANCE.fromAccount(account);
	}
}
