package org.apptopia.waterwayfreightsystem.api.api.application.usecases.account;

import org.apptopia.waterwayfreightsystem.api.api.authentication.account.Account;
import org.apptopia.waterwayfreightsystem.api.api.location.model.City;
import org.apptopia.waterwayfreightsystem.api.api.location.model.District;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RawAccountMapper {

	RawAccountMapper INSTANCE = Mappers.getMapper(RawAccountMapper.class);

	public Account fromRawInput(RawAccountInput rawAccountInput);

	public RawAccountOutput fromAccount(Account account);
	
	default City toCity(Long idCity) {
		if(idCity == null || idCity == 0) {
			return null;
		}
		return new City(idCity);
	}
	
	default Long fromCity(City city) {
		if(city == null) {
			return null;
		}
		return city.getIdCity();
	}
	
	default District toDistrict(Long idDist) {
		if(idDist == null || idDist == 0) {
			return null;
		}
		return new District(idDist);
	}
	
	default Long fromDistrict(District dist) {
		if(dist == null) {
			return null;
		}
		return dist.getIdDist();
	}
}
