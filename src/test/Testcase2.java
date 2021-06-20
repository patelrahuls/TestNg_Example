package test;

import org.testng.annotations.Test;

public class Testcase2 {

	@Test(groups = {"Regression"},priority=0)
	public void HomepageTest() {
		System.out.println("Inside Home Page Test");
	}
	
	@Test(groups = {"Regression"},priority=1,dependsOnMethods="HomepageTest3")
	public void HomepageTest2() {
		System.out.println("Inside Home Page 2 Test");
	}
	
	@Test(groups = {"Sanity"},priority=1)
	public void HomepageTest3() {
		System.out.println("Inside Home Page 3 Test");
	}
	
	@Test(groups = {"Regression"},priority=0)
	public void HomepageTest4() {
		System.out.println("Inside Home Page 4 Test");
	}

}
