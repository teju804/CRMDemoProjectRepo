package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.Contactspage;
import com.crm.qa.pages.Homepage;
import com.crm.qa.pages.Loginpage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	Loginpage loginpage;
	Homepage homepage;
	TestUtil testutil;
	Contactspage contactspage;
	

	public HomePageTest() {
		super();
	}
@BeforeMethod	
public void SetUp() throws InterruptedException {
initialization();
loginpage=new Loginpage();
testutil=new TestUtil();
contactspage =new Contactspage();
homepage=loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
}

@Test(priority=1)
public void verifyHomePageTitleTest()
{
	String homepageTitle=homepage.verifyHomePageTitle();
	Assert.assertEquals(homepageTitle,"CRMPRO","home page title is not mathed");
}
@Test(priority=2)
public void verifyUserNameTest() {
	testutil.switchToFrame();
	Assert.assertTrue(homepage.verifyCorrectUserName());
}
@Test(priority=3)
public void verifyContCtsLinkTest() {
	testutil.switchToFrame();
	contactspage=homepage.ClickOnContactsLink();
}
@AfterMethod
public void tearDown() {
	driver.quit();
}
}
