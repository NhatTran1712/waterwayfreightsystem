package org.apptopia.waterwayfreightsystem.api.api.port.model;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

public class Port {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idPort;
	@OneToOne
	private Port portDepend;
	private String namePort;
	private String portAddress;
	private Integer loadingAllow;
	@Enumerated(EnumType.STRING)
	private PortType portType;
	private Integer timeTransfer;
}
