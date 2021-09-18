package google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResults {
	//variables
	private ThreadLocal<WebDriver> driver;
	
	//locators
	private static By resultStats_label = By.id("result-stats");
	public static By getResultStats_label() {
		return resultStats_label;
	}

	
	//constructor
	public SearchResults(ThreadLocal<WebDriver> driver) {
		this.driver = driver;
	}
	
	//keywords
}
