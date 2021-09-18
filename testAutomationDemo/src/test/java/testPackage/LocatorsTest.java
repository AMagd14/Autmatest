package testPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import w3schools.HtmlTables;

public class LocatorsTest {
	private WebDriver driver;
	//this is to test source control

	@Test(description = "Given the browser is open, When I navigate to 'HTML Tables' page, Then the country name for the company 'Ernst Handel' should be 'Austria'")
	public void checkCountryNameForErnstHandel() {
		String countryName = new HtmlTables(driver).navigate().getCountryName("Laughing Bacchus Winecellars");
		Assert.assertEquals(countryName, "Canada");
	}

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
