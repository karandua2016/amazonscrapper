/**
 * @author Karan Dua
 */

package com.unicommerce.amazonscrapper.utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*
 * Class holding utility methods to fetch elements from a web page
 */
public class SearchElementGetter {

	private final static String SEARCH_RESULT_XPATH = "//div[contains(@class,'s-search-results')]//div[starts-with(@class, 'a-section a-spacing-medium')]";
	private final static String NAME_XPATH = ".//h2//a";
	private final static String PRICE_XPATH = ".//span[@class='a-price-whole']";
	private final static String IMAGE_URL_XPATH = ".//img";
	private final static String REVIEW_URL_XPATH = "//div[@data-hook='review-collapsed']//span";

	private final static String SEARCH_BOX_ID="twotabsearchtextbox";
	private final static String SUBMIT_BUTTON_XPATH="//input[@type='submit']";

	private WebDriver webDriver;

	public enum PRODUCT_ELEMENT_TYPE {
		PRODUCT_NAME,
		PRODUCT_LINK,
		PRODUCT_PRICE,
		IMAGE_URL
	}

	public SearchElementGetter(WebDriver webDriver) {
		this.webDriver = webDriver;
	}

	public String getElement(PRODUCT_ELEMENT_TYPE elementType, WebElement parentElement) {
		if(elementType == PRODUCT_ELEMENT_TYPE.PRODUCT_NAME) {
			return getName(parentElement);
		}else if(elementType == PRODUCT_ELEMENT_TYPE.PRODUCT_LINK) {
			return getLink(parentElement);
		} else if(elementType == PRODUCT_ELEMENT_TYPE.PRODUCT_PRICE) {
			return getPrice(parentElement);
		}else if(elementType == PRODUCT_ELEMENT_TYPE.IMAGE_URL) {
			return getImageUrl(parentElement);
		}
		return null;
	}

	public List<WebElement> getSearchResult() {
		try {
			return webDriver.findElements(By.xpath(SEARCH_RESULT_XPATH));
		} catch(NoSuchElementException e) {
			return null;
		}
	}

	// Doesn't return null if review not found. Exception Needed to be handled by the caller.
	public WebElement getSearchBox() throws NoSuchElementException{
		return webDriver.findElement(By.id(SEARCH_BOX_ID));
	}

	// Doesn't return null if review not found. Exception Needed to be handled by the caller.
	public WebElement getSubmitButton() throws NoSuchElementException{
		try {
			return webDriver.findElement(By.xpath(SUBMIT_BUTTON_XPATH));
		} catch(NoSuchElementException e) {
			return null;
		}
	}

	private String getName(WebElement parentElement) {
		try {
			return parentElement.findElement(By.xpath(NAME_XPATH)).getText();
		} catch (NoSuchElementException e) {
			return null;
		}

	}

	private String getLink(WebElement parentElement) {
		try {
			return parentElement.findElement(By.xpath(NAME_XPATH)).getAttribute("href");
		} catch (NoSuchElementException e) {
			return null;
		}

	}

	private String getPrice(WebElement parentElement) {
		try {
			return parentElement.findElement(By.xpath(PRICE_XPATH)).getText();
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	private String getImageUrl(WebElement parentElement) {
		try {
			return parentElement.findElement(By.xpath(IMAGE_URL_XPATH)).getAttribute("src");
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	// Doesn't return null if review not found. Exception Needed to be handled by the caller.
	public String getTopReview() throws NoSuchElementException{
		return webDriver.findElement(By.xpath(REVIEW_URL_XPATH)).getText();
	}

}
