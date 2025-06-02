package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.TestBase;
import pages.ContactsPage;
import pages.HomePage;
import pages.LoginPage;
import util.TestUtil;

public class HomeTest extends TestBase {
	
	//global variable
	LoginPage loginPg;
	HomePage homePg;
	TestUtil tUtil;
	ContactsPage contactsPg;

	//Constructor of current class which calls parent class to perform initalization of it constructor prop file
	public HomeTest() {
		super();
	}
	
	@BeforeTest
	public void setUp() {
		initialization(); // direct calling of parent class method
		//object creating of class and storing in global variable
		tUtil = new TestUtil(); 
		contactsPg = new ContactsPage();
		loginPg = new LoginPage();
		//calling login method and storing returned HomePage Object into global variable homePg
		homePg = loginPg.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@Test(priority=1)
	public void verifyHomePageTitleTest(){
		
		String homePageTitle = homePg.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO","Home page title not matched");
	}
	
	@Test(priority=2)
	public void verifyUserNameTest(){
		
		tUtil.switchToFrame();//switching frame with util class non static method
		Assert.assertTrue(homePg.verifyCorrectUserName());
	}
	
	@Test(priority=3)
	public void verifyContactsLinkTest(){
		
		tUtil.switchToFrame();
		contactsPg = homePg.clickOnContactsLink(); // calling HomePage class's method and storing its returned object into ContactsPage object
	}
	
	
	@AfterTest
	public void tearDown(){
		driver.quit();
	}
	
	

}
