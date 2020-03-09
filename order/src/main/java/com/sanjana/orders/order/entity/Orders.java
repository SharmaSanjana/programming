package com.sanjana.orders.order.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Orders {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	private User user;
	
	@OneToMany
	private List<OrderLineItem> items;
	
	private Double orderTotal;
	
	private Date orderDate = new Date();
	@OneToOne
	private Payment payment;

	
}
