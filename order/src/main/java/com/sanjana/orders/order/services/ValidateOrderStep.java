package com.sanjana.orders.order.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sanjana.orders.order.exception.InvalidOrderException;

@Component
public class ValidateOrderStep extends AbstractStep {

	private static final Logger LOGGER = LoggerFactory.getLogger(ValidateOrderStep.class);

	/*@Autowired
	private Order order;*/
	@Autowired
	private ValidateProductStep validateProductStep;
	
	@Override
	public void execute(Object object) throws Exception {
		if (validateOrder(object)) {
			LOGGER.info("order is valid");

		} else {
			LOGGER.info("order is invalid");
			throw new InvalidOrderException("order is invalid");
		}

	}

	@Override
	public void next(Object object) {
		validateProductStep.mustExecute(object);

	}

	private boolean validateOrder(Object order) {
		return true;
	}

}
