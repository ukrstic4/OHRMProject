package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.Base;

public class LandingPageObject extends Base {

	public WebDriver driver;
	private By username = By.id("txtUsername");
	private By password = By.id("txtPassword");
	private By login = By.id("btnLogin");

	private By errorMessageLogin = By.xpath("//span[@id='spanMessage']");

	public LandingPageObject(WebDriver driver) {

		this.driver = driver;
	}

	public WebElement getUsername() {

		return driver.findElement(username);
	}

	public WebElement getPassword() {

		return driver.findElement(password);
	}

	public HomePageObject getLogin() {

		driver.findElement(login).click();
		return new HomePageObject(driver);
	}

	public String getErrorMessage() {

		String errorMessage = driver.findElement(errorMessageLogin).getText();
		return errorMessage;
	}

}
