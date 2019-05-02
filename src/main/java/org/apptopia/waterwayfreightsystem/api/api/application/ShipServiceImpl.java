package org.apptopia.waterwayfreightsystem.api.api.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apptopia.waterwayfreightsystem.api.api.application.usecases.ship.RawShipInput;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.ship.RawShipMapper;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.ship.RawShipOutput;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.travelproblem.RawTravelProblemInput;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.travelproblem.RawTravelProblemMapper;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.travelproblem.RawTravelProblemOutput;
import org.apptopia.waterwayfreightsystem.api.api.authentication.Account;
import org.apptopia.waterwayfreightsystem.api.api.core.model.TravelProblem;
import org.apptopia.waterwayfreightsystem.api.api.core.model.TravelProblemRepository;
import org.apptopia.waterwayfreightsystem.api.api.ship.model.Ship;
import org.apptopia.waterwayfreightsystem.api.api.ship.model.ShipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ShipServiceImpl implements ShipService {
	private ShipRepository shipRepository;
	private TravelProblemRepository travelProblemRepository;
	
	@Autowired
	public void setShipService(@Qualifier("PostgresShipRepository")
		ShipRepository shipRepository, @Qualifier("PostgresTravelProblemRepository")
		TravelProblemRepository travelProblemRepository) {
		
		this.shipRepository = shipRepository;
		this.travelProblemRepository = travelProblemRepository;
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

	@Override
	public RawShipOutput updateStatusForShip(RawShipInput rawShipInput) {
		Optional<Ship> existingOne = shipRepository.findById(rawShipInput.getIdShip());
		
		if(!existingOne.isPresent()) {
			throw new IllegalArgumentException("Ship not existed");
		}
		Ship ship = existingOne.get();
		
		ship.setShipStatus(rawShipInput.getShipStatus());
		shipRepository.save(ship);
		return RawShipMapper.INSTANCE.fromShip(ship);
	}

	@Override
	public RawTravelProblemOutput newTravelProblem(RawTravelProblemInput rawTravelProblemInput) {
		TravelProblem travelProblem = RawTravelProblemMapper.INSTANCE
			.fromRawInput(rawTravelProblemInput);
		Account account = RawTravelProblemMapper.INSTANCE.toAccount(rawTravelProblemInput
			.getWhoManage());
		
		travelProblem.setWhoManage(account);
		travelProblemRepository.save(travelProblem);
		return RawTravelProblemMapper.INSTANCE.fromTravelProblem(travelProblem);
	}
	
}