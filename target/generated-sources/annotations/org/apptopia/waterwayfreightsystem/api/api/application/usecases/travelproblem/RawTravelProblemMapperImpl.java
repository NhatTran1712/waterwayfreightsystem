package org.apptopia.waterwayfreightsystem.api.api.application.usecases.travelproblem;

import javax.annotation.Generated;
import org.apptopia.waterwayfreightsystem.api.api.core.model.TravelProblem;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-05-08T16:20:38+0700",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_201 (Oracle Corporation)"
)
public class RawTravelProblemMapperImpl implements RawTravelProblemMapper {

    @Override
    public TravelProblem fromRawInput(RawTravelProblemInput rawTravelProblemInput) {
        if ( rawTravelProblemInput == null ) {
            return null;
        }

        TravelProblem travelProblem = new TravelProblem();

        travelProblem.setIdTravelProblem( rawTravelProblemInput.getIdTravelProblem() );
        travelProblem.setDescription( rawTravelProblemInput.getDescription() );
        travelProblem.setTimeExtend( rawTravelProblemInput.getTimeExtend() );
        travelProblem.setDistanceExtend( rawTravelProblemInput.getDistanceExtend() );
        travelProblem.setWhoManage( toAccount( rawTravelProblemInput.getWhoManage() ) );

        return travelProblem;
    }

    @Override
    public RawTravelProblemOutput fromTravelProblem(TravelProblem travelProblem) {
        if ( travelProblem == null ) {
            return null;
        }

        RawTravelProblemOutput rawTravelProblemOutput = new RawTravelProblemOutput();

        rawTravelProblemOutput.setIdTravelProblem( travelProblem.getIdTravelProblem() );
        rawTravelProblemOutput.setDescription( travelProblem.getDescription() );
        rawTravelProblemOutput.setTimeExtend( travelProblem.getTimeExtend() );
        rawTravelProblemOutput.setDistanceExtend( travelProblem.getDistanceExtend() );
        rawTravelProblemOutput.setWhoManage( fromAccount( travelProblem.getWhoManage() ) );

        return rawTravelProblemOutput;
    }
}
