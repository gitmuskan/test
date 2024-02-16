package com.tutorialsninja.qa.testcases;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.AccountPage;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.loginPage;
import com.tutorialsninja.utils.utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
public class login extends Base {
	public login() {
		super();
	}
	WebDriver driver;

	@BeforeMethod
	public void setup() {
		
	driver =	initialiseBrowserAndOpenApp(prop.getProperty("browser")) ;
	HomePage homePage = new HomePage(driver);
	homePage.clickOnAccount();
	homePage.clickOnLogin();
	//driver.findElement(By.xpath("//span[text()='My Account']")).click();
//	driver.findElement(By.linkText("Login")).click();
	}
	
	@AfterMethod
	public void teardown() {
	
	driver.quit();
	}
@Test(priority=1)
public void verifyLoginWithValidCred(String email,String passowrd) {
	loginPage lgnPage = new loginPage(driver);
	lgnPage.enterEmailAddress(email);
	lgnPage.enterPassword(passowrd);
	lgnPage.clickOnLogin();
		//driver.findElement(By.id("input-email")).sendKeys(utilities.generateEmailtimestamp());
//	driver.findElement(By.id("input-password")).sendKeys("Muskan");
//	driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
	
	AccountPage accountPage  = new AccountPage(driver);
	Assert.assertTrue(accountPage.getDisplayStatusOfStatusOfEditYourInformation());
	//String actualText  = "Edit your account information";
		//	String expectedText = "Edit your account information";
		//	Assert.assertTrue(actualText.equals(expectedText));
			
	
	
}
@Test(priority=2)
public void verifyLoginWithInValidCred() {
	
	driver.findElement(By.id("input-email")).sendKeys(utilities.generateEmailtimestamp());
	driver.findElement(By.id("input-password")).sendKeys(dataProp.getProperty("invalid password"));
	driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
String actualMessage = 	driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
String expectedMessage = dataProp.getProperty("emailPasswordNoMatchWarning");
	Assert.assertTrue(actualMessage.contains(expectedMessage));
	
}

}
