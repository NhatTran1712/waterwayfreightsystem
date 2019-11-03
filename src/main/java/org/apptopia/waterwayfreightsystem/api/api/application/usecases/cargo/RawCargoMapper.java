package org.apptopia.waterwayfreightsystem.api.api.application.usecases.cargo;

import org.apptopia.waterwayfreightsystem.api.api.authentication.account.Account;
import org.apptopia.waterwayfreightsystem.api.api.core.model.Cargo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RawCargoMapper {
	RawCargoMapper INSTANCE = Mappers.getMapper(RawCargoMapper.class);
	
	public Cargo fromRawInput(RawCargoInput rawCargoInput);
	
	public RawCargoOutput fromCargo(Cargo cargo);
	
	default Account toAccount(Long idOwner) {
		if(idOwner == null || idOwner == 0) {
			return null;
		}
		return new Account(idOwner);
	}
	
	default Long fromAccount(Account owner) {
		if(owner == null) {
			return null;
		}
		return owner.getIdUser();
	}
}
