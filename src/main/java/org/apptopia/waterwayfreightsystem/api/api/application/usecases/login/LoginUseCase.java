package org.apptopia.waterwayfreightsystem.api.api.application.usecases.login;

import org.apptopia.waterwayfreightsystem.api.api.application.usecases.UseCase;
import org.apptopia.waterwayfreightsystem.api.api.authentication.Account;
import org.apptopia.waterwayfreightsystem.api.api.authentication.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginUseCase implements UseCase<LoginInput, LoginOutput> {
	private AccountRepository accountRepository;
	
	@Autowired
	public void setAccountRepository(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	@Override
	public LoginOutput handle(LoginInput input) {
		Account account = accountRepository.findByUsername(input.getUsername());
		return AccountMapper.INSTANCE.fromAccount(account);
	}
	
}
