package org.apptopia.waterwayfreightsystem.api.api;

import org.apptopia.waterwayfreightsystem.api.api.authentication.AccountRepository;

import java.util.Optional;

import org.apptopia.waterwayfreightsystem.api.api.authentication.Account;
import org.apptopia.waterwayfreightsystem.api.api.authentication.AccountType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.password.PasswordEncoder;
 
@SpringBootApplication
@ComponentScan(basePackages = "org.apptopia.waterwayfreightsystem.api.api")
public class WaterwayFreightSystemApp extends SpringBootServletInitializer {
	@Autowired PasswordEncoder passwordEncoder;
	@Autowired AccountRepository accountRepository;
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(WaterwayFreightSystemApp.class);
	}
	
    public static void main(String[] args) {
        SpringApplication.run(WaterwayFreightSystemApp.class, args);
    }
    
    @Bean
	public CommandLineRunner init(final AccountRepository accountRepository) {
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				Optional<Account> account = accountRepository.findByUsername("admin");
				
				if(!account.isPresent()) {
					Account account1 = Account.builder()
						.idUser(null)
						.username("admin")
						.password(passwordEncoder.encode("12345678"))
						.accountType(AccountType.ADMIN)
						.build();
					
					accountRepository.save(account1);
				}
				account = accountRepository.findByUsername("manager");
				
				if(!account.isPresent()) {
					Account account2 = Account.builder()
						.idUser(null)
						.username("manager")
						.password(passwordEncoder.encode("12345678"))
						.accountType(AccountType.MANAGER)
						.build();
					accountRepository.save(account2);
				}
				account = accountRepository.findByUsername("user");
				
				if(!account.isPresent()) {
					Account account3 = Account.builder()
						.idUser(null)
						.username("user")
						.password(passwordEncoder.encode("12345678"))
						.accountType(AccountType.USER)
						.build();
					accountRepository.save(account3);
				}
				account = accountRepository.findByUsername("nhat");
				
				if(!account.isPresent()) {
					Account account4 = Account.builder()
						.idUser(null)
						.username("nhat")
						.password(passwordEncoder.encode("12345678"))
						.accountType(AccountType.USER)
						.build();
					accountRepository.save(account4);
				}
				
			}
		};
    }
}