package org.apptopia.waterwayfreightsystem.api.api;

import org.apptopia.waterwayfreightsystem.api.api.authentication.AccountRepository;
import org.apptopia.waterwayfreightsystem.api.api.authentication.Account;
import org.apptopia.waterwayfreightsystem.api.api.authentication.AccountType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.password.PasswordEncoder;
 
@SpringBootApplication
@ComponentScan(basePackages = "org.apptopia.waterwayfreightsystem.api.api")
public class WaterwayFreightSystemApp {
	
	@Autowired PasswordEncoder passwordEncoder;
	
    public static void main(String[] args) {
        SpringApplication.run(WaterwayFreightSystemApp.class, args);
    }
    
//    @Bean
//	public CommandLineRunner init(final AccountRepository accountRepository) {
//		return new CommandLineRunner() {
//			
//			@Override
//			public void run(String... args) throws Exception {
//				Account account1 = Account.builder()
//						.username("admin")
//						.password(passwordEncoder.encode("123456"))
//						.accountType(AccountType.ADMIN)
//						.build();
//				accountRepository.save(account1);
//				Account account2 = Account.builder()
//						.username("manager")
//						.password(passwordEncoder.encode("123456"))
//						.accountType(AccountType.MANAGER)
//						.build();
//				accountRepository.save(account2);
//				Account account3 = Account.builder()
//						.username("user")
//						.password(passwordEncoder.encode("123456"))
//						.accountType(AccountType.USER)
//						.build();
//				accountRepository.save(account3);
//			}
//		};
//    }
}