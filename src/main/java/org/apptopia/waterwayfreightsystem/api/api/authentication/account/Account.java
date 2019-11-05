package org.apptopia.waterwayfreightsystem.api.api.authentication.account;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;

import org.apptopia.waterwayfreightsystem.api.api.authentication.role.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity @ToString
@Data @Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Account {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idUser;
	@Column(nullable = false, unique = true)
	private String username;
	private String password;
	@Transient
    private String passwordConfirm;
	@ManyToMany
	private Set<Role> roles = new HashSet<>();
	private String fullname;
	private String address;
	private String phoneNumber;
	private String idCard;
	
	public Account(String username, String password, String fullname, String address,
		String phoneNumber, String idCard) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.idCard = idCard;
    }
	
	public Account(Long idUser) {
		this.idUser = idUser;
	}
}
