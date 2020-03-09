package com.sanjana.orders.order.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sanjana.orders.order.entity.Orders;

@Repository
public interface OrderRepository extends CrudRepository<Orders, Long> {

}
