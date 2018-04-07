package com.crm.qa.testcases;


//home
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {

	HomePage homepage;
	LoginPage loginpage;
	ContactsPage contactpage;
	TestUtil testutil;
	
	String sheetName="contacts";

	public ContactsPageTest() {
		super();

	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new LoginPage();
		testutil=new TestUtil();
		// contactpage=new ContactsPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		testutil.switchToFrame();
		contactpage = homepage.clickContacLink();
	}

	@Test(priority=1)
	public void verifyContactsPageLabelTest() {
		Assert.assertTrue(contactpage.verifyContactsPageLogo());
	}

	@Test(priority=2)
	public void selectSingleContactTest() {
		contactpage.selectContactByName("abc dddd");
	}

	@Test(priority=3)
	public void selectMultipleContactTest() {
		contactpage.selectContactByName("abc dddd");
		contactpage.selectContactByName("Amit Kulkarni");

	}
	
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	
	@Test(priority=4, dataProvider="getCRMTestData")
	public void validateCreateNewContact(String title, String firstName, String lastName, String company){
		homepage.clickOnNewContactLink();
		//contactsPage.createNewContact("Mr.", "Tom", "Peter", "Google");
		contactpage.createNewContact(title, firstName, lastName, company);
		
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
