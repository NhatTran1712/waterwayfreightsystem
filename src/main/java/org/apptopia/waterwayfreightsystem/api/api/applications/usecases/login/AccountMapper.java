package org.apptopia.waterwayfreightsystem.api.api.applications.usecases.login;

import org.apptopia.waterwayfreightsystem.api.api.authentication.Account;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AccountMapper {
	AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);
	
	LoginOutput fromAccount(Account account);
}
