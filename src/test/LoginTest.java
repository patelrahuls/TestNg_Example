package test;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.testng.annotations.Parameters;

public class LoginTest {
	
	WebDriver driver;
	
	ExtentReports report;
	ExtentTest test;
	
	SoftAssert soft = new SoftAssert();
	/*
	 * @BeforeMethod public void setup() {
	 * System.setProperty("webdriver.chrome.driver", "chromedriver");
	 * 
	 * driver = new ChromeDriver();
	 * 
	 * driver.get("https://www.Simplilearn.com");
	 * 
	 * driver.manage().window().maximize();
	 * 
	 * driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
	 * 
	 * report = new ExtentReports("ExtentReports.html"); }
	 */
	
	@Test
	@Parameters({"username","password"})
	public void Login(String uname, String pass) throws InterruptedException {
		
		test = report.startTest("Login Test case");
		
		System.out.println("Inside Main Execution");
		WebElement loginLink = driver.findElement(By.linkText("Log in"));
		loginLink.click();
		Thread.sleep(3000);
		
		test.log(LogStatus.PASS, "Successfully clicked on login Button");
		
		WebElement userName = driver.findElement(By.name("user_login"));
		userName.sendKeys(uname);
		test.log(LogStatus.PASS, "Successfully entered username");
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(userName));
		
		WebElement password = driver.findElement(By.name("user_pwd"));
		password.sendKeys(pass);
		test.log(LogStatus.PASS, "Successfully entered password");
		
		WebElement rememberMe= driver.findElement(By.className("rememberMe"));
		rememberMe.click();
		
		Thread.sleep(1000);
		
		WebElement submitForm = driver.findElement(By.name("btn_login"));
		submitForm.click();
		
		WebElement error = driver.findElement(By.id("msg_box"));
		String actualMsg = error.getText();
		String expectedMsg = "The email or password you have entered is invalid";
		
		soft.assertEquals(actualMsg, expectedMsg);
		System.out.println("After Soft assert");
		
		test.log(LogStatus.FAIL,"Error message does not match"); 
		/*
		 * try { assertEquals(actualMsg, expectedMsg); assertTrue(error.isDisplayed());
		 * } catch(Throwable e){ test.log(LogStatus.FAIL,
		 * "Error message does not match"); }
		 */
	
		
	}
	
	@AfterMethod
	public void tearDown() {
		report.endTest(test);
		report.flush();
		
		driver.close();
		
		soft.assertAll();
	}

}
