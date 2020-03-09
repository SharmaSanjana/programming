package com.sanjana.orders.order.services;

public interface Step {

	void execute(Object object) throws Exception;
	
	void next(Object object);
	
	void mustExecute(Object object);
	
}
