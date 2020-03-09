package com.sanjana.orders.order.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sanjana.orders.order.entity.Address;
import com.sanjana.orders.order.entity.User;
import com.sanjana.orders.order.repository.AddressRepository;
import com.sanjana.orders.order.repository.OrderRepository;
import com.sanjana.orders.order.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private AddressRepository addressRepo;
	
	@Autowired
	private OrderRepository orderRepo;
	
	public User createAndUpdateUser(User user) {
		if(validateUser(user)) {
			if(user.getAddresses()!=null) {
				for(Address addr : user.getAddresses()) {
					addressRepo.save(addr);
				}
					
			}
			return userRepo.save(user);
		}
		return null;
	}

	private boolean validateUser(User user) {
		if(user!=null)
			return true;
		return false;
	}

}
