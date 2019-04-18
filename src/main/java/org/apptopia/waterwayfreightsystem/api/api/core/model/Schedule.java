package org.apptopia.waterwayfreightsystem.api.api.core.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.apptopia.waterwayfreightsystem.api.api.authentication.Account;
import org.apptopia.waterwayfreightsystem.api.api.port.model.Port;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data
@AllArgsConstructor
@NoArgsConstructor
public class Schedule {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idSchedule;
	@OneToMany
	private List<Port> visitingPorts;
	private Integer estimateDistance;
	private Integer estimateTime;
	private LocalDateTime dateDepart;
	private LocalDateTime dateArrive;
	@ManyToOne
	private Account whoManage;
	
	public Schedule(Integer idSchedule) {
		this.idSchedule = idSchedule;
	}
}
