package com.crm.qa.pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class Contactspage extends TestBase {

	@FindBy(xpath = "//td[contains(text(),'Contacts')]")
	WebElement contactsLabel;
	@FindBy(id = "first_name")
	WebElement firstname;
	@FindBy(id = "surname")
	WebElement surname;
	@FindBy(name = "client_lookup")
	WebElement company;
	@FindBy(xpath = "//body/table/tbody/tr/td/table/tbody/tr/td/fieldset[@class='fieldset']/form[@id='contactForm']/table/tbody/tr/td/input[2]")
	WebElement saveBtn;
	public Contactspage() {
		PageFactory.initElements(driver, this);
	}

	public boolean verifyContactsLabel() {
		return contactsLabel.isDisplayed();
	}

	public void selectContactsByName(String name) {

		driver.findElement(By.xpath("//form[@id='vContactsForm']//tr[5]//td[2] \r\n")).click();
	}

	public void createNewContacts(String title, String ftname, String lname, String com) throws InterruptedException {
		Select select = new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);
		firstname.sendKeys(ftname);
		surname.sendKeys(lname);
		company.sendKeys(com);
		saveBtn.click();
	}

	public void SelectMultipleContact(ArrayList<String> al) {
		// 
		for (String contactName : al) {
			driver.findElement(By.xpath("//a[contains(text(),'"+contactName+"')]/parent::td//preceding-sibling::td//input[@name='contact_id']")).click();
		}	
	}
public void SelectCheckBox() {
	driver.findElement(By.xpath("//form[@id='vContactsForm']//tr[8]//td[1]//input[1]"));
	
}
}


