package test;

import org.testng.annotations.Test;
import pages.LoginPage;

import org.testng.annotations.Parameters;

public class LoginTest extends BaseClass {

	@Test(enabled=false)
	@Parameters({ "username", "password" })
	public void LoginTest(String uname, String pass) throws InterruptedException {
		
		LoginPage Loginobj = new LoginPage();
		Loginobj.login(uname,pass);	
	}
	
	@Test
	@Parameters({ "username", "password" })
	public void LoginTest2() throws InterruptedException {
		
		LoginPage Loginobj = new LoginPage();
		
		String uname= sheet.getRow(1).getCell(0).getStringCellValue();
		String pass= sheet.getRow(1).getCell(0).getStringCellValue();
		Loginobj.login(uname,pass);
	
	}

	

}
