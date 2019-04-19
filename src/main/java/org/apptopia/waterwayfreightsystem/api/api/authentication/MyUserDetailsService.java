package org.apptopia.waterwayfreightsystem.api.api.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

import org.apptopia.waterwayfreightsystem.api.api.authentication.Account;
import org.apptopia.waterwayfreightsystem.api.api.authentication.AccountRepository;
import org.apptopia.waterwayfreightsystem.api.api.authentication.MyUserPrincipal;

@Service
public class MyUserDetailsService implements UserDetailsService {
 
    @Autowired
    private AccountRepository accountRepository;
 
    @Override
    public UserDetails loadUserByUsername(String username) {
        Optional<Account> account = accountRepository.findByUsername(username);
        if (!account.isPresent()) {
            throw new UsernameNotFoundException(username);
        }
        return new MyUserPrincipal(account.get());
    }
}
