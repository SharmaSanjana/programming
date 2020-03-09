package com.sanjana.orders.order.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sanjana.orders.order.entity.Orders;
import com.sanjana.orders.order.repository.OrderRepository;

@Component
public class CreateOrderStep extends AbstractStep {

	private static final Logger LOGGER = LoggerFactory.getLogger(CreateOrderStep.class);
	
	@Autowired
	private SendEmailToMerchant nextStep;
	@Autowired
	private OrderRepository orderRepo;
	@Override
	public void execute(Object object) throws Exception {
		Orders order = (Orders) object;

		orderRepo.save(order);
	}

	@Override
	public void next(Object object) {
		nextStep.mustExecute(object);

	}

}
