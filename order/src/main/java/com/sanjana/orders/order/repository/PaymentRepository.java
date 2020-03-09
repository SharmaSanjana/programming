package com.sanjana.orders.order.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sanjana.orders.order.entity.Payment;

@Repository
public interface PaymentRepository extends CrudRepository<Payment, Long> {

}
