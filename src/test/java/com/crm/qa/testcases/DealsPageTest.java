package com.crm.qa.testcases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.Contactspage;
import com.crm.qa.pages.Dealspage;
import com.crm.qa.pages.Homepage;
import com.crm.qa.pages.Loginpage;
import com.crm.qa.util.TestUtil;

public class DealsPageTest extends TestBase {
	Loginpage loginpage;
	Homepage homepage;
	//Contactspage contactspage;
	TestUtil testUtil;
	Dealspage dealspage;
	
	public DealsPageTest() {
		super();
	}

 @BeforeMethod
		public void SetUp() throws InterruptedException {
			initialization();	
			testUtil = new TestUtil();
			dealspage = new Dealspage();
			loginpage = new Loginpage();
			homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
			testUtil.switchToFrame();
		}
 @DataProvider
 public Object[][] getCRMTestData() throws IOException {
 	Object data[][]= TestUtil.getTestData("Deals");
 	return data;
 }
 	@Test(dataProvider="getCRMTestData") 
		public void validateCreateNewDeals(String title, String com, String amt) throws IOException  {
			homepage.ClickOnNewDeals();
			dealspage.createNewDeals(title, com, amt);
			String innerText = driver.findElement(By.xpath("//a[contains(text(),'Accenture')]")).getText();
			System.out.println(innerText);
//			List<WebElement> radio=driver.findElements(By.xpath("//td//td[2]//table[1]//tbody[1]//tr[6]//td[2]//input[1]"));
//			
//			for(int i=0;i<radio.size();i++)
//			{
//				WebElement localradio= radio.get(i);
//			String value=	localradio.getAttribute("value");
//			System.out.println("vlues from butoons"+value);
//			}
		}
		@AfterMethod
		public void tearDown() {
			driver.quit();
		}
}
