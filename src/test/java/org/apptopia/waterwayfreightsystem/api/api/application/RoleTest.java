//package org.apptopia.waterwayfreightsystem.api.api.application;
//
//import static org.junit.Assert.*;
//
//import java.util.HashSet;
//import java.util.List;
//import java.util.Optional;
//import java.util.Set;
//
//import org.apptopia.waterwayfreightsystem.api.api.application.usecases.account.RawAccountOutput;
//import org.apptopia.waterwayfreightsystem.api.api.authentication.account.Account;
//import org.apptopia.waterwayfreightsystem.api.api.authentication.account.AccountRepository;
//import org.apptopia.waterwayfreightsystem.api.api.authentication.role.Role;
//import org.apptopia.waterwayfreightsystem.api.api.authentication.role.RoleName;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//public class RoleTest {
//	@Autowired
//	AccountService accountService;
//	
//	@Autowired
//	@Qualifier("PostgresAccountRepositoryImpl")
//	static
//	AccountRepository accountRepository;
//	
//	@Autowired
//	PasswordEncoder passwordEncoder;
//	
//	@BeforeClass
//	public static void setUpClass() {
//		Set<Role> role = new HashSet<>();
//		role.add( new Role(null, RoleName.ROLE_ADMIN));
//		Account account1 = Account.builder()
//			.username("admin")
//			.password("admin")
//			.roles(role)
//			.fullname("Admin")
//			.address("")
//			.phoneNumber("123")
//			.idCard("123")
//			.build();
//		accountRepository.save(account1);
//    }
//	@Test
//	public void testAccountHasRoleAdmin() {
//		Optional<Account> existOne = accountRepository.findByUsername("admin");
//		
//		existOne.get().getRoles().forEach(eachrole -> {assertEquals(RoleName.ROLE_ADMIN, eachrole.getName());});
//	}
//
//}
