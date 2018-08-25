package com.cg.onlineshop.controllers;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineshop.beans.Product;
import com.cg.onlineshop.exceptions.ProductDetailsNotFoundException;
import com.cg.onlineshop.services.OnlineShopServices;
@RestController
//@CrossOrigin(origins={"http://localhost:4200", "http://10.102.50.17:4200","http://10.102.50.35:4200"})
public class ProductCatlogServicesController {

	@Autowired
		private OnlineShopServices onlineShopServices ;
	
	
	@RequestMapping(method=RequestMethod.GET, value={"/sayHello"},produces={"application/text"})
	public ResponseEntity<String> getHelloMessage(){
		return new ResponseEntity<String>("Hello World From RestFulWebService", HttpStatus.OK);
	}

	@RequestMapping(method=RequestMethod.GET, value={"/allProductDetails"},
			produces=MediaType.APPLICATION_JSON_VALUE,
			headers ="Accept=application/json")
	public ResponseEntity<ArrayList<Product>> getAllProductDetailsJSON(){
		ArrayList<Product> productsList = onlineShopServices.getAllProductDetails();
		return new ResponseEntity<>(productsList,HttpStatus.OK);
	}
	
	
	
	@RequestMapping(value={"/productDetails"},produces=MediaType.APPLICATION_JSON_VALUE, 
			headers ="Accept=application/json")
	public ResponseEntity<Product> getProductDetails(@RequestParam("productId") int productId) 
			throws ProductDetailsNotFoundException{
		Product product = onlineShopServices.getProductDetails(productId);
		return new ResponseEntity<>(product,HttpStatus.OK);
	}
	
	
	
	
	
	
	
	@RequestMapping(value="/acceptProductDetails",method=RequestMethod.POST, 
			consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ResponseEntity<String> acceptProductDetails(@ModelAttribute Product product){
		onlineShopServices.acceptProductDetails(product);
		return new ResponseEntity<>("Product details successfully added",HttpStatus.OK);
	}
	
	@RequestMapping(value="/deleteProductDetails/{productCode}",method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteProductDetails(@PathVariable("productId") int productId) throws ProductDetailsNotFoundException{
		onlineShopServices.removeProductDetails(productId);
		return new ResponseEntity<>("Product details with productCode "+productId+" successfully deleted",HttpStatus.OK);
	}
	

}
