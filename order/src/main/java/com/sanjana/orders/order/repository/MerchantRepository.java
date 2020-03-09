package com.sanjana.orders.order.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sanjana.orders.order.entity.Merchant;

@Repository
public interface MerchantRepository extends CrudRepository<Merchant, Long> {

	List<Merchant> findByName(String name);
	
}
