package E2EProject.OrangeHRM;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPageObject;
import resources.Base;

public class NegativeLoginTest extends Base {

	public WebDriver driver;
	private LandingPageObject landingPage;

	@BeforeTest
	public void setUp() throws IOException {

		driver = initializeDriver();
		log.info("Driver is initialized");
	}

	@Test(dataProvider = "multipleInvalidData")
	public void negativeTest(String username, String password) throws IOException {

		driver.get(getProperty("url"));
		log.info("Opening url");
		landingPage = new LandingPageObject(driver);
		landingPage.getUsername().sendKeys(username);
		landingPage.getPassword().sendKeys(password);
		log.debug("Entering INVALID username and password");
		landingPage.getLogin();
		log.debug("Click login button");
		if (landingPage.getErrorMessage().equalsIgnoreCase("Invalid credentials")) {

			compareCondition(landingPage.getErrorMessage(), "Invalid credentials");
			log.info("Invalid credentials");
		}

		else if (landingPage.getErrorMessage().equalsIgnoreCase("Username cannot be empty")) {

			compareCondition(landingPage.getErrorMessage(), "Username cannot be empty");
			log.info("Username cannot be empty");
		}

	}

	@DataProvider
	public Object[][] multipleInvalidData() {

		Object[][] input = new Object[6][2];
		input[0][0] = "";
		input[0][1] = "";
		input[1][0] = "Admin";
		input[1][1] = "aljkhklhj";
		input[2][0] = "b4343";
		input[2][1] = "admin123";
		input[3][0] = "fds1";
		input[3][1] = "sdf2";
		input[4][0] = "Admin";
		input[4][1] = "";
		input[5][0] = "";
		input[5][1] = "admin123";

		return input;
	}

	@AfterTest
	public void tearDown() {

		driver.quit();
		log.info("Driver is closing");
	}

}
