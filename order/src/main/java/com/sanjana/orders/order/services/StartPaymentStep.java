package com.sanjana.orders.order.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sanjana.orders.order.entity.OrderLineItem;
import com.sanjana.orders.order.entity.Orders;
import com.sanjana.orders.order.repository.PaymentRepository;

@Component
public class StartPaymentStep extends AbstractStep {

	private static final Logger LOGGER = LoggerFactory.getLogger(StartPaymentStep.class);
	
	@Autowired
	private CreateOrderLineItemsStep nextStep;
	
	@Autowired
	private PaymentRepository paymentRepo;
	@Override
	public void execute(Object object) throws Exception {
		LOGGER.info("payment started");
		Orders order = (Orders) object;		
		paymentRepo.save(order.getPayment());
		
	}

	@Override
	public void next(Object object) {
		nextStep.mustExecute(object);

	}

}
