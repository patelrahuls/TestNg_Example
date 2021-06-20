package test;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Testcase1 {
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("Inside Before Test");
	}
	
	@BeforeMethod
	public void Setup() {
		System.out.println("Inside Before Method");
	}
	
	@BeforeGroups("Regression")
	public void beforeGrup() {
		System.out.println("Inside Before Group");
	}
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Inside Before Suite");
	}
	
	@Test(groups = {"Sanity"})
	public void LoginTest() {
		System.out.println("Inside Login Test");
	}
	
	@Test(enabled=false)
	public void SignUpTest() {
		System.out.println("Inside SignUp Test");
	}
	
	@Test(groups = {"Regression"})
	public void RandomTests() {
		System.out.println("Inside Random Test");
	}
	
	@Test(groups = {"Regression"})
	public void LogoutTests() {
		System.out.println("Inside Logout Test");
	}
	
	@Test(groups = {"Regression","Sanity"})
	public void DataEntryTests() {
		System.out.println("Inside Data Entry Test");
	}
	
	@AfterMethod
	public void WrapUp() {
		System.out.println("Inside After Method");
	}
	
	@AfterTest
	public void AfterTestMethod() {
		System.out.println("Inside After Test");
	}
	
	@AfterGroups("Regression")
	public void afterGrup() {
		System.out.println("Inside After Group");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("Inside After Suite");
	}



}
