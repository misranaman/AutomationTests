package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//*[contains(text(),'User: Naveen K')]")
	WebElement userNameLabel;

	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement contactLink;

	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	WebElement dealsLink;

	@FindBy(xpath = "//a[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	@FindBy(xpath="//a[text()='New Contact']")
	WebElement newContact; 

	// intializing the elements of HomePage
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyHomePageTitle() {
		return (driver.getTitle());
	}
	
	public boolean verifyCorrectUserName()
	{
		return(userNameLabel.isDisplayed());
	}
	
	public ContactsPage clickContacLink()
	{
		contactLink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickDealsLink()
	{
		dealsLink.click();
		return new DealsPage();
	}
	
	public TasksPage clickTasksPage()
	{
		tasksLink.click();
		return new TasksPage();
	}
	
	public void clickOnNewContactLink()
	{
		Actions action=new Actions(driver);
		action.moveToElement(contactLink).build().perform();
		newContact.click();
	}

}
