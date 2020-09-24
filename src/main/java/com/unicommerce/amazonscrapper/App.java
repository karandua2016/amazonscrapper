package com.unicommerce.amazonscrapper;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.unicommerce.amazonscrapper.SearchElementGetter.PRODUCT_ELEMENT_TYPE;

import java.util.logging.Logger;

/**
 * @author Karan Dua
 *
 */
public class App 
{
	static final String chromeDriverPath = "src/main/chromedriver.exe" ;
	static final String amazonUrl = "https://www.amazon.asad";
	static Logger logger = Logger.getLogger(App.class.getName());

	public static void main( String[] args ) throws JsonProcessingException
	{
		// Set logger level to INFO
		logger.setLevel(Level.INFO);
		
		// Setup Chrome Driver. Disable redundant logging
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		System.setProperty("webdriver.chrome.silentOutput", "true");
		Logger.getLogger("org.openqa.selenium").setLevel(Level.SEVERE);
		ChromeOptions options = new ChromeOptions();

		// Use a headless Chrome. Such a browser runs in background without invoking the UI
		// Set Standard resolution. Ignore SSL certificate errors.

		options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors");
		WebDriver driver = new ChromeDriver(options);
		

		// Request the driver to invoke amazon URL
		try {
			logger.info("Contacting amazon's URL");
			driver.get(amazonUrl);
		} catch(WebDriverException e) {
			logger.severe("Cannot access Amazon. Please check internet connection and/or URL");
			System.exit(0);
		}
		
		// Initialize an Element Getter
		SearchElementGetter elementGetter = new SearchElementGetter(driver);
		
		WebElement searchbox = elementGetter.getSearchBox();
		//Type in the search term in the search box
		searchbox.sendKeys(args[0]);
		
		WebElement submit = elementGetter.getSubmitButton();
		// Simulate a click on the submit button
		submit.click();
		
		List<WebElement> searchResultsDiv = elementGetter.getSearchResult();
		List<ProductDetail> searchResults = new ArrayList<ProductDetail>();
		
		// Now iterate all the search results to populate product details
		for(int i = 0; i < Integer.parseInt(args[1]); i++) {
			ProductDetail productDetail = new ProductDetail();
			WebElement parentElement = searchResultsDiv.get(i);
			String price = elementGetter.getElement(PRODUCT_ELEMENT_TYPE.PRODUCT_PRICE, parentElement);
			String link = searchResultsDiv.get(i).findElement(By.xpath(".//h2//a")).getAttribute("href");
			String name = searchResultsDiv.get(i).findElement(By.xpath(".//h2//a")).getText();
			String imgLink = searchResultsDiv.get(i).findElement(By.xpath(".//img")).getAttribute("src");
			productDetail.setProductName(name);
			productDetail.setProductLink(link);
			productDetail.setProductPrice(price);
			productDetail.setProductImageUrl(imgLink);
			searchResults.add(productDetail);
		}


		for(ProductDetail result : searchResults) {
			driver.get(result.getProductLink());
			System.out.println(result.getProductLink());
			result.setBestProductReview(driver.findElement(By.xpath("//div[@data-hook='review-collapsed']//span")).getText());
		}

		ObjectMapper mapper = new ObjectMapper();
		System.out.println(mapper.writeValueAsString(searchResults));
	}
}


