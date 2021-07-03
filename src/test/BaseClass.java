package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BaseClass {

	public static WebDriver driver;
	public static ExtentReports report;
	public static ExtentTest test;

	XSSFWorkbook wbook;
	XSSFSheet sheet;

	SoftAssert soft = new SoftAssert();

	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "chromedriver");

		driver = new ChromeDriver();
		driver.get("https://www.Simplilearn.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

		report = new ExtentReports("ExtentReports.html");

		FileInputStream fis;
		try {
			fis = new FileInputStream("InputData.xlsx");
			wbook = new XSSFWorkbook(fis);
			sheet = wbook.getSheetAt(0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@AfterMethod
	public void tearDown() {
		report.endTest(test);
		report.flush();

		driver.close();

		soft.assertAll();
	}

}
