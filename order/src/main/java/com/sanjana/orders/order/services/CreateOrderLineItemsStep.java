package com.sanjana.orders.order.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sanjana.orders.order.entity.OrderLineItem;
import com.sanjana.orders.order.entity.Orders;
import com.sanjana.orders.order.repository.OrderLineItemRepository;

@Component
public class CreateOrderLineItemsStep extends AbstractStep {

	private static final Logger LOGGER = LoggerFactory.getLogger(CreateOrderLineItemsStep.class);
	
	@Autowired
	private UpdateInventoryStep nextStep;
	
	@Autowired
	private OrderLineItemRepository orderLineItemRepo;
	
	@Override
	public void execute(Object object) throws Exception {
		
		Orders order = (Orders)object;
		
		for(OrderLineItem orderLineItem : order.getItems()) {
			orderLineItemRepo.save(orderLineItem);
		}
		

	}

	@Override
	public void next(Object object) {
		nextStep.mustExecute(object);

	}

}
