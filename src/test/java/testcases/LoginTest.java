package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.TestBase;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends TestBase{
	
	//global variable
	LoginPage loginPg;
	HomePage homePg;
	
	//Constructor of current class which calls parent class to perform initalization of it constructor prop file
	public LoginTest(){
		super();
	}
	
	
	@BeforeTest
	public void setUp(){
		initialization(); //direct calling method of parent class
		loginPg = new LoginPage(); //object initialize to call non static method of LoginPage class
	}
	
	
	@Test(priority=1)
	public void loginPageTitleTest(){
		
		//calling title method
		String title = loginPg.validateLoginPageTitle();
		Assert.assertEquals(title, "#1 Free CRM Software Power Up your Entire Business Free Forever");
	}
	
	@Test(priority=2)
	public void crmLogoImageTest(){
		
		//calling imagelogo method
		boolean flag = loginPg.validateCRMImage();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void loginTest(){
		
		//calling login method and storing returned HomePage Object into global variable homePg
		homePg = loginPg.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@AfterTest
	public void tearDown(){
		driver.quit();
	}
	
	
	
	

}
