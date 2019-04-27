package org.apptopia.waterwayfreightsystem.api.api.core.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.apptopia.waterwayfreightsystem.api.api.authentication.Account;
import org.apptopia.waterwayfreightsystem.api.api.ship.model.Ship;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idOrder;
	@ManyToOne
	private Ship shipTransport;
	@OneToMany
	private List<Cargo> cargos;
	@OneToOne
	private Account whoReceive;
	private Integer orderExpense;
	
	public Orders(Integer idOrders) {
		this.idOrder = idOrders;
	}
}
