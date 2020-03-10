package com.crm.qa.testcases;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.Contactspage;
import com.crm.qa.pages.Homepage;
import com.crm.qa.pages.Loginpage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	Loginpage loginpage;
	Homepage homepage;
	Contactspage contactspage;
	TestUtil testUtil;

	public ContactsPageTest() {
		super();
	}

	//@BeforeMethod
	public void SetUp() throws InterruptedException {
		initialization();
		testUtil = new TestUtil();
		contactspage = new Contactspage();
		loginpage = new Loginpage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
	}

	@Test(priority = 1)
	public void verifyContactspageLabel() {
		Assert.assertTrue(contactspage.verifyContactsLabel(), "contacts label is missing on the page");
	}

	@Test(priority = 2)
	public void selectContactsTest() {
		contactspage.selectContactsByName("ravi torri");

	}

	@Test(priority = 3)
	public void selectMultipleContactsTest() {
		contactspage.selectContactsByName("ravi torri");
		contactspage.selectContactsByName("hari manam");
	}

//@DataProvider
//public Object[][] getCRMTestData() throws IOException {
//	Object data[][]= TestUtil.getTestData("Contacts");
//	return data;
//}
	@Test(priority = 5)//,dataProvider="getCRMTestData")
	public void validateCreateNewContact(String title, String firstName, String lastName, String Company) throws InterruptedException, IOException {
		 homepage.clickOnNewContactsLink();
		 contactspage.createNewContacts(title, firstName, lastName, Company);
		 //TestUtil.getTestData(TestUtil.Sheet_Name);
//		ArrayList<String> al1= new ArrayList<String>();
//		al.add("ravi torri");
//		al.add("hari manam");
//		contactspage.SelectMultipleContact(al);
     	String tablexpath = "//form[@id='vContactsForm']//table[@class='datacard']/tbody";
		TestUtil.VerifyDataExists(tablexpath,"Mobile","9876535017");
     	 //It is for total number of rows and cols 
     	//TestUtil.VerifyDataExists(tablexpath);
		
	}


	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
