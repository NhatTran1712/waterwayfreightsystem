package org.apptopia.waterwayfreightsystem.api.api;

import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;

import org.apptopia.waterwayfreightsystem.api.api.application.usecases.account.AddNewAccountUseCase;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.account.RawAccountInput;
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
import org.springframework.web.bind.annotation.ResponseBody;
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
	private AddNewAccountUseCase addNewAccountUseCase;
	
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

	@Autowired
	public void setUseCaseService(AddNewAccountUseCase addNewAccountUseCase) {
		this.addNewAccountUseCase = addNewAccountUseCase;
	}
	
    @RequestMapping(value = {"/login"}, produces = "application/json",
    		consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> login(@Valid @RequestBody LoginForm loginForm) {
    	System.out.println("login: "+ loginForm.toString());
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
    @ResponseBody
    public ResponseEntity<?> registerUser(@Valid @RequestBody RawAccountInput signUpInfo) {
    	if(accountRepository.existsByUsername(signUpInfo.getUsername())) {
    		return new ResponseEntity<>(new ResponseMessage("Fail -> Username is already taken!"),
    				HttpStatus.BAD_REQUEST);
    	}
    	if (!signUpInfo.getPassConfirm().equals(signUpInfo.getPassword())) {
    	    return new ResponseEntity<>(new ResponseMessage("Fail -> Password not match!"),
    	          HttpStatus.BAD_REQUEST);
    	}
	    this.addNewAccountUseCase.handle(signUpInfo);
	    return new ResponseEntity<>(new ResponseMessage("User registered successfully!"),
    		HttpStatus.OK);
    }
}
