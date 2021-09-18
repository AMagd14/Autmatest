package testPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.shaft.driver.DriverFactory;
import com.shaft.gui.browser.BrowserActions;
import com.shaft.gui.element.ElementActions;
import com.shaft.validation.Validations;

public class NewTest {
  @Test
  public void f() {
	  WebDriver driver;
	  driver = DriverFactory.getDriver();
	  
	  BrowserActions.navigateToURL(driver, "https://www.google.com/");
	  ElementActions.type(driver, By.name("q"), "SHAFT_Engine");
	  ElementActions.keyPress(driver, By.name("q"), Keys.ENTER);
	  	  
	  Validations.assertThat()
	  .element(driver, By.id("result-stats"))
	  .text()
	  .doesNotEqual("")
	  .withCustomReportMessage("Check that result stats text is not empty")
	  .perform();
	  
	  BrowserActions.closeCurrentWindow(driver);
  }
}
