package org.apptopia.waterwayfreightsystem.api.api.application.usecases.orders;

import org.apptopia.waterwayfreightsystem.api.api.authentication.account.Account;
import org.apptopia.waterwayfreightsystem.api.api.core.model.Orders;
import org.apptopia.waterwayfreightsystem.api.api.ship.model.Ship;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RawOrdersMapper {
	RawOrdersMapper INSTANCE = Mappers.getMapper(RawOrdersMapper.class);
	
	public Orders fromRawInput(RawOrdersInput rawOrdersInput);
	
	public RawOrdersOutput fromOrders(Orders orders);
	
	default Ship toShip(Integer idShip) {
		
		if(idShip == null || idShip == 0) {
			return null;
		}
		return new Ship(idShip);
	}
	default Integer fromShip(Ship ship) {
		
		if(ship == null) {
			return null;
		}
		return ship.getIdShip();
	}
	
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
