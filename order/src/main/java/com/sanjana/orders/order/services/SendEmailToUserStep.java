package com.sanjana.orders.order.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sanjana.orders.order.entity.Orders;
@Component
public class SendEmailToUserStep extends AbstractStep {

	private static final Logger LOGGER = LoggerFactory.getLogger(SendEmailToUserStep.class);
	
	@Autowired
	private EmailService emailService;
	
	@Override
	public void execute(Object object) throws Exception {
		Orders order = (Orders) object;
		
		emailService.sendSimpleMessage(order.getUser().getEmailId(), "Order Confirmation Email", "Your order with order id is confirmed");

	}

	@Override
	public void next(Object object) {
		LOGGER.info("at last step send email to user");

	}

}
