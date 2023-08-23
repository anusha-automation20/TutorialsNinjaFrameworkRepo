package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver d;

	// Objects
	@FindBy(xpath = "//span[text()='My Account']")
	private WebElement myAccountDropDown;

	@FindBy(linkText = "Login")
	private WebElement loginOption;

	@FindBy(linkText = "Register")
	private WebElement registerOption;

	@FindBy(name = "search")
	private WebElement searchBox;

	@FindBy(xpath = "//div[@id='search']/span/button")
	private WebElement searchButton;

	public HomePage(WebDriver driver) {
		this.d = driver;
		PageFactory.initElements(d, this);
	}

	// Actions

	public void myAccountClick() {
		myAccountDropDown.click();
	}

	public LoginPage selectLogin() {
		loginOption.click();
		return new LoginPage(d);
	}

	public LoginPage navigateToLoginPage() {
		myAccountDropDown.click();
		loginOption.click();
		return new LoginPage(d);
	}

	public RegisterPage selectRegister() {
		registerOption.click();
		return new RegisterPage(d);
	}

	public RegisterPage navigateToRegisterPage() {
		myAccountDropDown.click();
		registerOption.click();
		return new RegisterPage(d);
	}

	public void searchText(String searchItem) {
		searchBox.sendKeys(searchItem);
	}

	public SearchPage clickSearchButton() {
		searchButton.click();
		return new SearchPage(d);
	}
	
	public SearchPage searchForAProduct(String product) {
		searchBox.sendKeys(product);
		searchButton.click();
		return new SearchPage(d);
		
	}
}
