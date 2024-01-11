package com.tutorialsninja.qa.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.Pages.AccountSuccessPage;
import com.tutorialsninja.qa.Pages.HomePage;
import com.tutorialsninja.qa.Pages.RegisterPage;
import com.tutorialsninja.qa.Pages.ShoppingCartPage;
import com.tutorialsninja.qa.TestBase.TestBase;

public class NavigateToHomePage extends TestBase {

	public NavigateToHomePage() throws Exception {
		super();
	}
	public WebDriver driver;
	public HomePage homepage;
	public RegisterPage registerpage;
	public AccountSuccessPage accountsuccesspage;
	public ShoppingCartPage shoppingcartpage;

	@BeforeMethod
	public void setup() {
		driver = initializeBrowserAndOpenApplication(prop.getProperty("browser"));
	}

	@Test
	public void navigateToHomePage() {

		homepage = new HomePage(driver);
		homepage.myAccountIconeAvailable();
		homepage.clickOnShoppingCart();
		shoppingcartpage = new ShoppingCartPage(driver);
		String actualDisplayMessage = shoppingcartpage.retrieveEmptyShoppingCartMessage();
		String expectedDisplayMessage = prop.getProperty("shoppingCartstatus");
		Assert.assertTrue(actualDisplayMessage.contains(expectedDisplayMessage));

	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}