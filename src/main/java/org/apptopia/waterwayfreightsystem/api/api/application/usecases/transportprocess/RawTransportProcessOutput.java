package org.apptopia.waterwayfreightsystem.api.api.application.usecases.transportprocess;

import java.time.LocalDateTime;

import org.apptopia.waterwayfreightsystem.api.api.application.usecases.UseCaseOutput;
import org.apptopia.waterwayfreightsystem.api.api.ship.model.ShipStatus;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor
@NoArgsConstructor
public class RawTransportProcessOutput implements UseCaseOutput{
	private Integer idOrder;
	private ShipStatus transportProcessStatus;
	private Integer realDay;
	private Integer dayRemaining;
	@JsonDeserialize(using=LocalDateTimeDeserializer.class)
	private LocalDateTime dateDepart;
	@JsonDeserialize(using=LocalDateTimeDeserializer.class)
	private LocalDateTime dateArrive;
}
