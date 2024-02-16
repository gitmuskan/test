package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;

public class Search extends Base{
	public Search() {
		super();
	}
	
	WebDriver driver;

	@BeforeMethod()
	public void setup() {
		driver = initialiseBrowserAndOpenApp(prop.getProperty("browser"));
		
	}
	@AfterMethod()
	public void teardown() {
		driver.quit();
	}
@Test(priority=1)
public void verifySearchWithValidProduct() {
	driver.findElement(By.name("search")).sendKeys(dataProp.getProperty("validProduct"));
	driver.findElement(By.xpath("//div[@id='search']/descendant::button")).click();
	Assert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed(),"Valid product HP is not displayed in search result");
	
}
@Test(priority=2)
public void verifySearchWithNonExistingProduct() {
	driver.findElement(By.name("search")).sendKeys(dataProp.getProperty("InvalidProduct"));
	driver.findElement(By.xpath("//div[@id='search']/descendant::button")).click();
	String actualSearchMessage = driver.findElement(By.xpath("//div[@id='content']/h2/following-sibling::p")).getText();
	Assert.assertEquals(actualSearchMessage,dataProp.getProperty("NoProductTextInSearch"),"No product in search results");
}
@Test(priority=3)
public void verifyingSearchWithoutProvidingName() {
	driver.findElement(By.name("search")).sendKeys("");
	driver.findElement(By.xpath("//div[@id='search']/descendant::button")).click();
	String actualSearchMessage = driver.findElement(By.xpath("//div[@id='content']/h2/following-sibling::p")).getText();
	Assert.assertEquals(actualSearchMessage,dataProp.getProperty("NoProductTextInSearch"),"No product in search results");
}
}
