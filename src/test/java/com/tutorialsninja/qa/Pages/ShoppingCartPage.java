package com.tutorialsninja.qa.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {

	public WebDriver driver;
	 
	
	@FindBy(xpath = "//div[@id='content']//p[contains(text(),'Your shopping cart is empty!')]")
	private WebElement shoppingCartMassege;
	
	public ShoppingCartPage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	
}
	public String retrieveEmptyShoppingCartMessage() {
		String WarningText = shoppingCartMassege.getText();
		return WarningText;
		
	}
}
	
