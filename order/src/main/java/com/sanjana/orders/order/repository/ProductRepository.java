package com.sanjana.orders.order.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sanjana.orders.order.entity.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

	public List<Product> findByMerchantName(String name);
}
