package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import test.LoginTest;

public class LoginPage {

	WebDriver driver;
	ExtentReports report;
	ExtentTest test;

	// ============ WebElements =====================
	@FindBy(linkText = "Log in")
	WebElement loginLink;

	@FindBy(name = "user_login")
	WebElement userName;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(className = "rememberMe")
	WebElement rememberMe;

	@FindBy(name = "btn_login")
	WebElement submitForm;

	@FindBy(id = "msg_box")
	WebElement error;

	// ============ Constructor =====================

	public LoginPage() {
		driver = LoginTest.driver;
		report = LoginTest.report;
		test = LoginTest.test;

		PageFactory.initElements(driver, this);

	}

	// ============ Methods =====================

	public void login(String uname, String pass) throws InterruptedException {

		// WebElement loginLink = driver.findElement(By.linkText("Log in"));
		// WebElement userName = driver.findElement(By.name("user_login"));
		// WebElement password = driver.findElement(By.name("user_pwd"));
		// WebElement rememberMe = driver.findElement(By.className("rememberMe"));
		// WebElement submitForm = driver.findElement(By.name("btn_login"));
		// WebElement error = driver.findElement(By.id("msg_box"));

		test = report.startTest("Login Test case");
		System.out.println("Inside Main Execution");
		loginLink.click();
		Thread.sleep(3000);
		test.log(LogStatus.PASS, "Successfully clicked on login Button");

		userName.sendKeys(uname);
		test.log(LogStatus.PASS, "Successfully entered username");

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(userName));

		password.sendKeys(pass);
		test.log(LogStatus.PASS, "Successfully entered password");

		rememberMe.click();
		test.log(LogStatus.PASS, "Successfully clicked on Login button");

		Thread.sleep(1000);
		submitForm.click();

		String actualMsg = error.getText();
		String expectedMsg = "The email or password you have entered is invalid.";

		Assert.assertTrue(error.isDisplayed());
		Assert.assertEquals(actualMsg, expectedMsg);

		// test.log(LogStatus.FAIL, "Error message does not match");
		/*
		 * try { assertEquals(actualMsg, expectedMsg); assertTrue(error.isDisplayed());
		 * } catch(Throwable e){ test.log(LogStatus.FAIL,
		 * "Error message does not match"); }
		 */

	}

}
