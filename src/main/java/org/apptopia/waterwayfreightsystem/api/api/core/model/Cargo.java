package org.apptopia.waterwayfreightsystem.api.api.core.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.apptopia.waterwayfreightsystem.api.api.authentication.Account;

import lombok.Data;

@Entity @Data
public class Cargo {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idCargo;
	private Account owner;
	private Integer cargoWeight;
}
