package org.apptopia.waterwayfreightsystem.api.api.location.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data
@NoArgsConstructor
@AllArgsConstructor
public class District {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idDist;
	private String name;
	@ManyToOne
	private City city;
	
	public District(Long idDist) {
		this.idDist = idDist;
	}
}
