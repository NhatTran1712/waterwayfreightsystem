package org.apptopia.waterwayfreightsystem.api.api.core.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.apptopia.waterwayfreightsystem.api.api.authentication.Account;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity @Data
@AllArgsConstructor
@NoArgsConstructor
@Builder @ToString
public class Cargo {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCargo;
	@ManyToOne
	private Account owner;
	private Float cargoWeight;
	private String describe;
}
