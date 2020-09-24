package com.unicommerce.amazonscrapper;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ProductDetail {
	
	private String productName;
	
	@JsonIgnore
	private String productLink;
	
	private String bestProductReview;
	private String productPrice;
	private String productImageUrl;
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductLink() {
		return productLink;
	}
	public void setProductLink(String productLink) {
		this.productLink = productLink;
	}
	public String getBestProductReview() {
		return bestProductReview;
	}
	public void setBestProductReview(String bestProductReview) {
		this.bestProductReview = bestProductReview;
	}
	
	public String getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductImageUrl() {
		return productImageUrl;
	}
	public void setProductImageUrl(String productImageUrl) {
		this.productImageUrl = productImageUrl;
	}

}
