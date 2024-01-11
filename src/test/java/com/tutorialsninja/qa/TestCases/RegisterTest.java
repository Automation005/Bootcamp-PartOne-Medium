package com.tutorialsninja.qa.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.Pages.AccountSuccessPage;
import com.tutorialsninja.qa.Pages.HomePage;
import com.tutorialsninja.qa.Pages.RegisterPage;
import com.tutorialsninja.qa.TestBase.TestBase;
import com.tutorialsninja.qa.Utilities.Util;

public class RegisterTest extends TestBase{
	
	public RegisterTest() throws Exception {
		super();	
	}

	public WebDriver driver;
	public HomePage homepage;
	public RegisterPage registerpage;
	public AccountSuccessPage accountsuccesspage ;
	
	

	@BeforeMethod
	public void setup() {
		driver = initializeBrowserAndOpenApplication(prop.getProperty("browser"));
		HomePage homepage = new HomePage(driver);
		homepage.ckickOnMyAccountDropDownMenu();
		homepage.selectRegisterOption();
		
	}
	@Test (priority =1)
	public void verifyRegisterWithMandatoryFields () {
		homepage = new HomePage(driver);
		registerpage = new RegisterPage(driver);
		registerpage.enterFirstName(prop.getProperty("firstName"));
		registerpage.enterLastName(prop.getProperty("lastName"));
		registerpage.enterEmail(Util.emailWithDateTimeStamp());
		registerpage.enterTelephone(prop.getProperty("mobile"));
		registerpage.enterPassword(prop.getProperty("validPassword"));
		registerpage.enterConfirmPassword(prop.getProperty("validPassword"));
		registerpage.clickOnPrivacyPolicyCheckBox();
		registerpage.clickOnContinueButton();
		accountsuccesspage = new AccountSuccessPage(driver);
		String actualAccountCreatedMessage = accountsuccesspage.retieveAccountSuccessMessage();
		String expectedAccountCreatedMessage = prop.getProperty("accountSuccessMessage");
		Assert.assertTrue(actualAccountCreatedMessage.contains(expectedAccountCreatedMessage));		
	}
		
	@AfterMethod
	public void tearDown() {
	 driver.quit();
	
	}
}
