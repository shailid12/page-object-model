package testcases;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import base.TestBase;
import pages.ContactsPage;
import pages.HomePage;
import pages.LoginPage;
import util.TestUtil;

public class ContactsTest extends TestBase{

	LoginPage loginPg;
	HomePage homePg;
	TestUtil testUtil;
	ContactsPage contactsPg;
	
	String sheetName = "contacts";
	
	//Constructor of current class which calls parent class to perform initalization of it constructor prop file
	public ContactsTest(){
			super();
			
	}
	
	
	@BeforeTest
	public void setUp() throws InterruptedException {
		
		initialization(); // direct calling of parent class method
		//object creating of class and storing in global variable
		testUtil = new TestUtil();
		contactsPg = new ContactsPage();
		loginPg = new LoginPage();
		//calling login method and storing returned HomePage Object into global variable homePg
		homePg = loginPg.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame(); //frame switch method calling from util class
		contactsPg = homePg.clickOnContactsLink(); //calling method of homepage and stroing its returned object into contatcts
	}
	
	@Test(priority=1)
	public void verifyContactsPageLabel(){
		Assert.assertTrue(contactsPg.verifyContactsLabel(), "contacts label is missing on the page");
	}
	
	@Test(priority=2)
	public void selectSingleContactsTest(){
		contactsPg.selectContactsByName("test2 test2");
	}
	
	@Test(priority=3)
	public void selectMultipleContactsTest(){
		contactsPg.selectContactsByName("test2 test2");
		contactsPg.selectContactsByName("ui uiii");

	}
	
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = TestUtil.getTestData(sheetName); //calling getTestData method of util class whcih reads excel data from the provided sheetname stored into data
		return data; //return data to method which called DataProvider annotation
	}
	
	
	@Test(priority=4, dataProvider="getCRMTestData") //using dataprovider annotation to get data
	public void validateCreateNewContact(String title, String firstName, String lastName, String company){
		homePg.newContactLink(); //calling new contact link method from Homepage
		contactsPg.createNewContact(title, firstName, lastName, company); //passing recived parameter data from excel to creatNewContact method of ContactPage
		
	}
	
	

	@AfterTest
	public void tearDown(){
		driver.quit();
	}
	
	
	
	
}
