package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement; 
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSuccessPage {
	
	WebDriver d ;
	
	@FindBy(xpath = "//div[@id='content']/h1")
	private WebElement accountSuccess;
	
	public AccountSuccessPage(WebDriver driver) {
		this.d = driver ;
		PageFactory.initElements(d, this);
	}

	public String retrieveAccountSuccessPageHeading() {
		return accountSuccess.getText();
	}
}
