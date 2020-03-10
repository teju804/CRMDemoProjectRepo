package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class Dealspage extends TestBase{
	@FindBy(xpath = "//td[contains(text(),'Deals')]")
	WebElement Deals;
	@FindBy(id = "title")
	WebElement Title;
	@FindBy(name = "client_lookup")
	WebElement company;
	@FindBy(id="amount")
	WebElement amount;
	@FindBy(xpath = "//body/table/tbody/tr/td/table/tbody/tr/td/fieldset[@class='fieldset']/form[@id='prospectForm']/table/tbody/tr/td/input[1]")
	WebElement saveBtn;
			
	public Dealspage() {
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * @param title
	 * @param com
	 * @throws IOException
	 */
	public void createNewDeals(String title, String com,String amt ) throws IOException {
		Title.sendKeys(title);
		company.sendKeys(com);
		amount.sendKeys(amt);
		saveBtn.click();
}
}