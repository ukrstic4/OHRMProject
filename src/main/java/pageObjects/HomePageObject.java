package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.Base;

public class HomePageObject extends Base {

	public WebDriver driver;
	private By username = By.id("txtUsername");
	private By password = By.id("txtPassword");
	private By navigationBar = By.id("mainMenuFirstLevelUnorderedList");
	private By myInfo = By.id("menu_pim_viewMyDetails");
	private By admin = By.id("menu_admin_viewAdminModule");
	private By PIM = By.id("menu_pim_viewPimModule");
	private By leave = By.id("menu_leave_viewLeaveModule");
	private By time = By.id("menu_time_viewTimeModule");
	private By recruitment = By.id("menu_recruitment_viewRecruitmentModule");
	private By perfomance = By.id("menu__Performance");
	private By dashboard = By.id("menu_dashboard_index");
	private By directory = By.id("menu_directory_viewDirectory");
	private By maintenance = By.id("menu_maintenance_purgeEmployee");
	private By buzz = By.id("menu_buzz_viewBuzz");
	private By accountBtn = By.id("welcome");
	private By logoutBtn = By.xpath("//*[contains(text(),'Logout')]");

	public HomePageObject(WebDriver driver) {

		this.driver = driver;
	}

	public WebElement getUsername() {

		return driver.findElement(username);
	}

	public WebElement getPassword() {

		return driver.findElement(password);
	}

	public WebElement getNavBar() {

		return driver.findElement(navigationBar);
	}

	public MyInfoPageObject getMyInfo() {

		driver.findElement(myInfo).click();
		return new MyInfoPageObject(driver);
	}

	public WebElement getAdmin() {

		return driver.findElement(admin);
	}

	public WebElement getPIM() {

		return driver.findElement(PIM);
	}

	public AssignLeavePageObject getLeave() {

		 driver.findElement(leave).click();
		 return new AssignLeavePageObject(driver);
	}

	public WebElement getTime() {

		return driver.findElement(time);
	}

	public WebElement getRecruitment() {

		return driver.findElement(recruitment);
	}

	public WebElement getPerfomance() {

		return driver.findElement(perfomance);
	}

	public WebElement getDashboard() {

		return driver.findElement(dashboard);
	}

	public WebElement getDirectory() {

		return driver.findElement(directory);
	}

	public WebElement getMaintenance() {

		return driver.findElement(maintenance);
	}

	public WebElement getBuzz() {

		return driver.findElement(buzz);
	}
	
	public WebElement getAccountBtn() {

		return driver.findElement(accountBtn);
	}
	
	public WebElement getLogoutBtn() {

		return driver.findElement(logoutBtn);
		
	}

}
