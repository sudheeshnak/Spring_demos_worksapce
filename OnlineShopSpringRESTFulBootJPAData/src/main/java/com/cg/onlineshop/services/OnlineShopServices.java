package com.cg.onlineshop.services;

import java.util.ArrayList;

import com.cg.onlineshop.beans.Product;
import com.cg.onlineshop.exceptions.ProductDetailsNotFoundException;

public interface OnlineShopServices {
	public void acceptProductDetails(Product product);
	public ArrayList<Product> getAllProductDetails();
	public Product getProductDetails(int productId)throws ProductDetailsNotFoundException;
	public void removeProductDetails(int productId);
}
