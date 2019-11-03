package org.apptopia.waterwayfreightsystem.api.api.authentication.role;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.apptopia.waterwayfreightsystem.api.api.authentication.role.RoleName;
import org.hibernate.annotations.NaturalId;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Role {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idRole;
 
    @Enumerated(EnumType.STRING)
    @NaturalId
    private RoleName name;
}
