package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	
	WebDriver d ;
	
	@FindBy(linkText = "HP LP3065")
	private WebElement validHPProduct ;
	
	@FindBy(xpath = "//div[@id='content']/h2/following-sibling::p")
	private WebElement noProductErrorMsg;
	
	public SearchPage(WebDriver driver) {
		this.d = driver;
		PageFactory.initElements(d, this);
	}
	
	public boolean displayStatusOfValidHPProduct() {
		return validHPProduct.isDisplayed(); 
	}

	public String retrieveWarningMessageNoProduct() {
		return noProductErrorMsg.getText();
	}
	

}
