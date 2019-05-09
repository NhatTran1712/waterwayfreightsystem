package org.apptopia.waterwayfreightsystem.api.api.application.usecases.schedule;

import org.apptopia.waterwayfreightsystem.api.api.authentication.Account;
import org.apptopia.waterwayfreightsystem.api.api.core.model.Schedule;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RawScheduleMapper {
	RawScheduleMapper INSTANCE = Mappers.getMapper(RawScheduleMapper.class);
	
	public Schedule fromRawInput(RawScheduleInput rawScheduleInput);
	
	public RawScheduleOutput fromSchedule(Schedule schedule);
	
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
