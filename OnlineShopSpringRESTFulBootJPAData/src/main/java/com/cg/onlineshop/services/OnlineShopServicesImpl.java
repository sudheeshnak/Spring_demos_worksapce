package com.cg.onlineshop.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.cg.onlineshop.beans.Product;
import com.cg.onlineshop.daoservices.OnlineShopDAOServices;
import com.cg.onlineshop.exceptions.ProductDetailsNotFoundException;

@Component(value="onlineShopServices")
public class OnlineShopServicesImpl implements OnlineShopServices{
	
	@Autowired
	OnlineShopDAOServices onlineShopDAOServices ;

	@Override
	public void acceptProductDetails(Product product) {
		onlineShopDAOServices.save(product);
	}

	@Override
	public ArrayList<Product> getAllProductDetails() {
		return (ArrayList<Product>) onlineShopDAOServices.findAll();
	}

	@Override
	public Product getProductDetails(int productId) throws ProductDetailsNotFoundException {
		
		Product product = onlineShopDAOServices.findOne(productId);
		if(product==null)throw new ProductDetailsNotFoundException("Product details for productId  "+productId+"  not found");
		return product;
	}
	@Override
	public void removeProductDetails(int productId) {
		onlineShopDAOServices.delete(productId);
	}


}
