package org.apptopia.waterwayfreightsystem.api.api.application;

import java.util.List;

import org.apptopia.waterwayfreightsystem.api.api.application.usecases.location.RawCityOutput;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.location.RawDistrictOutput;

public interface LocationService {
	List<RawCityOutput> findAllCities();
	List<RawDistrictOutput> findDistrictByCityId(Long idCity);
}
