package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
	WebDriver driver;
	
	public loginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
@FindBy(id="input-email")
private WebElement emailAddressField;

@FindBy(id="input-password")
private WebElement passwordField;

@FindBy(xpath="//input[@class='btn btn-primary']")
private WebElement loginButton;

//actions

public void enterEmailAddress(String emailText) {
	emailAddressField.sendKeys(emailText);
}
public void enterPassword(String passwordText) {
	passwordField.sendKeys(passwordText);
}
public void clickOnLogin() {
	loginButton.click();
}
 

































}
