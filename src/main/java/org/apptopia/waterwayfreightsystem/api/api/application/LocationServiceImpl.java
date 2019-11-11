package org.apptopia.waterwayfreightsystem.api.api.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apptopia.waterwayfreightsystem.api.api.application.usecases.location.RawCityMapper;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.location.RawCityOutput;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.location.RawDistrictMapper;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.location.RawDistrictOutput;
import org.apptopia.waterwayfreightsystem.api.api.location.model.City;
import org.apptopia.waterwayfreightsystem.api.api.location.model.CityRepository;
import org.apptopia.waterwayfreightsystem.api.api.location.model.District;
import org.apptopia.waterwayfreightsystem.api.api.location.model.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationServiceImpl implements LocationService {
	private CityRepository cityRepo;
	private DistrictRepository districtRepo;
	
	@Autowired
	public void setRepository(CityRepository cityRepo, DistrictRepository districtRepo) {
		this.cityRepo = cityRepo;
		this.districtRepo = districtRepo;
	}
	
	@Override
	public List<RawCityOutput> findAllCities() {
		return cityRepo.findAll().stream().map(x -> RawCityMapper.INSTANCE.fromCity(x))
				.collect(Collectors.toList());
	}

	@Override
	public List<RawDistrictOutput> findDistrictByCityId(Long idCity) {
		Optional<City> existingOne = cityRepo.findByIdCity(idCity);
//		List<RawDistrictOutput> rawDistrictOutputs = new ArrayList<>();
		
		if(existingOne.isPresent()) {
//			List<District> dists = districtRepo.findByCity(existingOne.get());
//			
//			for (District dist: dists) {
//				RawDistrictOutput rawDistrictOutput = RawDistrictMapper.INSTANCE.fromDistrict(dist);
//				rawDistrictOutputs.add(rawDistrictOutput);
//			}
			return districtRepo.findByCity(existingOne.get()).stream().map(
				x -> RawDistrictMapper.INSTANCE.fromDistrict(x)).collect(Collectors.toList());
		}
//		return rawDistrictOutputs;
		return null;
	}

}
