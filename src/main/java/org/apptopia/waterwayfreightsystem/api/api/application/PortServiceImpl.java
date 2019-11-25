package org.apptopia.waterwayfreightsystem.api.api.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apptopia.waterwayfreightsystem.api.api.application.usecases.port.RawPortMapper;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.port.RawPortOutput;
import org.apptopia.waterwayfreightsystem.api.api.port.model.Port;
import org.apptopia.waterwayfreightsystem.api.api.port.model.PortRepository;
import org.apptopia.waterwayfreightsystem.api.api.port.model.PortType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PortServiceImpl implements PortService{
	private PortRepository portRepository;
	
	@Autowired
	public void setPortRepository(@Qualifier("PostgresPortRepository") PortRepository
		portRepository) {
		this.portRepository = portRepository;
	}
	
	@Override
	public void initDataPort() {
		Optional<Port> existingOne = portRepository.findByNamePort("Ben cang xang dau Cai Lan");
		Port port1;
		
		if(!existingOne.isPresent()) {
			port1 = Port.builder()
					.idPort(null)
					.portDepend(null)
					.namePort("Ben cang xang dau Cai Lan")
					.portAddress("quang ninh")
					.loadingAllow(5000)
					.portType(PortType.I)
					.build();
			
			portRepository.save(port1);
		}
		else {
			port1 = existingOne.get();
		}
		existingOne = portRepository.findByNamePort("Ben cang Nam Ninh");
		if(!existingOne.isPresent()) {
			Port port2 = Port.builder()
					.idPort(null)
					.portDepend(port1)
					.namePort("Ben cang Nam Ninh")
					.portAddress("hai phong")
					.loadingAllow(3000)
					.portType(PortType.IA)
					.build();
			
			portRepository.save(port2);
		}
		existingOne = portRepository.findByNamePort("Ben cang Thinh Long");
		Port port3;
		if(!existingOne.isPresent()) {
			port3 = Port.builder()
					.idPort(null)
					.portDepend(null)
					.namePort("Ben cang Thinh Long")
					.portAddress("nam dinh")
					.loadingAllow(200)
					.portType(PortType.II)
					.build();
			
			portRepository.save(port3);
		}
		else {
			port3 = existingOne.get();
		}
		existingOne = portRepository.findByNamePort("Ben cang xuat nhap xang dau Hai Ha");
		if(!existingOne.isPresent()) {
			Port port4 = Port.builder()
					.idPort(null)
					.portDepend(port3)
					.namePort("Ben cang xuat nhap xang dau Hai Ha")
					.portAddress("thai binh")
					.loadingAllow(3000)
					.portType(PortType.II)
					.build();
			
			portRepository.save(port4);
		}
	}
}
