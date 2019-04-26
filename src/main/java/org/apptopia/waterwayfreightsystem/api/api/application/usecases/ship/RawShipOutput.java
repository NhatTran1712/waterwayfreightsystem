package org.apptopia.waterwayfreightsystem.api.api.application.usecases.ship;

import org.apptopia.waterwayfreightsystem.api.api.application.usecases.UseCaseOutput;
import org.apptopia.waterwayfreightsystem.api.api.ship.model.ShipStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor
@NoArgsConstructor
public class RawShipOutput implements UseCaseOutput {
	
	private Integer schedule;
	private Float shipCapacity;
	private Float shipSpeed;
	private ShipStatus shipStatus;
	private Float realDistance;
	private Float realTime;
	private Integer whoManager;
}
