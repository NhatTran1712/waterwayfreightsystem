package org.apptopia.waterwayfreightsystem.api.api.core.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import org.apptopia.waterwayfreightsystem.api.api.ship.model.Ship;
import org.apptopia.waterwayfreightsystem.api.api.ship.model.ShipStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data
@AllArgsConstructor
@NoArgsConstructor
public class TransportProcess {
	
	@Id
	private Integer idOrder;
	@OneToOne
	private Orders order;
	@OneToOne
	private Ship ship;
	@Enumerated(EnumType.STRING)
	private ShipStatus transportProcessStatus;
	private Integer realDay;
	private Long dayRemaining;
	private LocalDateTime dateDepart;
	private LocalDateTime dateArrive;
	
	public TransportProcess(Integer idOrder) {
		this.idOrder = idOrder;
	}
}
