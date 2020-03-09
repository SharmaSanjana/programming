package com.sanjana.orders.order.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SendEmailToMerchant extends AbstractStep {

	private static final Logger LOGGER = LoggerFactory.getLogger(SendEmailToMerchant.class);
	
	@Autowired
	private SendEmailToUserStep nextStep;
	
	@Override
	public void execute(Object object) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void next(Object object) {
		nextStep.mustExecute(object);

	}

}
