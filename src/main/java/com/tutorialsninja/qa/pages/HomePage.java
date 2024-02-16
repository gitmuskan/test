package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
WebDriver driver;
@FindBy(xpath ="//span[text()='My Account']")
private	WebElement myAccountDropMenu;

@FindBy(linkText= "Login")
private WebElement loginOption;

//actions

public void clickOnAccount() {
	myAccountDropMenu.click();
}

public void clickOnLogin() {
	loginOption.click();
}







}
