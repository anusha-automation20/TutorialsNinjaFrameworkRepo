package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.SearchPage;

public class SearchTest extends Base {

	public SearchTest() {
		super();
	}

	public WebDriver driver;
	SearchPage searchPage;
	HomePage homePage;

	@BeforeMethod
	public void setup() {
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browser"));
		homePage = new HomePage(driver);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(priority = 1)
	public void verifySearchWithValidProduct() {

		searchPage = homePage.searchForAProduct(dataProp.getProperty("validProduct"));

		Assert.assertTrue(searchPage.displayStatusOfValidHPProduct());

	}

	// Making this test fail purposefully to validate failure scenarios
	@Test(priority = 2)
	public void verifyWithNonExistentProduct() {

		searchPage = homePage.searchForAProduct(dataProp.getProperty("invalidProduct"));

		Assert.assertEquals(searchPage.retrieveWarningMessageNoProduct(),
				"abcd", "Error message not displayed");
		
		/*Assert.assertEquals(searchPage.retrieveWarningMessageNoProduct(),
				dataProp.getProperty("NoProductTextInSearchResults"), "Error message not displayed");*/
	}
	
	//By adding dependsOnMethods here will skip the below test if the mentioned test is a failure
	@Test(priority = 3, dependsOnMethods = {"verifyWithNonExistentProduct"})
	public void verifySearchWithoutAnyProduct() {

		searchPage = homePage.clickSearchButton();

		Assert.assertEquals(searchPage.retrieveWarningMessageNoProduct(),
				dataProp.getProperty("NoProductTextInSearchResults"), "Error message not displayed");
	}

}
