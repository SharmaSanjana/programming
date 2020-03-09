package com.sanjana.orders.order.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sanjana.orders.order.exception.InvalidPaymentException;

@Component
public class ValidatePaymentStep extends AbstractStep {

	private static final Logger LOGGER = LoggerFactory.getLogger(ValidatePaymentStep.class);
	
	@Autowired
	private StartPaymentStep nextStep;
	
	@Override
	public void execute(Object object) throws Exception {
		if(validatePayment(object)) {
			LOGGER.info("Payment is done... welcome");
		}
		else {
			LOGGER.info("No payment received.. bhago yaha se...dhooot");
			throw new InvalidPaymentException("No payment received.. bhago yaha se...dhooot");
		}

	}

	private boolean validatePayment(Object object) {
		return true;
	}

	@Override
	public void next(Object object) {
		nextStep.mustExecute(object);

	}

}
