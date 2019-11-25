package org.apptopia.waterwayfreightsystem.api.api.application.usecases.account;

import java.util.HashSet;
import java.util.Set;

import org.apptopia.waterwayfreightsystem.api.api.authentication.account.Account;
import org.apptopia.waterwayfreightsystem.api.api.authentication.role.Role;
import org.apptopia.waterwayfreightsystem.api.api.authentication.role.RoleName;
import org.apptopia.waterwayfreightsystem.api.api.authentication.role.RoleRepository;
import org.apptopia.waterwayfreightsystem.api.api.location.model.City;
import org.apptopia.waterwayfreightsystem.api.api.location.model.District;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper
public interface RawAccountMapper {
	@Autowired
	public static final RoleRepository roleRepository = null;
	
	RawAccountMapper INSTANCE = Mappers.getMapper(RawAccountMapper.class);

	public Account fromRawInput(RawAccountInput rawAccountInput);

	public RawAccountOutput fromAccount(Account account);
	
	default Set<Role> toRoles(Set<String> role){
    	Set<Role> roles = new HashSet<>();
    	 
    	role.forEach(data -> {
    		switch (data) {
    	    case "admin":
    	    	Role adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN)
    	        	.orElseThrow(() -> new RuntimeException ("Fail! -> Cause: User Role not find."));
    	        roles.add(adminRole);
    	        break;
    	    case "manager":
    	        Role managerRole = roleRepository.findByName(RoleName.ROLE_MANAGER)
    	            .orElseThrow(() -> new RuntimeException ("Fail! -> Cause: User Role not find."));
    	        roles.add(managerRole);   	 
    	        break;
    	    default:
    	        Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
    	            .orElseThrow(() -> new RuntimeException ("Fail! -> Cause: User Role not find."));
    	        roles.add(userRole);
    	    }
    	});
    	return roles;
	}
	
	default Set<String> fromRoles(Set<Role> roles) {
		Set<String> role = new HashSet<>();
   	 
    	roles.forEach(data -> {
    		switch (data.getName()) {
    	    case ROLE_ADMIN:
    	        role.add("admin");
    	        break;
    	    case ROLE_MANAGER:
    	        role.add("manager");   	 
    	        break;
    	    default:
    	        role.add("user");
    	    }
    	});
    	return role;
	}
	
	default City toCity(Long idCity) {
		if(idCity == null || idCity == 0) {
			return null;
		}
		return new City(idCity);
	}
	
	default Long fromCity(City city) {
		if(city == null) {
			return null;
		}
		return city.getIdCity();
	}
	
	default District toDistrict(Long idDist) {
		if(idDist == null || idDist == 0) {
			return null;
		}
		return new District(idDist);
	}
	
	default Long fromDistrict(District dist) {
		if(dist == null) {
			return null;
		}
		return dist.getIdDist();
	}
}
