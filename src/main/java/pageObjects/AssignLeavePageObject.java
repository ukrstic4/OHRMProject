package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resources.Base;

public class AssignLeavePageObject extends Base {

	public WebDriver driver;
	@FindBy(id = "menu_leave_assignLeave")
	private WebElement leaveList;

	@FindBy(id = "assignleave_txtEmployee_empName")
	private WebElement employeeName;

	@FindBy(id = "assignleave_txtLeaveType")
	private WebElement leaveType;

	@FindBy(id = "assignleave_txtFromDate")
	private WebElement leaveFromDate;

	@FindBy(xpath = "//select[@class='ui-datepicker-month']")
	private WebElement monthPicker;

	@FindBy(xpath = "//select[@class='ui-datepicker-year']")
	private WebElement yearPicker;
	
	@FindBy(xpath = "//table[@class='ui-datepicker-calendar']//tbody/tr[2]/td")
	private List<WebElement> dayPicker;

	public AssignLeavePageObject(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	public WebElement getAssignLeaveList() {

		return leaveList;
	}

	public WebElement getEmployeeName() {

		return employeeName;
	}

	public WebElement getLeaveType() {

		return leaveType;
	}

	public WebElement leaveFromDate1() {

		return leaveFromDate;
	}

	public WebElement pickMonth() {

		return monthPicker;
	}

	
	public WebElement pickYear() {

		return yearPicker;
	}
	
	public List<WebElement> pickDay() {

		return dayPicker;
	}

}
