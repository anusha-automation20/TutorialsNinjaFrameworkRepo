package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
	 
	WebDriver d ; 

	@FindBy(linkText = "Edit your account information")
	private  WebElement editYourAccountInfo ;
	
	public AccountPage(WebDriver driver) {
		this.d = driver ;
		PageFactory.initElements(d, this);
	}

	public boolean getDisplayStatusOfEditYourAccountInformation() {
		return editYourAccountInfo.isDisplayed();
	}
}
