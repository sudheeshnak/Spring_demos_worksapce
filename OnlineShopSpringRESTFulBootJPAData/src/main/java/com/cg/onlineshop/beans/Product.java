package com.cg.onlineshop.beans;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
	@Id
	private int productId;
	private String productCode; 
	private int price;
	private int starRating;
	private String description ;
	private String productName;
	private String imageUrl;
	private String releaseDate;
	
	public Product() {}
	public Product(int productId, String productCode, int price, int starRating, String description, String productName,
			String imageUrl, String releaseDate) {
		super();
		this.productId = productId;
		this.productCode = productCode;
		this.price = price;
		this.starRating = starRating;
		this.description = description;
		this.productName = productName;
		this.imageUrl = imageUrl;
		this.releaseDate = releaseDate;
	}

	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getStarRating() {
		return starRating;
	}
	public void setStarRating(int starRating) {
		this.starRating = starRating;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productCode=" + productCode + ", price=" + price + ", starRating="
				+ starRating + ", description=" + description + ", productName=" + productName + ", imageUrl="
				+ imageUrl + ", releaseDate=" + releaseDate + "]";
	}
	
	
}
