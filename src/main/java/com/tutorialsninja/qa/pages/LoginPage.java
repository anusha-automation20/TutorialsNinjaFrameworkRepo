package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver d;
	@FindBy(id = "input-email")
	private WebElement emailElement;

	@FindBy(id = "input-password")
	private WebElement passwordElement;

	@FindBy(xpath = "//input[@type='submit']")
	private WebElement submitElement;

	@FindBy(xpath = "//div[contains(@class,'alert alert-danger alert-dismissible')]")
	private WebElement emailPasswordNotMatchingElement;

	public LoginPage(WebDriver driver) {
		this.d = driver;
		PageFactory.initElements(d, this);
	}

	/*Combining below 3 methods into 1 
	 * public void enterEmailAddress(String email) {
		emailElement.sendKeys(email);
	}

	public void enterPassword(String password) {
		passwordElement.sendKeys(password);
	}

	public AccountPage clickOnLoginButton() {
		submitElement.click();
		return new AccountPage(d);
	}*/

	public AccountPage login(String email, String password) {
		emailElement.sendKeys(email);
		passwordElement.sendKeys(password);
		submitElement.click();
		return new AccountPage(d);
	}
	

	public String retrieveEmailPasswordNotMatchingWarningMsgTxt() {
		return emailPasswordNotMatchingElement.getText();

	}

}
