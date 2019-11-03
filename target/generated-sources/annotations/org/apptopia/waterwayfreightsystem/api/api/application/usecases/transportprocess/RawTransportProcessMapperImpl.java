package org.apptopia.waterwayfreightsystem.api.api.application.usecases.transportprocess;

import javax.annotation.Generated;
import org.apptopia.waterwayfreightsystem.api.api.core.model.TransportProcess;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-08-19T11:22:35+0700",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_201 (Oracle Corporation)"
)
public class RawTransportProcessMapperImpl implements RawTransportProcessMapper {

    @Override
    public TransportProcess fromRawInput(RawTransportProcessInput rawTransportProcessInput) {
        if ( rawTransportProcessInput == null ) {
            return null;
        }

        TransportProcess transportProcess = new TransportProcess();

        transportProcess.setIdOrder( rawTransportProcessInput.getIdOrder() );
        transportProcess.setOrder( toOrders( rawTransportProcessInput.getOrder() ) );
        transportProcess.setShip( toShip( rawTransportProcessInput.getShip() ) );
        transportProcess.setTransportProcessStatus( rawTransportProcessInput.getTransportProcessStatus() );
        transportProcess.setRealDay( rawTransportProcessInput.getRealDay() );
        if ( rawTransportProcessInput.getDayRemaining() != null ) {
            transportProcess.setDayRemaining( rawTransportProcessInput.getDayRemaining().longValue() );
        }
        transportProcess.setDateDepart( rawTransportProcessInput.getDateDepart() );
        transportProcess.setDateArrive( rawTransportProcessInput.getDateArrive() );

        return transportProcess;
    }

    @Override
    public RawTransportProcessOutput fromTransportProcess(TransportProcess transportProcess) {
        if ( transportProcess == null ) {
            return null;
        }

        RawTransportProcessOutput rawTransportProcessOutput = new RawTransportProcessOutput();

        rawTransportProcessOutput.setIdOrder( transportProcess.getIdOrder() );
        rawTransportProcessOutput.setTransportProcessStatus( transportProcess.getTransportProcessStatus() );
        rawTransportProcessOutput.setRealDay( transportProcess.getRealDay() );
        if ( transportProcess.getDayRemaining() != null ) {
            rawTransportProcessOutput.setDayRemaining( transportProcess.getDayRemaining().intValue() );
        }
        rawTransportProcessOutput.setDateDepart( transportProcess.getDateDepart() );
        rawTransportProcessOutput.setDateArrive( transportProcess.getDateArrive() );

        return rawTransportProcessOutput;
    }
}
