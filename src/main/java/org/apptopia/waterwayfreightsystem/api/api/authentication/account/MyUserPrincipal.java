package org.apptopia.waterwayfreightsystem.api.api.authentication.account;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.apptopia.waterwayfreightsystem.api.api.authentication.account.Account;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MyUserPrincipal implements UserDetails {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String username;
	@JsonIgnore
	private String password;
	private String fullname;
	private String address;
	private String phoneNumber;
	private String idCard;
	private Collection<? extends GrantedAuthority> authorities;
	
	public static MyUserPrincipal build(Account account) {
        List<GrantedAuthority> authorities = account.getRoles().stream().map(role ->
                new SimpleGrantedAuthority(role.getName().name())).collect(Collectors.toList());
 
        return new MyUserPrincipal(
                account.getIdUser(),
                account.getUsername(),
                account.getPassword(),
                account.getFullname(),
                account.getAddress(),
                account.getPhoneNum(),
                account.getIdCard(),
                authorities
        );
    }
 
    public Long getId() {
        return id;
    }

    @Override
    public String getUsername() {
        return username;
    }
 
    @Override
    public String getPassword() {
        return password;
    }
    
    public String getFullname() {
        return fullname;
    }
    
    public String getAddress() {
    	return address;
    }
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }
 
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
 
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
 
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
 
    @Override
    public boolean isEnabled() {
        return true;
    }
 
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        MyUserPrincipal user = (MyUserPrincipal) o;
        return Objects.equals(id, user.id);
    }
}
