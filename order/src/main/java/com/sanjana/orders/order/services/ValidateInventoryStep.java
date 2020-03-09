package com.sanjana.orders.order.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sanjana.orders.order.exception.InvalidInventoryException;

@Component
public class ValidateInventoryStep extends AbstractStep {

	private static final Logger LOGGER = LoggerFactory.getLogger(ValidateInventoryStep.class);

	@Autowired
	private ValidatePaymentStep nextStep;

	@Override
	public void execute(Object object) throws Exception {
		if (validInventory(object)) {
			LOGGER.info("inventory has specified products");
		} else {
			LOGGER.info("specified products not available in inventory");
			throw new InvalidInventoryException("specified products not available in inventory");
		}

	}

	private boolean validInventory(Object object) {
		return true;
	}

	@Override
	public void next(Object object) {
		nextStep.mustExecute(object);

	}

}
