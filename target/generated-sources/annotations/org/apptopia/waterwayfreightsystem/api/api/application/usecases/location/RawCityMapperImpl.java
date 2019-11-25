package org.apptopia.waterwayfreightsystem.api.api.application.usecases.location;

import javax.annotation.Generated;
import org.apptopia.waterwayfreightsystem.api.api.location.model.City;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-11-26T02:38:54+0700",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_202 (Oracle Corporation)"
)
public class RawCityMapperImpl implements RawCityMapper {

    @Override
    public City fromRawInput(RawCityInput rawCityInput) {
        if ( rawCityInput == null ) {
            return null;
        }

        City city = new City();

        city.setIdCity( rawCityInput.getIdCity() );
        city.setName( rawCityInput.getName() );

        return city;
    }

    @Override
    public RawCityOutput fromCity(City city) {
        if ( city == null ) {
            return null;
        }

        RawCityOutput rawCityOutput = new RawCityOutput();

        rawCityOutput.setIdCity( city.getIdCity() );
        rawCityOutput.setName( city.getName() );

        return rawCityOutput;
    }
}
