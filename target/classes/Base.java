package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;

import org.apache.logging.log4j.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public static Logger log = LogManager.getLogger(Base.class.getName());
	public WebDriver driver;

	public String getProperty(String propertyValue) throws IOException {

		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "//src/main/java//resources//data.properties");
		Properties prop = new Properties();
		prop.load(fis);
		return prop.getProperty(propertyValue);

	}

	public WebDriver initializeDriver() throws IOException {
		String browser = getProperty("browser");

		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}

		else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		return driver;
	}

	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationPath = System.getProperty("user.dir") + "//reports//screenshots//" + testCaseName + ".jpg";
		FileUtils.copyFile(source, new File(destinationPath));
		return destinationPath;
	}

	public Actions moveMouse() {

		Actions ac = new Actions(driver);
		return ac;

	}

	public Select dropDownSelect(WebElement element, String value) {

		Select sec = new Select(element);
		sec.selectByValue(value);
		return sec;

	}

	public static void compareCondition(String actualMessage, String ExpectedMessage) {

		Assert.assertEquals(actualMessage, ExpectedMessage);

	}

	public void calendarPicker1(WebElement monthElement, String month, WebElement yearElement, String year,
			List<WebElement> dayElements, String day2) {

		dropDownSelect(monthElement, month);
		dropDownSelect(yearElement, year);
		List<WebElement> allDaysOfMonth = dayElements;
		for (WebElement daysOfMonth : allDaysOfMonth) {

			String day = daysOfMonth.getText();

			if (day.equalsIgnoreCase(day2)) {

				daysOfMonth.click();

			}
		}

	}
	
	public String jsExecutor(String s ) {
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String getText = js.executeScript("return " + s + ";").toString();
		 return getText;
	}

}
