package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

	WebDriver d;

	@FindBy(id = "input-firstname")
	private WebElement inputFirstName;

	@FindBy(id = "input-lastname")
	private WebElement inputLastName;

	@FindBy(id = "input-email")
	private WebElement inputEmail;

	@FindBy(id = "input-telephone")
	private WebElement inputTelephone;

	@FindBy(id = "input-password")
	private WebElement inputPasswd;

	@FindBy(id = "input-confirm")
	private WebElement confirmPasswd;

	@FindBy(name = "agree")
	private WebElement inputAgree;

	@FindBy(xpath = "//input[@type='submit']")
	private WebElement continueButton;

	@FindBy(xpath = "//input[@name='newsletter'][@value='1']")
	private WebElement yesNewsletterOption;

	@FindBy(xpath = "//div[contains(@class,'alert alert-danger alert-dismissible')]")
	private WebElement duplicateEmailWarning;

	@FindBy(xpath = "//div[contains(@class,'alert alert-danger alert-dismissible')]")
	private WebElement privacyPolicyWarningMessage;

	@FindBy(xpath = "//input[@id='input-firstname']/following-sibling::div")
	private WebElement missingFNWarningMsg;

	@FindBy(xpath = "//input[@id='input-lastname']/following-sibling::div")
	private WebElement missingLNWarningMsg;

	@FindBy(xpath = "//input[@id='input-email']/following-sibling::div")
	private WebElement missingEmailText;

	@FindBy(xpath = "//input[@id='input-telephone']/following-sibling::div")
	private WebElement missingTelephoneText;

	@FindBy(xpath = "//input[@id='input-password']/following-sibling::div")
	private WebElement missingPasswordText;

	// Constructor

	public RegisterPage(WebDriver driver) {
		this.d = driver;

		PageFactory.initElements(d, this);
	}

	// Actions
	public void enterFirstName(String firstNameText) {
		inputFirstName.sendKeys(firstNameText);
	}

	public void enterLastName(String lastNameText) {
		inputLastName.sendKeys(lastNameText);
	}

	public void enterEmail(String emailText) {
		inputEmail.sendKeys(emailText);
	}

	public void enterTelephone(String telephoneText) {
		inputTelephone.sendKeys(telephoneText);
	}

	public void enterPassword(String passwordText) {
		inputPasswd.sendKeys(passwordText);
	}

	public void confirmPassword(String confirmPasswordText) {
		confirmPasswd.sendKeys(confirmPasswordText);
	}

	public void newsLetterOptionClick() {
		yesNewsletterOption.click();
	}

	public void enterAgreement() {
		inputAgree.click();
	}

	public AccountSuccessPage continueWithRegistration() {
		continueButton.click();
		return new AccountSuccessPage(d);
	}

	public String retrieveDuplicateEmailWarningMessage() {
		return duplicateEmailWarning.getText();
	}

	public String retrieveMissingFNWarning() {
		return missingFNWarningMsg.getText();
	}

	public String retrieveMissingLNWarning() {
		return missingLNWarningMsg.getText();
	}

	public String retrieveMissingEmailWarning() {
		return missingEmailText.getText();
	}

	public String retrieveMissingTelString() {
		return missingTelephoneText.getText();
	}

	public String retrieveMissingPasswordWarning() {
		return missingPasswordText.getText();
	}

	public String retrieveMissingPrivacyPolicy() {
		return privacyPolicyWarningMessage.getText();
	}

	public AccountSuccessPage regiterWithMandatoryFields(String firstNameText, String lastNameText, String emailText, String telephoneText,
			String passwordText, String confirmPasswordText) {
		inputFirstName.sendKeys(firstNameText);
		inputLastName.sendKeys(lastNameText);
		inputEmail.sendKeys(emailText);
		inputTelephone.sendKeys(telephoneText);
		inputPasswd.sendKeys(passwordText); 
		confirmPasswd.sendKeys(confirmPasswordText);
		inputAgree.click();
		continueButton.click();
		return new AccountSuccessPage(d);
	}
	
	public AccountSuccessPage regiterWithAllFields(String firstNameText, String lastNameText, String emailText, String telephoneText,
			String passwordText, String confirmPasswordText) {
		inputFirstName.sendKeys(firstNameText);
		inputLastName.sendKeys(lastNameText);
		inputEmail.sendKeys(emailText);
		inputTelephone.sendKeys(telephoneText);
		inputPasswd.sendKeys(passwordText); 
		confirmPasswd.sendKeys(confirmPasswordText);
		yesNewsletterOption.click();
		inputAgree.click();
		continueButton.click();
		return new AccountSuccessPage(d);
	}
}
