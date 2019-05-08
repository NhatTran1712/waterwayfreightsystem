package org.apptopia.waterwayfreightsystem.api.api.authentication;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @Builder
@AllArgsConstructor 
@NoArgsConstructor
public class Account {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idUser;
	@Column(nullable = false, unique = true)
	private String username;
	private String password;
	@Transient
    private String passwordConfirm;
	@Enumerated(EnumType.STRING)
    private AccountType accountType;
	private String fullname;
	private String address;
	private String phoneNumber;
	private String idCard;
	
	public Account(Integer idUser) {
		this.idUser = idUser;
	}
}
