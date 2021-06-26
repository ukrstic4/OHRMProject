package E2EProject.OrangeHRM;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPageObject;
import resources.Base;

public class LoginTest extends Base {
	public WebDriver driver;
	private LandingPageObject landingPage;

	@BeforeTest
	public void setUp() throws IOException {

		driver = initializeDriver();
		log.info("Driver is initialized");
	}

	@Test
	public void positiveTest() throws IOException {
		driver.get(getProperty("url"));
		log.info("Opening url");
		landingPage = new LandingPageObject(driver);
		landingPage.getUsername().sendKeys(getProperty("validUsername"));
		landingPage.getPassword().sendKeys(getProperty("validPassword"));
		log.debug("Entering username and password");
		landingPage.getLogin();
		log.debug("Click login button");
	}

	@AfterTest
	public void tearDown() {

		driver.quit();
		log.info("Driver is closing");
	}

}
