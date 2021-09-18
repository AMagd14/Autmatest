package w3schools;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HtmlTables {
	//variables
	private WebDriver driver;
	private String url = "https://www.w3schools.com/html/html_tables.asp";
	
	//locators
	private static By countryNameforCompany;
	
	//constructor
	public HtmlTables(WebDriver driver) {
		this.driver = driver;
	}
	
	//keywords
	public HtmlTables navigate() {
		driver.navigate().to(url);
		return this;
	}
	
	public String getCountryName(String companyName) {
		countryNameforCompany = By.xpath("//tr[contains(.,'"+companyName+"')]/td[3]");
		return driver.findElement(countryNameforCompany).getText();
	}
	
	

}
