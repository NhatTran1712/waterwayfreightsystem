package org.apptopia.waterwayfreightsystem.api.api.application.usecases.ship;

import org.apptopia.waterwayfreightsystem.api.api.application.usecases.UseCaseInput;
import org.apptopia.waterwayfreightsystem.api.api.ship.model.ShipStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor
@NoArgsConstructor
public class RawShipInput implements UseCaseInput {
	
    private Integer idShip;
	private Integer schedule;
	private Integer travelProblem;
	private Float shipCapacity;
	private Float shipSpeed;
	private ShipStatus shipStatus;
	private Float realDistance;
	private Float realTime;
	private Integer whoManager;
}
