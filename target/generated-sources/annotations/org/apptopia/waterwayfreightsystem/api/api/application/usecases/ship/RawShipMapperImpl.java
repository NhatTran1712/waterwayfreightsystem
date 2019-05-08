package org.apptopia.waterwayfreightsystem.api.api.application.usecases.ship;

import javax.annotation.Generated;
import org.apptopia.waterwayfreightsystem.api.api.ship.model.Ship;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-05-08T16:20:38+0700",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_201 (Oracle Corporation)"
)
public class RawShipMapperImpl implements RawShipMapper {

    @Override
    public Ship fromRawInput(RawShipInput rawShipInput) {
        if ( rawShipInput == null ) {
            return null;
        }

        Ship ship = new Ship();

        ship.setIdShip( rawShipInput.getIdShip() );
        ship.setShipCapacity( rawShipInput.getShipCapacity() );
        ship.setShipSpeed( rawShipInput.getShipSpeed() );
        ship.setShipStatus( rawShipInput.getShipStatus() );
        ship.setRealDistance( rawShipInput.getRealDistance() );
        ship.setRealTime( rawShipInput.getRealTime() );
        ship.setWhoManager( toAccount( rawShipInput.getWhoManager() ) );

        return ship;
    }

    @Override
    public RawShipOutput fromShip(Ship ship) {
        if ( ship == null ) {
            return null;
        }

        RawShipOutput rawShipOutput = new RawShipOutput();

        rawShipOutput.setShipCapacity( ship.getShipCapacity() );
        rawShipOutput.setShipSpeed( ship.getShipSpeed() );
        rawShipOutput.setShipStatus( ship.getShipStatus() );
        rawShipOutput.setRealDistance( ship.getRealDistance() );
        rawShipOutput.setRealTime( ship.getRealTime() );
        rawShipOutput.setWhoManager( fromAccount( ship.getWhoManager() ) );

        return rawShipOutput;
    }
}
