package org.apptopia.waterwayfreightsystem.api.api.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apptopia.waterwayfreightsystem.api.api.application.usecases.account.RawAccountInput;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.account.RawAccountMapper;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.account.RawAccountOutput;
import org.apptopia.waterwayfreightsystem.api.api.authentication.Account;
import org.apptopia.waterwayfreightsystem.api.api.authentication.AccountRepository;
import org.apptopia.waterwayfreightsystem.api.api.authentication.AccountType;
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

	@Override
	public List<RawAccountOutput> findAccountByAccountType(String accountType) {
		List<RawAccountOutput> rawAccountOutputs = new ArrayList<>();
		
		if(accountType.equals("staff")) {
			List<Account> admins = accountRepository.findByAccountType(AccountType.ADMIN);
			List<Account> managers = accountRepository.findByAccountType(AccountType.MANAGER);
			for(Account admin : admins) {
				rawAccountOutputs.add(RawAccountMapper.INSTANCE.fromAccount(admin));
			}
			for(Account manager : managers) {
				rawAccountOutputs.add(RawAccountMapper.INSTANCE.fromAccount(manager));
			}
			return rawAccountOutputs;
		}
		List<Account> users = accountRepository.findByAccountType(AccountType.USER);
		
		for(Account user : users) {
			rawAccountOutputs.add(RawAccountMapper.INSTANCE.fromAccount(user));
		}
		return rawAccountOutputs;
	}
}
