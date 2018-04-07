package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	public LoginPageTest() {
	 super(); //calling superclass constructor	
	}
	
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginpage=new LoginPage();
	}
	
	@Test(priority=1)
	public void loginPageTitleTest()
	{
		String title=loginpage.validatePageTitle();
		Assert.assertEquals(title, "Free CRM in the cloud software boosts sales");
	}
	
	@Test(priority=2)
	public void crmLogoImageTest()
	{
		boolean flag=loginpage.valdiateCRMImage();
		Assert.assertTrue(flag);
		
	}
	
	@Test(priority=3)
	public void loginTest() throws InterruptedException
	{
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
