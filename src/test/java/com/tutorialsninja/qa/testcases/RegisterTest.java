package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.AccountSuccessPage;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.RegisterPage;
import com.tutorialsninja.qa.utils.Utilities;

public class RegisterTest extends Base {

	RegisterPage registerPage;
	AccountSuccessPage accountSuccessPage;

	public RegisterTest() {
		super();
	}

	public WebDriver driver;

	@BeforeMethod
	public void setup() {
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browser"));
		HomePage homePage = new HomePage(driver);
		registerPage = homePage.navigateToRegisterPage();

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(priority = 1)
	public void verifyRegisteringAccountWithMandatoryFields() {

		accountSuccessPage = registerPage.regiterWithMandatoryFields(dataProp.getProperty("firstName"),
				dataProp.getProperty("lastName"), Utilities.generateEmailTimeStamp(),
				dataProp.getProperty("telephoneNumber"), prop.getProperty("validPasswd"),
				prop.getProperty("validPasswd"));

		String actualTextAccountSuccess = accountSuccessPage.retrieveAccountSuccessPageHeading();
		Assert.assertEquals(actualTextAccountSuccess, dataProp.getProperty("accountSuccessfullyCreatedHeading"),
				"Account success page failed");
	}

	@Test(priority = 2)
	public void verifyRegisteringAccountWithAllFields() {

		accountSuccessPage = registerPage.regiterWithAllFields(dataProp.getProperty("firstName"),
				dataProp.getProperty("lastName"), Utilities.generateEmailTimeStamp(),
				dataProp.getProperty("telephoneNumber"), prop.getProperty("validPasswd"),
				prop.getProperty("validPasswd"));

		String actualTextAccountSuccess = accountSuccessPage.retrieveAccountSuccessPageHeading();
		Assert.assertEquals(actualTextAccountSuccess, dataProp.getProperty("accountSuccessfullyCreatedHeading"),
				"Account success page failed");
	}

	@Test(priority = 3)
	public void verifyRegisteringAnAccountWithExistingEmailAddress() {

		registerPage.regiterWithAllFields(dataProp.getProperty("firstName"), dataProp.getProperty("lastName"),
				prop.getProperty("existingEmail"), dataProp.getProperty("telephoneNumber"),
				prop.getProperty("validPasswd"), prop.getProperty("validPasswd"));

		String actualWarning = registerPage.retrieveDuplicateEmailWarningMessage();
		Assert.assertTrue(actualWarning.contains(dataProp.getProperty("duplicateEmailWarning")),
				"Warning message about duplicate email address is not displayed");
	}

	@Test(priority = 4)
	public void verifyRegisteringAnAccountWithoutProvidingAnyDetails() {

		registerPage.continueWithRegistration();

		Assert.assertTrue(
				registerPage.retrieveMissingPrivacyPolicy().contains(dataProp.getProperty("privacyPolicyWarning")),
				"Missing warning message to agree Privacy Policy");

		Assert.assertTrue(registerPage.retrieveMissingFNWarning().contains(dataProp.getProperty("firstNameWarning")),
				"Missing first name warning message");

		Assert.assertTrue(registerPage.retrieveMissingLNWarning().contains(dataProp.getProperty("lastNameWarning")),
				"Missing last name warning message");

		Assert.assertTrue(
				registerPage.retrieveMissingEmailWarning().contains(dataProp.getProperty("invalidEmailAddressWarning")),
				"Missing email address warning");

		Assert.assertTrue(registerPage.retrieveMissingTelString().contains(dataProp.getProperty("telephoneWarning")),
				"Missing telephone number warning");

		Assert.assertTrue(
				registerPage.retrieveMissingPasswordWarning().contains(dataProp.getProperty("passwordWarning")),
				"Missing password warning");

	}
}
