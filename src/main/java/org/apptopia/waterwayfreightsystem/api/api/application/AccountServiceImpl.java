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
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
	private AccountRepository accountRepository;
	private PasswordEncoder passwordEncoder;
	private SecurityService securityService;
	
	@Autowired
	public void setAccountRepository(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}
	
	@Autowired
	public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}
	
	@Autowired
	public void setSecurityService(SecurityService sercurityService) {
		this.securityService = sercurityService;
	}
	
	@Override
	public RawAccountOutput newCustomerAccount(RawAccountInput rawAccountInput){
		rawAccountInput.setAccountType(AccountType.USER);
		rawAccountInput.setPassword(passwordEncoder.encode(rawAccountInput.getPassword()));
		Account account = RawAccountMapper.INSTANCE.fromRawInput(rawAccountInput);
		
		accountRepository.save(account);
		securityService.autoLogin(account.getUsername(), account.getPasswordConfirm());
		return RawAccountMapper.INSTANCE.fromAccount(account);
	}
	
	@Override
	public RawAccountOutput newStaffAccount(RawAccountInput rawAccountInput) {
		rawAccountInput.setPassword(passwordEncoder.encode(rawAccountInput.getPassword()));
		Account account = RawAccountMapper.INSTANCE.fromRawInput(rawAccountInput);
		
		accountRepository.save(account);
		return RawAccountMapper.INSTANCE.fromAccount(account);
	}

	@Override
	public RawAccountOutput findAccountByUserName(String username) {
		Optional<Account> existingOne = accountRepository.findByUsername(username);

		if(existingOne.isPresent()) {
			Account account = existingOne.get();
			
			RawAccountOutput rawAccountOutput = RawAccountMapper.INSTANCE.fromAccount(account);			
			return rawAccountOutput;
   	 	}
		return null;
	}

	@Override
	public RawAccountOutput updateAccount(RawAccountInput rawAccountInput) {
		
		if(rawAccountInput.getIdUser() == null) {
			throw new IllegalArgumentException("IdUser is null!");
		}
		Optional<Account> existingOne = accountRepository.findOne(rawAccountInput.getIdUser());
		
		if(!existingOne.isPresent()) {
			throw new IllegalArgumentException("Account not exist!");
		}
		Account account = RawAccountMapper.INSTANCE.fromRawInput(rawAccountInput);
		
		account.setPassword(passwordEncoder.encode(account.getPassword()));
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

	@Override
	public RawAccountOutput findAccountById(Long idUser) {
		Optional<Account> existingOne = accountRepository.findOne(idUser);
		
		if(existingOne.isPresent()) {
			RawAccountOutput rawAccountOutput = RawAccountMapper.INSTANCE.fromAccount(existingOne.get());
			System.out.println(rawAccountOutput.toString());
			return rawAccountOutput;
		}
		return null;
	}
}
