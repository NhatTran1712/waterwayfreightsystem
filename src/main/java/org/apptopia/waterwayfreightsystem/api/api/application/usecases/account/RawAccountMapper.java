package org.apptopia.waterwayfreightsystem.api.api.application.usecases.account;

import org.apptopia.waterwayfreightsystem.api.api.authentication.account.Account;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RawAccountMapper {

	RawAccountMapper INSTANCE = Mappers.getMapper(RawAccountMapper.class);

	public Account fromRawInput(RawAccountInput rawAccountInput);

	public RawAccountOutput fromAccount(Account account);
}
