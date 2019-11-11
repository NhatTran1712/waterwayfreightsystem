package org.apptopia.waterwayfreightsystem.api.api.application.usecases.location;

import org.apptopia.waterwayfreightsystem.api.api.location.model.City;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RawCityMapper {
	RawCityMapper INSTANCE = Mappers.getMapper(RawCityMapper.class);

	public City fromRawInput(RawCityInput rawCityInput);

	public RawCityOutput fromCity(City city);
}
