package org.apptopia.waterwayfreightsystem.api.api.core.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.apptopia.waterwayfreightsystem.api.api.authentication.Account;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data
@AllArgsConstructor
@NoArgsConstructor
public class TravelProblem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idTravelProblem;
	private String description;
	private Float timeExtend;
	private Integer distanceExtend;
	@ManyToOne
	private Account whoManage;
	
	public TravelProblem(Integer idTravelProblem) {
		this.idTravelProblem = idTravelProblem;
	}
}