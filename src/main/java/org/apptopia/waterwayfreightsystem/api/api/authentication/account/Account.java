package org.apptopia.waterwayfreightsystem.api.api.authentication.account;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.apptopia.waterwayfreightsystem.api.api.authentication.role.Role;
import org.apptopia.waterwayfreightsystem.api.api.location.model.City;
import org.apptopia.waterwayfreightsystem.api.api.location.model.District;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idUser;
	@Column(nullable = false, unique = true)
	private String username;
	private String password;
	@ManyToMany
	private Set<Role> roles = new HashSet<>();
	private String fullname;
	@ManyToOne
	private City city;
	@ManyToOne
	private District dist;
	private String address;
	private String phoneNum;
	private String idCard;
	
	public Account(String username, String password, String fullname, City city, District dist,
		String address, String phoneNum, String idCard) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.city = city;
        this.dist = dist;
        this.address = address;
        this.phoneNum = phoneNum;
        this.idCard = idCard;
    }
	
	public Account(Long idUser) {
		this.idUser = idUser;
	}
}
