package com.unicommerce.amazonscrapper;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import org.openqa.selenium.NoSuchElementException;
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
	static final String chromeDriverPath = "chromedriver.exe" ;
	static final String amazonUrl = "https://www.amazon.in";
	static Logger logger = Logger.getLogger(App.class.getName());
	static final int TOP_SEARCH_COUNT = 4;

	public static void main( String[] args ) throws JsonProcessingException
	{
		
		if(args.length == 0) {
			logger.severe("No search term entered.");
			System.exit(0);
		}
		
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
			logger.info("Contacting "+amazonUrl);
			driver.get(amazonUrl);
		} catch(WebDriverException e) {
			logger.severe("Cannot access Amazon. Please check internet connection and/or URL");
			System.exit(0);
		}

		logger.info("Connection to amazon successful");

		// Initialize an Element Getter
		SearchElementGetter elementGetter = new SearchElementGetter(driver);

		try {
			logger.info("Getting the Search Box");
			WebElement searchbox = elementGetter.getSearchBox();
			//Type in the search term in the search box

			logger.info("Typing search term in the Search Box");
			searchbox.sendKeys(args[0]);

			WebElement submit = elementGetter.getSubmitButton();
			// Simulate a click on the submit button
			submit.click();

			logger.info("Submitted the search term");
		} catch(NoSuchElementException e) {
			logger.info("Search Box and/or submit button not found on amazon's site. Please update the selectors.");
			System.exit(0);
		}

		logger.info("Parsing product details for the top "+TOP_SEARCH_COUNT+" products");
		List<WebElement> searchResultsDiv = elementGetter.getSearchResult();
		List<Product> products = new ArrayList<Product>();
		
		if(searchResultsDiv.size() == 0) {
			logger.severe("No products found for the search term. Aborting.");
			System.exit(0);
		}

		// Now iterate all the search results to populate product details
		for(int i = 0; i < TOP_SEARCH_COUNT && i<searchResultsDiv.size(); i++) {
			Product product = new Product();
			WebElement parentElement = searchResultsDiv.get(i);
			String price = elementGetter.getElement(PRODUCT_ELEMENT_TYPE.PRODUCT_PRICE, parentElement);
			String link = elementGetter.getElement(PRODUCT_ELEMENT_TYPE.PRODUCT_LINK, parentElement);
			String name = elementGetter.getElement(PRODUCT_ELEMENT_TYPE.PRODUCT_NAME, parentElement);
			String imgLink = elementGetter.getElement(PRODUCT_ELEMENT_TYPE.IMAGE_URL, parentElement);

			product.setProductName(name);
			product.setProductLink(link);
			product.setProductPrice(price);
			product.setProductImageUrl(imgLink);
			products.add(product);
		}

		logger.info("Product Details Parsed. Now fetching top review for each product.");
		// Now that you have the product link for each product, use the link to fetch product review
		for(Product product : products) {
			driver.get(product.getProductLink());
			try {
				logger.info("Fetching Best Review for "+product.getProductName());
				product.setBestProductReview(elementGetter.getTopReview());
			} catch (NoSuchElementException e) {
				logger.warning("No review found for product "+product.getProductName());
			}
		}

		// Now that all the details are available, use Jackson to serialize the product list into a JSON string
		ObjectMapper mapper = new ObjectMapper();
		System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(products));
		
		// Finally quit the driver
		driver.quit();
	}
}


