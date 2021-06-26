package E2EProject.OrangeHRM;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.AssignLeavePageObject;
import pageObjects.HomePageObject;
import pageObjects.LandingPageObject;
import resources.Base;

public class AssignLeaveTest extends Base {

	private LandingPageObject landingPage;
	private HomePageObject homePage;
	private AssignLeavePageObject assignLeave;

	public WebDriver driver;

	@BeforeTest
	public void setUp() throws IOException {

		driver = initializeDriver();
	}

	@Test
	public void assignLeaveTest() throws IOException {

		driver.get(getProperty("url"));
		landingPage = new LandingPageObject(driver);
		landingPage.getUsername().sendKeys(getProperty("validUsername"));
		landingPage.getPassword().sendKeys(getProperty("validPassword"));
		landingPage.getLogin();
		homePage = new HomePageObject(driver);
		assignLeave = homePage.getLeave();
		assignLeave.getAssignLeaveList().click();
		moveMouse().moveToElement(assignLeave.getEmployeeName()).click().sendKeys("John Smith").sendKeys(Keys.ENTER)
				.build().perform();
		dropDownSelect(assignLeave.getLeaveType(), "6");
		assignLeave.leaveFromDate1().click();

		boolean staleElement = true;

		while (staleElement) {

			try {

				calendarPicker1(assignLeave.pickMonth(), "3", assignLeave.pickYear(), "2021", assignLeave.pickDay(),
						"3");

				staleElement = false;

			} catch (StaleElementReferenceException e) {

				staleElement = true;

			}

		}

		

	}

	@AfterTest
	public void tearDown() {

		driver.quit();

	}

}
