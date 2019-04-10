package org.apptopia.waterwayfreightsystem.api.api.applications.usecases.addaccount;

import org.apptopia.waterwayfreightsystem.api.api.authentication.Account;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RawAccountMapper {
	
	RawAccountMapper INSTANCE = Mappers.getMapper(RawAccountMapper.class);
	
	public Account fromRawInput(RawAccountInput rawAccountInput);
	public RawAccountOutput fromAccount(Account accout);	
}
