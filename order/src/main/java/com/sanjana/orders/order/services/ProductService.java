package com.sanjana.orders.order.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sanjana.orders.order.entity.Merchant;
import com.sanjana.orders.order.entity.Product;
import com.sanjana.orders.order.repository.AddressRepository;
import com.sanjana.orders.order.repository.MerchantRepository;
import com.sanjana.orders.order.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepo;
	
	@Autowired
	private MerchantRepository merchantRepo;
	
	@Autowired
	private AddressRepository addressRepo;
	
	public Product createAndUpdateProduct(Product product) {
		
		if(validateProduct(product)) {
			if(product.getMerchant()!=null && product.getMerchant().getAddress()!=null) {
				addressRepo.save(product.getMerchant().getAddress());			
			}		
			
			if(product.getMerchant()!=null) {
				List<Merchant> listOfMerchant = merchantRepo.findByName(product.getMerchant().getName());
				if(listOfMerchant!=null && !listOfMerchant.isEmpty()) {
					product.setMerchant(listOfMerchant.get(0));
				}
				merchantRepo.save(product.getMerchant());
			}
				
			return productRepo.save(product);
		}
		
		
		return null;
	}

	private boolean validateProduct(Product product) {
		if(product!=null) 
			return true;
		return false;
	}

	public List<Product> getProductByMerchantName(String name) {
		
		return productRepo.findByMerchantName(name);
	}

}
