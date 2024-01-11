package com.tutorialsninja.qa.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	public WebDriver driver;
	
	
	@FindBy(css = "#input-firstname")
	private WebElement firstNameField;
	
	@FindBy(css = "#input-lastname")
	private WebElement lastNameField;
	
	@FindBy(css = "#input-email")
	private WebElement emailField;
	
	@FindBy(css = "#input-telephone")
	private WebElement telephoneField;
	
	@FindBy(css = "#input-password")
	private WebElement passwordField;
	
	@FindBy(css = "#input-confirm")
	private WebElement confirmPasswordFiled;
	
	@FindBy(xpath = "//input[@type='checkbox']")
	private WebElement privacyPolicyCheckBox;
	
	@FindBy(css = ".btn.btn-primary")
	private WebElement continueButton;
	
	@FindBy(css = "input[value='1'][name='newsletter']")
	private WebElement newsletterRadioButton;

	@FindBy(css = ".alert.alert-danger.alert-dismissible")
	private WebElement duplicateEmailWarningMessage;
	
	@FindBy(xpath = "//input[@id = 'input-confirm']/following-sibling::div")
	private WebElement passwordMismatchWarningMessage;
	
	@FindBy(css = ".alert.alert-danger.alert-dismissible")
	private WebElement privacyPolicyWarning;
	
	@FindBy(xpath = "//div[contains(text(),'First Name must be between 1 and 32 characters!')]")
	private WebElement firstNameWarning;
	
	@FindBy(xpath = "//div[contains(text(),'First Name must be between 1 and 32 characters!')]")
	private WebElement lastNameWarning;
	
	@FindBy(xpath = "//div[contains(text(),'E-Mail Address does not appear to be valid!')]")
	private WebElement emailWarning;
	
	@FindBy(xpath = "//div[contains(text(),'Telephone must be between 3 and 32 characters!')]")
	private WebElement telephoneWarning;
	
	@FindBy(xpath = "//div[contains(text(),'Password must be between 4 and 20 characters!')]")
	private WebElement passwordWarning;
	
	
	
	
	public RegisterPage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
		public void  enterFirstName(String firstnametext) {
			firstNameField.sendKeys(firstnametext);	
		
	}
		public void  enterLastName(String lastnametext) {
			lastNameField.sendKeys(lastnametext);
	
		}
		
		public void enterEmail (String emailtext) {
			emailField.sendKeys(emailtext);
			
		}
		public void enterTelephone(String telephonetext) {
			telephoneField.sendKeys(telephonetext);
		}
		public void enterPassword(String passwordText) {
			passwordField.sendKeys(passwordText);
			
		}
		public void enterConfirmPassword(String confirmPasswordtext) {
			confirmPasswordFiled.sendKeys(confirmPasswordtext);
			
		}public void clickOnNewsLetterYesOptionRadioButton() {
			newsletterRadioButton.click();
			
		}
		public void clickOnPrivacyPolicyCheckBox() {
			privacyPolicyCheckBox.click();
		}
		public void clickOnContinueButton() {
			continueButton.click();
		}
		public String retieveDuplicateEmailWarning() {
			String duplicateEmailWarning = duplicateEmailWarningMessage.getText();
			return duplicateEmailWarning;
			
		}
		public String retievePasswordMismatchWarning() {
			String PasswordMismatchWarning = passwordMismatchWarningMessage.getText();
			return PasswordMismatchWarning;
		
		}
		
		public String retievePrivacyPolicyWarning() {
			String PPolicyWarning = privacyPolicyWarning.getText();
			return PPolicyWarning;
		
		}
		
		public String retieveFirstNameWarning() {
			String FNameWarning = firstNameWarning.getText();
			return FNameWarning;
		}
		
		public String retieveLastNameWarning() {
			String LNameWarning = lastNameWarning.getText();
			return LNameWarning;
		}
		
		public String retieveEmailWarning() {
			String EmWarning = emailWarning.getText();
			return EmWarning;
		}
		public String retieveTelephoneWarning() {
			String TWarning = telephoneWarning.getText();
			return TWarning;
		}
		public String retievePsswordWarning() {
			String PwWarning = passwordWarning.getText();
			return PwWarning;
		}
		
	
}
