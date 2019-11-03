package org.apptopia.waterwayfreightsystem.api.api;

import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;

import org.apptopia.waterwayfreightsystem.api.api.authentication.account.Account;
import org.apptopia.waterwayfreightsystem.api.api.authentication.account.AccountRepository;
import org.apptopia.waterwayfreightsystem.api.api.authentication.core.model.LoginForm;
import org.apptopia.waterwayfreightsystem.api.api.authentication.core.model.ResponseMessage;
import org.apptopia.waterwayfreightsystem.api.api.authentication.core.model.SignUpForm;
import org.apptopia.waterwayfreightsystem.api.api.authentication.jwt.JwtProvider;
import org.apptopia.waterwayfreightsystem.api.api.authentication.jwt.JwtResponse;
import org.apptopia.waterwayfreightsystem.api.api.authentication.role.Role;
import org.apptopia.waterwayfreightsystem.api.api.authentication.role.RoleName;
import org.apptopia.waterwayfreightsystem.api.api.authentication.role.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/authenticate")
public class AuthenticationController {
	private AuthenticationManager authenticationManager;
	private AccountRepository accountRepository;
	private RoleRepository roleRepository;
	private PasswordEncoder encoder;
	private JwtProvider jwtProvider;
	
	@Autowired
	public void setAuthenticationManager(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}
	 
	@Autowired
	public void setRepository(AccountRepository accountRepository,
			RoleRepository roleRepository) {
		this.accountRepository = accountRepository;
		this.roleRepository = roleRepository;
	}
	 
    
	@Autowired
	public void setPasswordEncoder(PasswordEncoder encoder) {
		this.encoder = encoder;
	}
	 
	@Autowired
	public void setJwtProvider(JwtProvider jwtProvider) {
		this.jwtProvider = jwtProvider;
	}
	
    @RequestMapping(value = {"/login"}, produces = "application/json",
    		consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public ResponseEntity<?> login(@Valid @RequestBody LoginForm loginForm) {
    	Authentication authentication = authenticationManager.authenticate(
    			new UsernamePasswordAuthenticationToken(loginForm.getUsername(),
    			loginForm.getPassword()));
    	 
    	SecurityContextHolder.getContext().setAuthentication(authentication);
    	String jwt = jwtProvider.generateJwtToken(authentication);
    	UserDetails userDetails = (UserDetails) authentication.getPrincipal();
    	 
    	return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUsername(), userDetails.getAuthorities()));
    }
    
    @RequestMapping(value = {"/signup"}, produces = "application/json",
    		consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpForm signUpRequest) {
    	if(accountRepository.existsByUsername(signUpRequest.getUsername())) {
    		return new ResponseEntity<>(new ResponseMessage("Fail -> Username is already taken!"),
    				HttpStatus.BAD_REQUEST);
    	}
    	if (!signUpRequest.getPasswordConfirm().equals(signUpRequest.getPassword())) {
    	    return new ResponseEntity<>(new ResponseMessage("Fail -> Password not match!"),
    	          HttpStatus.BAD_REQUEST);
    	}
	    Account acc = new Account(signUpRequest.getUsername(), encoder.encode(signUpRequest
	    		.getPassword()), signUpRequest.getFullname(), signUpRequest.getAddress(),
	    		signUpRequest.getPhoneNumber(), signUpRequest.getIdCard()); 
    	Set<String> strRoles = signUpRequest.getRole();
    	Set<Role> roles = new HashSet<>();
    	 
    	strRoles.forEach(role -> {
    		switch (role) {
    	    case "admin":
    	    	Role adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN)
    	        	.orElseThrow(() -> new RuntimeException
    	        	("Fail! -> Cause: User Role not find."));
    	        roles.add(adminRole);
    	        break;
    	    case "manager":
    	        Role mRole = roleRepository.findByName(RoleName.ROLE_MANAGER)
    	            .orElseThrow(() -> new RuntimeException
    	            ("Fail! -> Cause: User Role not find."));
    	        roles.add(mRole);   	 
    	        break;
    	    default:
    	        Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
    	            .orElseThrow(() -> new RuntimeException
    	            ("Fail! -> Cause: User Role not find."));
    	        roles.add(userRole);
    	    }
    	});
    	 
    	acc.setRoles(roles);
    	accountRepository.save(acc);
    	return new ResponseEntity<>(new ResponseMessage("User registered successfully!"),
    			HttpStatus.OK);
    }
}
