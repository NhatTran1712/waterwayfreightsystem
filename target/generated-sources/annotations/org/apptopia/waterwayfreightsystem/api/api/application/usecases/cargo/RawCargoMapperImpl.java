package org.apptopia.waterwayfreightsystem.api.api.application.usecases.cargo;

import javax.annotation.Generated;
import org.apptopia.waterwayfreightsystem.api.api.core.model.Cargo;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-05-10T16:12:43+0700",
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

        return cargo;
    }

    @Override
    public RawCargoOutput fromCargo(Cargo cargo) {
        if ( cargo == null ) {
            return null;
        }

        RawCargoOutput rawCargoOutput = new RawCargoOutput();

        rawCargoOutput.setCargoWeight( cargo.getCargoWeight() );

        return rawCargoOutput;
    }
}
