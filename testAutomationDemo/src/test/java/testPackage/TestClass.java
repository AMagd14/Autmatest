package testPackage;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.shaft.driver.DriverFactory;
import com.shaft.gui.browser.BrowserActions;
import com.shaft.validation.ValidationEnums.BrowserAttribute;
import com.shaft.validation.Validations;

import google.Home;
import google.SearchResults;

public class TestClass {
	private ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	@Test(description = "Given the browser is open, When I navigate to Google Home, Then Google logo will be displayed")
	public void checkThatGoogleLogoIsDisplayed() {		
		Validations.assertThat()
		.element(driver.get(), Home.getGoogleLogo_image())
		.matchesReferenceImage()
		.withCustomReportMessage("Checking to see that the google logo image is displayed")
		.perform();
	}

	@Test
	public void checkThatPageTitleIsCorrect() {
		Validations.assertThat().browser(driver.get()).attribute(BrowserAttribute.TITLE).isEqualTo("Google").perform();
	}

	@Test(description = "Given the browser is open, And I navigate to Google.com, When I search for 'Selenium WebDriver', Then The Result Stats will not be empty.")
	public void searchForSeleniumWebDriverAndCheckThatTheResultStatsAreNotEmpty() {	
		new Home(driver).search("Selenium WebDriver");	
		
		Validations.assertThat()
		.element(driver.get(), SearchResults.getResultStats_label())
		.text()
		.doesNotEqual("")
		.perform();
	}

	@BeforeMethod
	public void beforeMethod() {
		driver.set(DriverFactory.getDriver()); 			
		new Home(driver).navigate();
	}

	@AfterMethod
	public void afterMethod() {
		BrowserActions.closeCurrentWindow(driver.get());
	}
}
