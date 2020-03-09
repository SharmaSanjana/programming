package com.sanjana.orders.order.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.sanjana.orders.order.entity.Orders;
import com.sanjana.orders.order.services.StartOrderStep;

@RestController
public class OrdersController {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrdersController.class);
	
	@Autowired
	private StartOrderStep startOrderStep;
	
	@PostMapping("/orders")
	public void postOrder(@RequestBody Orders order) {
		LOGGER.info(" at post order controller");
		startOrderStep.mustExecute(order);
		
	}
}
