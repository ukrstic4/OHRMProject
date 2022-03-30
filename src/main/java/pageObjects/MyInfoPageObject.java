package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.Base;

public class MyInfoPageObject extends Base {

	public WebDriver driver;
	private By editBtn = By.id("btnSave");
	private By editName = By.id("personal_txtEmpFirstName");
	private By editLastName = By.id("personal_txtEmpLastName");
	private By employeeID = By.id("personal_txtOtherID");
	private By nationality = By.id("personal_cmbNation");
	private By maritalStatus = By.id("personal_cmbMarital");
	private By dateOfBirth = By.id("personal_DOB");
	private By monthOfBird = By.xpath("//select[@class='ui-datepicker-month']");
	private By yearOfBird = By.xpath("//select[@class='ui-datepicker-year']");
	private By pickDayOfBird = By.xpath("//table[@class='ui-datepicker-calendar']//tbody/tr[2]/td");
	private By saveBtn = By.id("btnSave");

	public MyInfoPageObject(WebDriver driver) {

		this.driver = driver;
	}

	public WebElement getEditBtn() {

		return driver.findElement(editBtn);
	}

	public WebElement getEditName() {

		return driver.findElement(editName);

	}

	public WebElement getEditLastName() {

		return driver.findElement(editLastName);

	}

	public WebElement getEmployeeID() {

		return driver.findElement(employeeID);

	}

	public WebElement getNationality() {

		return driver.findElement(nationality);

	}

	public WebElement getMaritalStatus() {

		return driver.findElement(maritalStatus);

	}

	public WebElement getDateOfBirth() {

		return driver.findElement(dateOfBirth);

	}

	public WebElement getMonthOfBirth() {

		return driver.findElement(monthOfBird);

	}

	public WebElement getYearOfBirth() {

		return driver.findElement(yearOfBird);

	}

	public List<WebElement> getDayOfBirth() {

		return driver.findElements(pickDayOfBird);

	}

	public WebElement getSaveBtn() {

		return driver.findElement(saveBtn);

	}

}
