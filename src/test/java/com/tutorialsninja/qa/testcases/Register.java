package com.tutorialsninja.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.utils.utilities;

import junit.framework.Assert;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.*;
public class Register  extends Base{
	public Register() {
		super();
	}
	WebDriver driver;

	@BeforeMethod()
	public void setUp () {
		driver =	initialiseBrowserAndOpenApp(prop.getProperty("browser")) ;
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.xpath("//a[@href='https://tutorialsninja.com/demo/index.php?route=account/register']")).click();
	}

	@AfterMethod()
	public void teardown() {
		driver.quit();
	}


	public void verifyRegisterWithManadatoryFields() {

		driver.findElement(By.id("input-firstname")).sendKeys("muskag");
		driver.findElement(By.id("input-lastname")).sendKeys("singla");
		driver.findElement(By.id("input-email")).sendKeys(utilities.generateEmailtimestamp());
		driver.findElement(By.id("input-telephone")).sendKeys("3384433434");
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("Muskan1234");
		driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys("Muskan1234");
		driver.findElement(By.xpath("//input[contains(@type,'checkbox')]")).click();
		driver.findElement(By.xpath("//input[contains(@value,'Continue')]")).click();
		String actualHeaderMessage = driver.findElement(By.xpath("//*[@id=\"content\"]/h1")).getText();
		Assert.assertEquals(actualHeaderMessage, "Your Account Has Been Created!","Account Success page is not displayed");
		driver.quit();
	}


	@Test(priority=1)
	public void verifyingAllFields() {
		driver.findElement(By.id("input-firstname")).sendKeys("muskagas");
		driver.findElement(By.id("input-lastname")).sendKeys("singh");
		driver.findElement(By.id("input-email")).sendKeys(utilities.generateEmailtimestamp());
		driver.findElement(By.id("input-telephone")).sendKeys("3384433434");
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("Muskan1234");
		driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys("Muskan1234");
		String newsletter = "yes";

		// Locate the radio button based on the condition and click on it
		if (newsletter.equals("yes")) {
			WebElement yesRadioButton = driver.findElement(By.xpath("//input[@value='0']"));
			yesRadioButton.click();

		} else if (newsletter.equals("no")) {
			// Alternatively, you can locate by XPath for the female option
			WebElement noRadioButton = driver.findElement(By.xpath("//input[@value='0']"));
			noRadioButton.click();

			driver.findElement(By.name("agree")).click();
			driver.findElement(By.xpath("//input[contains(@value,'Continue')]")).click();
			String actualHeaderMessage = driver.findElement(By.xpath("//*[@id=\"content\"]/h1")).getText();
				Assert.assertEquals(actualHeaderMessage, "Your Account Has Been Created!","Account Success page is not displayed");
		}
		}

		public void verifyingAccountWithExistingEmail() {
			driver.findElement(By.id("input-firstname")).sendKeys("muskagas");
			driver.findElement(By.id("input-lastname")).sendKeys("singh");
			driver.findElement(By.id("input-email")).sendKeys("muskansingla685@gmail.com");
			driver.findElement(By.id("input-telephone")).sendKeys("3384433434");
			driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("Muskan1234");
			driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys("Muskan1234");
			String newsletter = "yes";

			// Locate the radio button based on the condition and click on it
			if (newsletter.equals("yes")) {
				WebElement yesRadioButton = driver.findElement(By.xpath("//input[@value='0']"));
				yesRadioButton.click();

			} else if (newsletter.equals("no")) {
				// Alternatively, you can locate by XPath for the female option
				WebElement noRadioButton = driver.findElement(By.xpath("//input[@value='0']"));
				noRadioButton.click();

				driver.findElement(By.name("agree")).click();
				driver.findElement(By.xpath("//input[contains(@value,'Continue')]")).click();
				String actualHeaderMessage = driver.findElement(By.xpath("//*[@id=\"content\"]/h1")).getText();
					Assert.assertEquals(actualHeaderMessage, "Your Account Has Been Created!","Account Success page is not displayed");
			}
			}
			@Test
			public void verifyingWithoutFillingAllFields() {
				driver.findElement(By.xpath("//input[contains(@value,'Continue')]")).click();
				WebElement firstName =	driver.findElement(By.id("input-firstname"));
				Assert.assertEquals(firstName, "First Name must be between 1 and 32 characters!");
				WebElement lastName = 	driver.findElement(By.id("input-lastname"));
				Assert.assertEquals(lastName, "Last Name must be between 1 and 32 characters!");
				WebElement email = 		driver.findElement(By.id("input-email"));
				Assert.assertEquals(email, "E-Mail Address does not appear to be valid!");
				driver.findElement(By.id("input-telephone"));

				String actualHeaderMessage = driver.findElement(By.xpath("//*[@id=\"content\"]/h1")).getText();
					Assert.assertEquals(actualHeaderMessage, "Your Account Has Been Created!","Account Success page is not displayed");

			}
		}

