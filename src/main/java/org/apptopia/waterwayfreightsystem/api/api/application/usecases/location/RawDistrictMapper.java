package org.apptopia.waterwayfreightsystem.api.api.application.usecases.location;

import org.apptopia.waterwayfreightsystem.api.api.location.model.City;
import org.apptopia.waterwayfreightsystem.api.api.location.model.District;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RawDistrictMapper  {
	RawDistrictMapper INSTANCE = Mappers.getMapper(RawDistrictMapper.class);

	public District fromRawInput(RawDistrictInput rawDistrictInput);

	public RawDistrictOutput fromDistrict(District district);
	
//	default City toCity(Long id) {
//		if(id == null || "".equals(id)) {
//			return null;
//		}
//		return new City(id);
//	}
//	
//	default Long fromCity(City city) {
//		if(city == null) {
//			return null;
//		}
//		return city.getIdCity();
//	}
}
