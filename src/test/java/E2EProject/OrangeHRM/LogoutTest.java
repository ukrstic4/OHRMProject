package E2EProject.OrangeHRM;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.HomePageObject;
import pageObjects.LandingPageObject;
import resources.Base;

public class LogoutTest extends Base {
	public WebDriver driver;
	private LandingPageObject landingPage;
	private HomePageObject homePage;

	@BeforeTest
	public void setup() throws IOException {

		driver = initializeDriver();
		log.info("Driver is initialized");
	}

	@Test
	public void logout() throws IOException {

		driver.get(getProperty("url"));
		log.info("Opening url");
		landingPage = new LandingPageObject(driver);
		landingPage.getUsername().sendKeys(getProperty("validUsername"));
		landingPage.getPassword().sendKeys(getProperty("validPassword"));
		log.debug("Entering username and password");
		landingPage.getLogin();
		log.debug("Click on login");
		homePage = new HomePageObject(driver);

		moveMouse().moveToElement(homePage.getAccountBtn()).click().moveToElement(homePage.getLogoutBtn()).click()
				.build().perform();
		homePage.getLogoutBtn().click();
		log.debug("Click on account and logout button");

	}

	@AfterTest
	public void tearDown() {

		driver.quit();
		log.info("Driver is closing");

	}

}
