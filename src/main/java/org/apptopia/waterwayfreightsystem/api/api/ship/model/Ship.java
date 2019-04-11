package org.apptopia.waterwayfreightsystem.api.api.ship.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.apptopia.waterwayfreightsystem.api.api.authentication.Account;
import org.apptopia.waterwayfreightsystem.api.api.core.model.Schedule;
import org.apptopia.waterwayfreightsystem.api.api.core.model.TravelProblem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data
@AllArgsConstructor
@NoArgsConstructor
public class Ship {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idShip;
	@ManyToOne
	private Schedule schedule;
	@OneToOne
	private TravelProblem travelProblem;
	private Float shipCapacity;
	private Float shipSpeed;
	@Enumerated(EnumType.STRING)
	private ShipStatus shipStatus;
	private Float realDistance;
	private Float realTime;
	@ManyToOne
	private Account whoManager;
}
