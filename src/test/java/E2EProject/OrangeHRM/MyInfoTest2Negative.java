package E2EProject.OrangeHRM;

import java.io.IOException;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.HomePageObject;
import pageObjects.LandingPageObject;
import pageObjects.MyInfoPageObject;
import resources.Base;

public class MyInfoTest2Negative extends Base {
	private LandingPageObject landingPage;
	private HomePageObject homePage;
	private MyInfoPageObject myInfo;
	public WebDriver driver;

	@BeforeTest
	public void setUp() throws IOException {

		driver = initializeDriver();
		log.info("Driver is initialized");
	}

	@Test
	public void editMyInfoWithoutEditBtn() throws IOException {
		driver.get(getProperty("url"));
		log.info("Opening url");
		landingPage = new LandingPageObject(driver);

		landingPage.getUsername().sendKeys(getProperty("validUsername"));
		log.debug("Entering username");
		landingPage.getPassword().sendKeys(getProperty("validPassword"));
		log.debug("Entering password");
		landingPage.getLogin();

		log.debug("Click Login button");

		homePage = new HomePageObject(driver);

		myInfo = homePage.getMyInfo();
		log.debug("Click on My Ifnfo");
//		myInfo.getEditBtn().click();
		myInfo.getEditName().clear();
		moveMouse().moveToElement(myInfo.getEditName()).click().sendKeys("Jake").build().perform();
		myInfo.getEditLastName().clear();
		moveMouse().moveToElement(myInfo.getEditLastName()).click().sendKeys("Jones").build().perform();
		myInfo.getEmployeeID().clear();
		moveMouse().moveToElement(myInfo.getEmployeeID()).click().sendKeys("4487").build().perform();

		dropDownSelect(myInfo.getNationality(), "10");
		dropDownSelect(myInfo.getMaritalStatus(), "Single");
		log.debug("Changing information");
		myInfo.getDateOfBirth().click();

		boolean staleElement = true;

		while (staleElement) {

			try {
				log.debug("Changing dates");
				calendarPicker1(myInfo.getMonthOfBirth(), "6", myInfo.getYearOfBirth(), "1995", myInfo.getDayOfBirth(),
						"4");

				staleElement = false;

			} catch (StaleElementReferenceException e) {
				log.error("StaleElementReferenceException");
				staleElement = true;

			}

		}

		myInfo.getSaveBtn().click();
		log.debug("Saving all changes");

	}

	@AfterTest
	public void tearDown() {

		driver.quit();
		log.info("Driver is closing");

	}

}
