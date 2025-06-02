package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class LoginPage extends TestBase{
	
	//Page Factory - OR:
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="//button[contains(text(),'Sign Up')]")
	WebElement signUpBtn;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement crmLogo;
	
	
	//Initializing the Page Factory Objects of current LoginPage class with its constructor:
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	
	//gets actual title of page and returns it as string when invokes
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	
	//checks for logo on page and returns true/false when invokes
	public boolean validateCRMImage(){
		return crmLogo.isDisplayed();
	}
	
	
	//This method perfoms login and returns object of landing page which is HomePage
	public HomePage login(String un, String pwd){
		
		username.sendKeys(un);
		password.sendKeys(pwd);
		//Here JavscriptExecutor object used as loginbtn is not clickable due to not scrolled into view
		    	JavascriptExecutor js = (JavascriptExecutor)driver;
		    	js.executeScript("arguments[0].click();", loginBtn);    	
		return new HomePage(); //returning object of homePage after login
	}
	
}
