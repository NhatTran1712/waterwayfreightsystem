package org.apptopia.waterwayfreightsystem.api.api.application.usecases.location;

import javax.annotation.Generated;
import org.apptopia.waterwayfreightsystem.api.api.location.model.District;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-11-26T02:38:55+0700",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_202 (Oracle Corporation)"
)
public class RawDistrictMapperImpl implements RawDistrictMapper {

    @Override
    public District fromRawInput(RawDistrictInput rawDistrictInput) {
        if ( rawDistrictInput == null ) {
            return null;
        }

        District district = new District();

        district.setIdDist( rawDistrictInput.getIdDist() );
        district.setName( rawDistrictInput.getName() );

        return district;
    }

    @Override
    public RawDistrictOutput fromDistrict(District district) {
        if ( district == null ) {
            return null;
        }

        RawDistrictOutput rawDistrictOutput = new RawDistrictOutput();

        rawDistrictOutput.setIdDist( district.getIdDist() );
        rawDistrictOutput.setName( district.getName() );

        return rawDistrictOutput;
    }
}
