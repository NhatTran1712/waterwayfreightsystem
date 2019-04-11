package org.apptopia.waterwayfreightsystem.api.api.core.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.apptopia.waterwayfreightsystem.api.api.ship.model.Ship;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data @AllArgsConstructor
public class Orders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idOrder;
	@ManyToOne
	private Ship shipTransport;
	@OneToMany
	private List<Cargo> cargos;
	private String senderAddress;
	private String receiverAddress;
	private Integer orderExpense;
}
