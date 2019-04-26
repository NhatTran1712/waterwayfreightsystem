package org.apptopia.waterwayfreightsystem.api.api.application.usecases.transportprocess;

import org.apptopia.waterwayfreightsystem.api.api.core.model.Orders;
import org.apptopia.waterwayfreightsystem.api.api.core.model.TransportProcess;
import org.apptopia.waterwayfreightsystem.api.api.ship.model.Ship;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RawTransportProcessMapper {
	RawTransportProcessMapper INSTANCE = Mappers.getMapper(RawTransportProcessMapper.class);
	
	public TransportProcess fromRawInput(RawTransportProcessInput rawTransportProcessInput);
	
	public RawTransportProcessOutput fromTransportProcess(TransportProcess transportProcess);
	
	default Orders toOrders(Integer idOrders) {
		if(idOrders == null || idOrders == 0) {
			return null;
		}
		return new Orders(idOrders);
	}
	
	default Integer fromOrders(Orders orders) {
		if(orders == null) {
			return null;
		}
		return orders.getIdOrder();
	}
	
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
}
