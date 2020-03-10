package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.Contactspage;
import com.crm.qa.pages.Homepage;
import com.crm.qa.pages.Loginpage;

public class LoginPageTest extends TestBase {
	Loginpage loginpage;
	Homepage homepage;

	public LoginPageTest() {
		super();
	}
@BeforeMethod	
public void SetUp() {
	initialization();
	loginpage=new Loginpage();
}


@Test(priority =1)
public void LoginPageTitleTest() {
	String Title=loginpage.validateLoginPageaTitle();
	Assert.assertEquals(Title, "CRMPRO - CRM software for customer relationship management, sales, and support.");
}
@Test(priority=2)
public void crmLoginImageTest() {
	boolean flag=loginpage.validateCRMImage();
	Assert.assertTrue(flag);
}
@Test(priority=3)
public void loginTest() throws InterruptedException {
	homepage=loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
}
@AfterMethod
public void tearDown() {
	driver.quit();
}
}



