package org.apptopia.waterwayfreightsystem.api.api.location.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistrictRepository extends JpaRepository<District, Long> {
	List<District> findByCity(City city);
}
