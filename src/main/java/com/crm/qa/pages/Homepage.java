package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class Homepage extends TestBase {
@FindBy(xpath ="//td[contains(text(),'User: teju prathro')]")
WebElement UserNameLable;
@FindBy(xpath = "//a[contains(text(),'Contacts')]")
WebElement contactsLink;
@FindBy(xpath="//a[contains(text(),'New Contact')]")
WebElement newcontactsLink;
@FindBy(xpath = "//a[contains(text(),'Deals')]")
WebElement DealsLink;
@FindBy(xpath = "//a[contains(text(),'New Deal')]")
WebElement NewDealsLink;
@FindBy(xpath ="//a[contains(text(),'Tasks')]")
WebElement TasksLink;

public Homepage()
{
	PageFactory.initElements(driver, this);
}
public String verifyHomePageTitle() {
	return driver.getTitle();
}
public boolean verifyCorrectUserName() {
	return UserNameLable.isDisplayed();
}
public Contactspage ClickOnContactsLink()
{
	contactsLink.click();
	return new Contactspage();
}

public Dealspage ClickOnNewDeals()
{
	Actions action=new Actions(driver);
	action.moveToElement(DealsLink).build().perform();
	NewDealsLink.click();
	return new Dealspage();
}
	public void clickOnNewContactsLink() throws InterruptedException 
	{
		boolean flag = contactsLink.isDisplayed();
		System.out.println(flag);
		Actions action=new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		Thread.sleep(3000);
		flag = newcontactsLink.isDisplayed();
		System.out.println(flag);
		newcontactsLink.click();
	}
	
	}
