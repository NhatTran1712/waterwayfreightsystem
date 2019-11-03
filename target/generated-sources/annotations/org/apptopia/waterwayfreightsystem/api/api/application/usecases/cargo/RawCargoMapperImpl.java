package org.apptopia.waterwayfreightsystem.api.api.application.usecases.cargo;

import javax.annotation.Generated;
import org.apptopia.waterwayfreightsystem.api.api.core.model.Cargo;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-08-19T11:22:35+0700",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_201 (Oracle Corporation)"
)
public class RawCargoMapperImpl implements RawCargoMapper {

    @Override
    public Cargo fromRawInput(RawCargoInput rawCargoInput) {
        if ( rawCargoInput == null ) {
            return null;
        }

        Cargo cargo = new Cargo();

        cargo.setIdCargo( rawCargoInput.getIdCargo() );
        cargo.setCargoWeight( rawCargoInput.getCargoWeight() );
        cargo.setDescribe( rawCargoInput.getDescribe() );

        return cargo;
    }

    @Override
    public RawCargoOutput fromCargo(Cargo cargo) {
        if ( cargo == null ) {
            return null;
        }

        RawCargoOutput rawCargoOutput = new RawCargoOutput();

        rawCargoOutput.setIdCargo( cargo.getIdCargo() );
        rawCargoOutput.setCargoWeight( cargo.getCargoWeight() );
        rawCargoOutput.setDescribe( cargo.getDescribe() );

        return rawCargoOutput;
    }
}
