package org.apptopia.waterwayfreightsystem.api.api.location.model;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
	Optional<City> findByIdCity(Long idCity);
}
