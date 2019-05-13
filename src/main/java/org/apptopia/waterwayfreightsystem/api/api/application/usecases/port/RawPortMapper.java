package org.apptopia.waterwayfreightsystem.api.api.application.usecases.port;

import org.apptopia.waterwayfreightsystem.api.api.port.model.Port;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RawPortMapper {
	RawPortMapper INSTANCE = Mappers.getMapper(RawPortMapper.class);
	
	public Port fromRawInput(RawPortInput rawPortInput);
	
	public RawPortOutput fromPort(Port port);
	
	default Port toPortDepend(Long idPort) {
		if(idPort == null || idPort == 0) {
			return null;
		}
		return new Port(idPort);
	}
	
	default Long fromPortDepend(Port port) {
		if(port == null) {
			return null;
		}
		return port.getIdPort();
	}
}
