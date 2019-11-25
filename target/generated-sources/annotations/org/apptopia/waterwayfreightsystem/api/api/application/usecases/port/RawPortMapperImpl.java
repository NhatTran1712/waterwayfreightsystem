package org.apptopia.waterwayfreightsystem.api.api.application.usecases.port;

import javax.annotation.Generated;
import org.apptopia.waterwayfreightsystem.api.api.port.model.Port;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-11-26T02:38:55+0700",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_202 (Oracle Corporation)"
)
public class RawPortMapperImpl implements RawPortMapper {

    @Override
    public Port fromRawInput(RawPortInput rawPortInput) {
        if ( rawPortInput == null ) {
            return null;
        }

        Port port = new Port();

        port.setIdPort( rawPortInput.getIdPort() );
        port.setNamePort( rawPortInput.getNamePort() );
        port.setPortAddress( rawPortInput.getPortAddress() );
        port.setLoadingAllow( rawPortInput.getLoadingAllow() );
        port.setPortType( rawPortInput.getPortType() );

        return port;
    }

    @Override
    public RawPortOutput fromPort(Port port) {
        if ( port == null ) {
            return null;
        }

        RawPortOutput rawPortOutput = new RawPortOutput();

        rawPortOutput.setIdPort( port.getIdPort() );
        rawPortOutput.setNamePort( port.getNamePort() );
        rawPortOutput.setPortAddress( port.getPortAddress() );
        rawPortOutput.setLoadingAllow( port.getLoadingAllow() );
        rawPortOutput.setPortType( port.getPortType() );

        return rawPortOutput;
    }
}
