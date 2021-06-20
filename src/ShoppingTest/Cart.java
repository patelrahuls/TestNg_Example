package ShoppingTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Cart {
	WebDriver driver;
	ExtentReports report;
	ExtentTest test;

	SoftAssert soft = new SoftAssert();

	@BeforeTest
	public void setupNew() {
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		System.out.println("In Main");

		driver = new ChromeDriver();

		driver.get("https://www.saucedemo.com/");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

		report = new ExtentReports("ExtentReports.html");

	}

	@Test
	public void Login() {
		System.out.println("On Login Page");
		test = report.startTest("Login Test case");

		WebElement userName = driver.findElement(By.id("user-name"));
		userName.sendKeys("standard_user");
		test.log(LogStatus.PASS, "Successfully entered username");

		// WebDriverWait wait = new WebDriverWait(driver,30);
		// wait.until(ExpectedConditions.elementToBeClickable(userName));

		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("secret_sauce");
		
		test.log(LogStatus.PASS, "Successfully entered password");

		WebElement loginBtn = driver.findElement(By.id("login-button"));
		loginBtn.click();

	}

	@Test(dependsOnMethods = "Login")
	public void addToCart() {
		WebElement backPack = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
		backPack.click();
	}

	@AfterTest
	public void tearDown() {
		report.endTest(test);
		report.flush();

		driver.close();

		soft.assertAll();
	}

}
