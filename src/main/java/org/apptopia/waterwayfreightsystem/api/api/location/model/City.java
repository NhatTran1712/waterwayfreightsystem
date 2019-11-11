package org.apptopia.waterwayfreightsystem.api.api.location.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data
@NoArgsConstructor
@AllArgsConstructor
public class City {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCity;
	private String name;
	
	public City(Long idCity) {
		this.idCity = idCity;
	}
}
