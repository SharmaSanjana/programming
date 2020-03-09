package com.sanjana.orders.order.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sanjana.orders.order.entity.OrderLineItem;

@Repository
public interface OrderLineItemRepository extends CrudRepository<OrderLineItem, Long> {

}
