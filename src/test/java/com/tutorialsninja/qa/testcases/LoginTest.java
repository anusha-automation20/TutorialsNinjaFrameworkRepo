package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.AccountPage;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.LoginPage;
import com.tutorialsninja.qa.utils.Utilities;

public class LoginTest extends Base {

	LoginPage loginPage;
	AccountPage accountPage;

	public LoginTest() {
		super();
	}

	public WebDriver driver;

	@BeforeMethod
	public void setup() {
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browser"));
		HomePage homePage = new HomePage(driver);
		loginPage = homePage.navigateToLoginPage();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(priority = 1, dataProvider = "validCredentialsSupplier")
	public void verifyLoginWithValidCredentials(String email, String passwd) throws InterruptedException {

		accountPage = loginPage.login(email, passwd);
		Assert.assertTrue(accountPage.getDisplayStatusOfEditYourAccountInformation());
		Thread.sleep(3000);
	}

	@DataProvider(name = "validCredentialsSupplier")
	public Object[][] supplyTestData() {
		Object[][] data = Utilities.getTestDataFromExcel("Login");
		return data;
	}

	@Test(priority = 2)
	public void verifyLoginWithInvalidCredentials() throws InterruptedException {

		loginPage.login("random" + Utilities.generateEmailTimeStamp() + "@gmail.com",
				dataProp.getProperty("invalidPassword"));

		String actualWarningMessage = loginPage.retrieveEmailPasswordNotMatchingWarningMsgTxt();
		String expectedWarningMessage = dataProp.getProperty("expectedWarningMessageForMismatchEmailPasswd");
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage),
				"Expected Warning Message is not displayed");

		Thread.sleep(2000);

	}

}
