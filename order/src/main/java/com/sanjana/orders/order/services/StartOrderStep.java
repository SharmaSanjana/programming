package com.sanjana.orders.order.services;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StartOrderStep extends AbstractStep {

	@Autowired
	private ValidateOrderStep step;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(StartOrderStep.class);
	
	@Override
	public void execute(Object object) throws Exception {
		LOGGER.info("Placing the Order Started at "+new Date());

	}
	@Override
	public void next(Object object) {
		step.mustExecute(object);

	}

}
