package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactpage;
	TestUtil testutil;
	
	
	public HomePageTest()
	{
		super();
	}
	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		initialization();
		loginpage=new LoginPage();
		testutil=new TestUtil();
		contactpage=new ContactsPage();
		homepage=loginpage.login(prop.getProperty("username") ,prop.getProperty("password"));
		System.out.println("Object of home page looks like"+homepage);
	}
	

	@Test(priority=1)
	public void verifyHomePageTitleTest()
	{
		String homepagetitle=homepage.verifyHomePageTitle();
		Assert.assertEquals(homepagetitle, "CRMPRO","Home Page Title not matched");
	}
	
	@Test(priority=2)
	public void verifyUserNametest()
	{
		testutil.switchToFrame();
		Assert.assertTrue(homepage.verifyCorrectUserName());
	}
	
	@Test(priority=3)
	public void verifyContactsLinkTest()
	{
		testutil.switchToFrame();
		contactpage=homepage.clickContacLink();
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

	
	

}
