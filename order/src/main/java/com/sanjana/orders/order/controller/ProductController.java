package com.sanjana.orders.order.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sanjana.orders.order.entity.Product;
import com.sanjana.orders.order.services.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping("/products")
	public Product createProduct(@RequestBody Product product) {
		return productService.createAndUpdateProduct(product);
	}
	
	@PutMapping("/products")
	public Product updateProduct(@RequestBody Product product) {
		return productService.createAndUpdateProduct(product);
	}
	
	@GetMapping("/products/{name}/merchant")
	public List<Product> getProductsByMerchant(@PathVariable String name){
		return productService.getProductByMerchantName(name);
	}
	

	
}
