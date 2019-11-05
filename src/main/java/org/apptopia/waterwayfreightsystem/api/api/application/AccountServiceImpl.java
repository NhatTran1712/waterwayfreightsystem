package org.apptopia.waterwayfreightsystem.api.api.application;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.apptopia.waterwayfreightsystem.api.api.application.usecases.account.RawAccountInput;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.account.RawAccountMapper;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.account.RawAccountOutput;
import org.apptopia.waterwayfreightsystem.api.api.authentication.account.Account;
import org.apptopia.waterwayfreightsystem.api.api.authentication.account.AccountRepository;
import org.apptopia.waterwayfreightsystem.api.api.authentication.account.AccountType;
import org.apptopia.waterwayfreightsystem.api.api.authentication.role.Role;
import org.apptopia.waterwayfreightsystem.api.api.authentication.role.RoleName;
import org.apptopia.waterwayfreightsystem.api.api.authentication.role.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
	private AccountRepository accountRepository;
	private RoleRepository roleRepository;
	private PasswordEncoder passwordEncoder;
	private SecurityService securityService;
	
	@Autowired
	public void setRepository(AccountRepository accountRepository,
		RoleRepository roleRepository) {
		this.accountRepository = accountRepository;
		this.roleRepository = roleRepository;
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
	public void initDataRole() {
		if(!roleRepository.findByName(RoleName.ROLE_ADMIN).isPresent()) {
			roleRepository.save(new Role(null, RoleName.ROLE_ADMIN));
		}
		if(!roleRepository.findByName(RoleName.ROLE_MANAGER).isPresent()) {
			roleRepository.save(new Role(null, RoleName.ROLE_MANAGER));
		}
		if(!roleRepository.findByName(RoleName.ROLE_USER).isPresent()) {
			roleRepository.save(new Role(null, RoleName.ROLE_USER));
		}
	}
	
	@Override
	public void initDataAccount(){
		Optional<Account> account = accountRepository.findByUsername("admin");
//		List<RawAccountOutput> rawAccountOutputs = new ArrayList<>();
		Set<Role> role;
		
		if(!account.isPresent()) {
			role = new HashSet<>();
			
			role.add(roleRepository.findByName(RoleName.ROLE_ADMIN).get());
			Account account1 = Account.builder()
				.idUser(null)
				.username("admin")
				.password(passwordEncoder.encode("admin"))
				.roles(role)
				.fullname("Admin")
				.address("")
				.phoneNumber("123")
				.idCard("123")
				.build();
			accountRepository.save(account1);
//			rawAccountOutputs.add(RawAccountMapper.INSTANCE.fromAccount(account1));
		}
		account = accountRepository.findByUsername("manager");
		
		if(!account.isPresent()) {
			role = new HashSet<>();
			
			role.add(roleRepository.findByName(RoleName.ROLE_MANAGER).get());
			Account account2 = Account.builder()
				.idUser(null)
				.username("manager")
				.password(passwordEncoder.encode("manager"))
				.roles(role)
				.fullname("Manager")
				.address("")
				.phoneNumber("345")
				.idCard("345")
				.build();
			accountRepository.save(account2);
//			rawAccountOutputs.add(RawAccountMapper.INSTANCE.fromAccount(account2));
		}
		account = accountRepository.findByUsername("user");
		
		if(!account.isPresent()) {
			role = new HashSet<>();
			
			role.add(roleRepository.findByName(RoleName.ROLE_USER).get());
			Account account3 = Account.builder()
				.idUser(null)
				.username("user")
				.password(passwordEncoder.encode("user"))
				.roles(role)
				.fullname("User")
				.address("")
				.phoneNumber("567")
				.idCard("567")
				.build();
			accountRepository.save(account3);
//			rawAccountOutputs.add(RawAccountMapper.INSTANCE.fromAccount(account3));
		}
		account = accountRepository.findByUsername("nhat");
		
		if(!account.isPresent()) {
			role = new HashSet<>();
			
			role.add(roleRepository.findByName(RoleName.ROLE_USER).get());
			Account account4 = Account.builder()
				.idUser(null)
				.username("nhat")
				.password(passwordEncoder.encode("nhat"))
				.roles(role)
				.fullname("Nhat")
				.address("")
				.phoneNumber("789")
				.idCard("789")
				.build();
			accountRepository.save(account4);
		}
//		return rawAccountOutputs;
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
		
//		if(accountType.equals("staff")) {
//			List<Account> admins = accountRepository.findByAccountType(AccountType.ADMIN);
//			List<Account> managers = accountRepository.findByAccountType(AccountType.MANAGER);
//			for(Account admin : admins) {
//				rawAccountOutputs.add(RawAccountMapper.INSTANCE.fromAccount(admin));
//			}
//			for(Account manager : managers) {
//				rawAccountOutputs.add(RawAccountMapper.INSTANCE.fromAccount(manager));
//			}
//			return rawAccountOutputs;
//		}
//		List<Account> users = accountRepository.findByAccountType(AccountType.USER);
//		
//		for(Account user : users) {
//			rawAccountOutputs.add(RawAccountMapper.INSTANCE.fromAccount(user));
//		}
		return rawAccountOutputs;
	}

	@Override
	public List<RawAccountOutput> findAllAccount() {
		List<Account> accounts = accountRepository.findAll();
		List<RawAccountOutput> rawAccountOutputs = new ArrayList<>();
		
		for(Account account : accounts) {
			rawAccountOutputs.add(RawAccountMapper.INSTANCE.fromAccount(account));
		}
		return rawAccountOutputs;
	}
	
	@Override
	public List<RawAccountOutput> searchAccountByFullname(String fullname) {
		List<Account> accounts = accountRepository.findByFullnameContaining(fullname);
		List<RawAccountOutput> rawAccountOutputs = new ArrayList<>();
		
		if(!accounts.isEmpty()) {
			for(Account account : accounts) {
				rawAccountOutputs.add(RawAccountMapper.INSTANCE.fromAccount(account));
			}
		}
		return rawAccountOutputs;
	}

	@Override
	public RawAccountOutput deleteAccount(String username) {
		Optional<Account> existingOne = accountRepository.findByUsername(username);
		
		if(!existingOne.isPresent()) {
			throw new IllegalArgumentException("Account not exist!");
		}
		Account account = existingOne.get();
//		accountRepository.deleteById(account.getIdUser());
		System.out.println("Delete " + username + "sucessful!");
		return RawAccountMapper.INSTANCE.fromAccount(account);
	}
}
