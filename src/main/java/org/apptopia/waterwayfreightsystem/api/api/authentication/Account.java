package org.apptopia.waterwayfreightsystem.api.api.authentication;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Data;

@Entity
@Data @Builder
public class Account {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idUser;
	@Column(nullable = false, unique = true)
	private String username;
	private String password;
	@Enumerated(EnumType.STRING)
    private AccountType accountType;
	private String fullname;
	private String address;
	private String phoneNumber;
	private String idCard;
}
