package com.tutorialsninja.qa.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {	
	public WebDriver driver;

	@FindBy(id = "input-email")
	private WebElement emailAddressField;

	@FindBy(id = "input-password")
	private WebElement passwordFieled;

	@FindBy(css = "input.btn.btn-primary")
	private WebElement loginButton;
	
	@FindBy (xpath = "//a[@class='btn btn-primary']")
	private WebElement confirmOrdre;
	
		
	

	
	
	@FindBy(css = "#button-payment-address")
	private WebElement billingDetails;
	
	@FindBy(css = "#button-shipping-address")
	private WebElement deliveryDetails;
	
	@FindBy(css = "#button-shipping-method")
	private WebElement deliveryMethod;
	
	@FindBy(css = "input[type='checkbox']")
	private WebElement termAndConditionCheckBox;
	
	@FindBy(css = "input[id='button-payment-method']")
	private WebElement paymentMethod;
	
	@FindBy(css = "input#button-confirm")
	private WebElement confirmOrderButton;
	
	@FindBy(xpath = "//p[text()='Your order has been successfully processed!']")
	private WebElement orderSuccessfullyProcessed;
	
	

	
	public CheckoutPage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterEmailAddress(String emailText) {
		emailAddressField.sendKeys(emailText);
	}

	public void enterPassword(String passWordText) {
		passwordFieled.sendKeys(passWordText);
	}

	public void clickOnLoginButton() {
		loginButton.click();
	}
	
	
	public void clickOnBillingDetailsContinueButton() {
		billingDetails.click();	
	}
	public void clickOnDeliveryDetailsContinueButton() {
		deliveryDetails.click();
		
	}
	public void clickOnDeliveryMethodContinueButton() {
		deliveryMethod.click();	

}
	public void clickOnTermAndConditionCheckBoxContinueButton() {
		termAndConditionCheckBox.click();
	}
	public void clickOnPaymentMethodContinueButton() {
		paymentMethod.click();
	}
	public void clickOnConfirmOrderButtonContinueButton() {
		confirmOrderButton.click();
	}
		public String retieveOrderSuccessfullyProcessedMessageText() {
			String SuccessMassage = orderSuccessfullyProcessed.getText();
			return SuccessMassage;
			
		}
		public void clickConfirmOrdreButton() {
			confirmOrdre.click();
		}
		
		
	
	}
	
	

