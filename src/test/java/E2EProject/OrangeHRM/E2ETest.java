package E2EProject.OrangeHRM;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.AssignLeavePageObject;
import pageObjects.HomePageObject;
import pageObjects.LandingPageObject;
import pageObjects.MyInfoPageObject;
import resources.Base;

public class E2ETest extends Base {
	public WebDriver driver;
	private LandingPageObject landingPage;
	private HomePageObject homePage;
	private AssignLeavePageObject assignLeave;
	private MyInfoPageObject myInfo;

	@BeforeTest
	public void setUp() throws IOException {

		driver = initializeDriver();
		log.info("Driver is initialized");
	}

	@Test
	public void E2ETesting() throws IOException {
		driver.get(getProperty("url"));
		landingPage = new LandingPageObject(driver);
		landingPage.getUsername().sendKeys(getProperty("validUsername"));
		landingPage.getPassword().sendKeys(getProperty("validPassword"));
		log.debug("Entering username and password");
		homePage = landingPage.getLogin();
		log.debug("Click login button");

		homePage = new HomePageObject(driver);

		myInfo = homePage.getMyInfo();
		log.debug("Click on My Info");
		myInfo.getEditBtn().click();
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

		myInfo.getSaveBtn().click();
		log.debug("Saving all changes");

		assignLeave = homePage.getLeave();
		assignLeave.getAssignLeaveList().click();
		moveMouse().moveToElement(assignLeave.getEmployeeName()).click().sendKeys("John Smith").sendKeys(Keys.ENTER)
				.build().perform();
		dropDownSelect(assignLeave.getLeaveType(), "6");
		assignLeave.leaveFromDate1().click();

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
