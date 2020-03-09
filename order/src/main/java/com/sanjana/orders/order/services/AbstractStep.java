package com.sanjana.orders.order.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractStep implements Step {

	private static final Logger LOGGER = LoggerFactory.getLogger(AbstractStep.class);

	private boolean shouldContinue = true;

	public void mustExecute(Object object) {
		try {

			this.execute(object);
			LOGGER.info("Executed ::"+this.getClass().getName());

		} catch (Exception e) {

			LOGGER.error("exception occurred at " + this.getClass().getName() + e);
			shouldContinue = false;

		}
		if (shouldContinue) {
			this.next(object);
		}
	}

}
