package com.tutorialsninja.qa.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSuccessPage {
	public WebDriver driver;
	
	@FindBy (xpath = "//p[normalize-space()='Congratulations! Your new account has been successfully created!']")
	private WebElement accountSuccessCreationMessage;
	
	public AccountSuccessPage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String retieveAccountSuccessMessage() {
		String notificationMessage = accountSuccessCreationMessage.getText();
		return notificationMessage;
		
	}

}
