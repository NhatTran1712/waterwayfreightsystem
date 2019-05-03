package org.apptopia.waterwayfreightsystem.api.api.application;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apptopia.waterwayfreightsystem.api.api.application.usecases.transportprocess.RawTransportProcessMapper;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.transportprocess.RawTransportProcessOutput;
import org.apptopia.waterwayfreightsystem.api.api.core.model.Orders;
import org.apptopia.waterwayfreightsystem.api.api.core.model.OrdersRepository;
import org.apptopia.waterwayfreightsystem.api.api.core.model.TransportProcess;
import org.apptopia.waterwayfreightsystem.api.api.core.model.TransportProcessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class TransportProcessServiceImpl implements TransportProcessService {
	private TransportProcessRepository transportProcessRepository;
	private OrdersRepository ordersRepository;
	
	@Autowired
	public void setRepository(@Qualifier("PostgresTransportProcessRepository")
		TransportProcessRepository transportProcessRepository,
		@Qualifier("PostgresOrdersRepository") OrdersRepository ordersRepository) {
		
		this.transportProcessRepository = transportProcessRepository;
		this.ordersRepository = ordersRepository;
	}
	
	@Override
	public List<RawTransportProcessOutput> findAllTransportProcesses() {
		List<TransportProcess> transportProcesses = transportProcessRepository.findAll();
		List<RawTransportProcessOutput> transportProcessOutputs = new ArrayList<>();
		
		for(TransportProcess transportProcess : transportProcesses) {
			transportProcessOutputs.add(RawTransportProcessMapper.INSTANCE
				.fromTransportProcess(transportProcess));
		}
		return transportProcessOutputs;
	}

	@Override
	public RawTransportProcessOutput calculateTransportProcessInformation
		(Integer idTransportProcess) {
		Optional<TransportProcess> existingOneOptional = transportProcessRepository
				.findById(idTransportProcess);
		double calculateTime = 0.0; // unit: day
		Duration transportDuration;
		double dayPeriod;
		
		if(!existingOneOptional.isPresent()) {
			throw new IllegalArgumentException("Transport Process not existed");
		}
		TransportProcess transportProcess = existingOneOptional.get();
		
		if(transportProcess.getShip().getTravelProblem() != null) {
			// realTime (h) = realTime of Ship + time of travel problem
			calculateTime = Math.ceil((transportProcess.getShip().getRealTime()
				+ transportProcess.getShip().getTravelProblem().getTimeExtend())/24.0);
		}
		else {
			calculateTime = Math.ceil(transportProcess.getShip().getRealTime()/24.0);
		}
		transportProcess.setRealDay((int) calculateTime);
		transportProcess.setDateArrive(transportProcess.getDateDepart()
			.plusDays((int) calculateTime));
		transportDuration = Duration.between(LocalDateTime.now(),
			transportProcess.getDateArrive());
		dayPeriod = Math.ceil(transportDuration.toMinutes()/1440.0);
		transportProcess.setDayRemaining((long) dayPeriod);
		transportProcessRepository.save(transportProcess);
		return RawTransportProcessMapper.INSTANCE.fromTransportProcess(transportProcess);
	}

	@Override
	public RawTransportProcessOutput initializeTransportProcessInformation(
		Integer idTransportProcess) {
		Optional<TransportProcess> existingOneTransPro = transportProcessRepository.findById(
			idTransportProcess);
		TransportProcess transportProcess;
		Optional<Orders> existingOneOrd = ordersRepository.findById(idTransportProcess);
		double realDay = 0.0; //day
		Duration dayRemaining;
		
		if(!existingOneTransPro.isPresent()) {
			transportProcess = new TransportProcess(idTransportProcess);
		}
		else {
			transportProcess = existingOneTransPro.get();
		}
		if(!existingOneOrd.isPresent()) {
			throw new IllegalArgumentException("Order not existed");
		}
		Orders order = existingOneOrd.get();
		
		transportProcess.setOrder(order);
		transportProcess.setShip(order.getShipTransport());
		transportProcess.setTransportProcessStatus(order.getShipTransport().getShipStatus());
		realDay = Math.ceil(order.getShipTransport().getSchedule().getEstimateTime()/24.0);
		transportProcess.setRealDay((int) realDay);
		transportProcess.setDateDepart(order.getShipTransport().getSchedule().getDateDepart());
		transportProcess.setDateArrive(order.getShipTransport().getSchedule().getDateArrive());
		dayRemaining = Duration.between(LocalDateTime.now(),order.getShipTransport()
			.getSchedule().getDateArrive());
		transportProcess.setDayRemaining(dayRemaining.toDays());
		transportProcessRepository.save(transportProcess);
		return RawTransportProcessMapper.INSTANCE.fromTransportProcess(transportProcess);
	}

}
