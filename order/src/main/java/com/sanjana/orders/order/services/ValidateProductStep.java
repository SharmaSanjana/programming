package com.sanjana.orders.order.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sanjana.orders.order.exception.InvalidProductException;

@Component
public class ValidateProductStep extends AbstractStep {

	private static final Logger LOGGER = LoggerFactory.getLogger(ValidateProductStep.class);
	
	@Autowired
	private ValidateInventoryStep nextStep;
	
	@Override
	public void execute(Object object) throws Exception {
		if(validProducts(object))
			LOGGER.info("products are valid");
		else {
			LOGGER.info("products are invalid");
			throw new InvalidProductException("products are invalid ");
		}

	}

	private boolean validProducts(Object object) {
		
		return true;
	}

	@Override
	public void next(Object object) {
		nextStep.mustExecute(object);

	}

}
