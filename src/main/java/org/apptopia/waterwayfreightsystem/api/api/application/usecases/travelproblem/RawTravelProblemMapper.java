package org.apptopia.waterwayfreightsystem.api.api.application.usecases.travelproblem;

import org.apptopia.waterwayfreightsystem.api.api.authentication.account.Account;
import org.apptopia.waterwayfreightsystem.api.api.core.model.TravelProblem;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RawTravelProblemMapper {
	RawTravelProblemMapper INSTANCE = Mappers.getMapper(RawTravelProblemMapper.class);
	
	public TravelProblem fromRawInput(RawTravelProblemInput rawTravelProblemInput);
	
	public RawTravelProblemOutput fromTravelProblem(TravelProblem travelProblem);
	
	default Account toAccount(Long idUser) {
		if(idUser == null || idUser == 0) {
			return null;
		}
		return new Account(idUser);
	}
	
	default Long fromAccount(Account account) {
		if(account == null) {
			return null;
		}
		return account.getIdUser();
	}
}
