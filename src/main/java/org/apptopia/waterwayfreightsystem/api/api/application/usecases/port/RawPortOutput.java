package org.apptopia.waterwayfreightsystem.api.api.application.usecases.port;

import org.apptopia.waterwayfreightsystem.api.api.application.usecases.UseCaseOutput;
import org.apptopia.waterwayfreightsystem.api.api.port.model.PortType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor
@NoArgsConstructor
public class RawPortOutput implements UseCaseOutput {
	private Long idPort;
	private Long idPortDepend;
	private String namePort;
	private String portAddress;
	private Integer loadingAllow; //tan
	private PortType portType;
//	private Integer timeTransfer;
}
