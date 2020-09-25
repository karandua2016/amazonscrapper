/**
 * @author Karan Dua
 */

package com.unicommerce.amazonscrapper.pojos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/*
 * POJO for holding product details. Contains annotations for serializing/deserializing to/from JSON string
 */

@JsonPropertyOrder({"productName", "productImageUrl", "productPrice", "bestProductReview"})
public class Product {
	
	private String productName;
	
	@JsonIgnore
	private String productLink;
	
	private Review bestProductReview;
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
	public Review getBestProductReview() {
		return bestProductReview;
	}
	public void setBestProductReview(Review bestProductReview) {
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
	
	public class Review {
		
		String reviewerName;
		String reviewTitle;
		String reviewText;
		
		public String getReviewerName() {
			return reviewerName;
		}
		public void setReviewerName(String reviewerName) {
			this.reviewerName = reviewerName;
		}
		public String getReviewTitle() {
			return reviewTitle;
		}
		public void setReviewTitle(String reviewTitle) {
			this.reviewTitle = reviewTitle;
		}
		public String getReviewText() {
			return reviewText;
		}
		public void setReviewText(String reviewText) {
			this.reviewText = reviewText;
		}

	}
}
