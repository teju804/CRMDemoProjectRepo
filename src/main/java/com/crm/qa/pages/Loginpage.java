package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class Loginpage extends TestBase {
	@FindBy(name="username")
	WebElement username;
	@FindBy(name="password")
	WebElement password;
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	@FindBy(xpath="//button[contains(text(),'Sing Up')]")
	WebElement singUpBtn;
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement crmlogo;
public Loginpage() {
	PageFactory.initElements(driver,this);
}
public String validateLoginPageaTitle() {
	return driver.getTitle();
}
public boolean validateCRMImage() {
	return crmlogo.isDisplayed();
}
public Homepage login(String un,String pwd) throws InterruptedException {
	username.sendKeys(un);
	password.sendKeys(pwd);
	Thread.sleep(3000);
	loginBtn.click();
	return new Homepage();
}
}






