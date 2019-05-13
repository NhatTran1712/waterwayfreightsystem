package org.apptopia.waterwayfreightsystem.api.api.port.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity @Data
@AllArgsConstructor
@NoArgsConstructor
@Builder @ToString
public class Port {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long idPort;
	@OneToOne
	private Port portDepend;
	private String namePort;
	private String portAddress;
	private Integer loadingAllow;
	@Enumerated(EnumType.STRING)
	private PortType portType;
//	private Integer timeTransfer;
	
	public Port(Long idPort) {
		this.idPort = idPort;
	}
}
