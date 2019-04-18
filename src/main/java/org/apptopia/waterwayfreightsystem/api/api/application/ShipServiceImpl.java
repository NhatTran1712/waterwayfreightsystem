package org.apptopia.waterwayfreightsystem.api.api.application;

import java.util.ArrayList;
import java.util.List;

import org.apptopia.waterwayfreightsystem.api.api.application.usecases.ship.RawShipMapper;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.ship.RawShipOutput;
import org.apptopia.waterwayfreightsystem.api.api.ship.model.Ship;
import org.apptopia.waterwayfreightsystem.api.api.ship.model.ShipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ShipServiceImpl implements ShipService {
	private ShipRepository shipRepository;
	
	@Autowired
	public void setShipService(@Qualifier("PostgresShipRepository")
		ShipRepository shipRepository) {
		this.shipRepository = shipRepository;
	}
	
	@Override
	public List<RawShipOutput> findAllShips() {
		List<Ship> ships = shipRepository.findAll();
		List<RawShipOutput> rawShipOutputs = new ArrayList<>();
		
		for(Ship ship : ships) {
			rawShipOutputs.add(RawShipMapper.INSTANCE.fromShip(ship));
		}
		return rawShipOutputs;
	}
	
}
