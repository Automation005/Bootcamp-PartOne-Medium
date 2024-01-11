package com.tutorialsninja.qa.TestCases;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.Pages.CheckoutPage;
import com.tutorialsninja.qa.Pages.HomePage;
import com.tutorialsninja.qa.Pages.LoginPage;
import com.tutorialsninja.qa.Pages.ProductInfoPage;
import com.tutorialsninja.qa.Pages.SearchPage;
import com.tutorialsninja.qa.TestBase.TestBase;

public class CheckOutTest extends TestBase {
	public CheckOutTest() throws Exception {
		super();
	}

	public WebDriver driver;
	public HomePage homepage;
	public SearchPage searchpage;
	public ProductInfoPage productinfopage;
	public CheckoutPage checkoutpage;
	public LoginPage loginpage;

	@BeforeMethod
	public void setup() {
		driver = initializeBrowserAndOpenApplication(prop.getProperty("browser"));
		HomePage homepage = new HomePage(driver);
		homepage.ckickOnMyAccountDropDownMenu();
		homepage.selectLoginOption();

	}

	@Test
	public void checkOutOfThePtoduct() throws Exception {
		homepage = new HomePage(driver);
		checkoutpage = new CheckoutPage(driver);
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterEmailAddress(prop.getProperty("validEmail"));
		loginpage.enterPassword(prop.getProperty("validPassword"));
		loginpage.clickOnLoginButton();
		homepage.enterProductDetail(prop.getProperty("validProduct"));
		SearchPage searchpage = homepage.clickOnSearchIcone();
		Assert.assertTrue(searchpage.verifyDisplayStatusOfValidProduct());
		productinfopage = searchpage.clickOnAddToCartButton();
		
		Assert.assertTrue(productinfopage.validateDisplayStatusProdInfo());
		productinfopage.clickOnAddToCartButtonInProdInfo();
		
		String actualMessage = productinfopage.retrieveProductAddToShoppingCartMessage();
		String expectedMessage = prop.getProperty("productaddedSuccessfullyToCartMessage");
		Assert.assertTrue(actualMessage.contains(expectedMessage));
		Thread.sleep(2000);
		productinfopage.shoppingCartButton();
		productinfopage.checkOutButton();
		
		JavascriptExecutor jse =(JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0, 5000)");
		checkoutpage.clickOnBillingDetailsContinueButton();
		
		JavascriptExecutor jse1 =(JavascriptExecutor)driver;
		jse1.executeScript("window.scrollBy(0, 3000)");
		checkoutpage.clickOnDeliveryDetailsContinueButton();
		
		JavascriptExecutor jse3 =(JavascriptExecutor)driver;
		jse3.executeScript("window.scrollBy(0, 3000)");
		checkoutpage.clickOnDeliveryMethodContinueButton();
			
		JavascriptExecutor jse4 =(JavascriptExecutor)driver;
		jse4.executeScript("window.scrollBy(0, 3000)");
		
		checkoutpage.clickOnTermAndConditionCheckBoxContinueButton();
		checkoutpage.clickOnPaymentMethodContinueButton();
		
		checkoutpage.clickOnConfirmOrderButtonContinueButton();
		
		String actualOrderPlacedMessage = checkoutpage.retieveOrderSuccessfullyProcessedMessageText();
		
		String expectedOrderPlacedMessage = prop.getProperty("orderSuccessMessage");
		Assert.assertTrue(actualOrderPlacedMessage.contains(expectedOrderPlacedMessage));
		
		checkoutpage.clickConfirmOrdreButton();
	
	}

	@AfterMethod
	public void tearDown() {
		 driver.quit();
	}

}