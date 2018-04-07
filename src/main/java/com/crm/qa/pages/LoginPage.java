package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	// Page Factory-OR
	@FindBy(name = "username")
	WebElement userName;

	@FindBy(name = "password")
	WebElement passWord;

	@FindBy(xpath = "//input[@value='Login']")
	WebElement loginButton;

	@FindBy(xpath = "//button[text()='Sign Up']")
	WebElement signUpBtn;

	@FindBy(xpath = "//img[contains(@alt,'free crm logo')]")
	WebElement crmLogo;

	//Intitializing Objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	//Actions
	public String validatePageTitle() {
		return (driver.getTitle());
	}
	
	public boolean valdiateCRMImage()
	{
		return(crmLogo.isDisplayed());
	}
	
	public HomePage login(String un, String pwd) 
	{
		try {
			Thread.sleep(4000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		userName.sendKeys(un);
		
		passWord.sendKeys(pwd);
	
		loginButton.click();

		return new HomePage();
	}
}
