package com.sanjana.orders.order.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sanjana.orders.order.entity.Address;

@Repository
public interface AddressRepository extends CrudRepository<Address, Long> {

}
