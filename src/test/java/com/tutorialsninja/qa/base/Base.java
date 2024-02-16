package com.tutorialsninja.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import javax.swing.text.Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.tutorialsninja.utils.utilities;

public class Base  {
	WebDriver driver;
	public Properties prop;
	public Properties dataProp;
	public  Base() {
		 prop = new Properties();
		File propFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsninja\\qa\\config\\config.properties");
		FileInputStream fis;
		
		dataProp = new Properties();
		File dataPropFile = new File (System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsninja\\qa\\testdata\\testdata.properties");
		try{
			FileInputStream datafis= new FileInputStream(dataPropFile);
		
		dataProp.load(datafis);
		}
		catch(Throwable e) {
			e.printStackTrace();
		}
		try {
			fis = new FileInputStream(propFile);
			prop.load(fis);
		} catch (Throwable e) {
			
			e.printStackTrace();
		}
		
	}
public WebDriver initialiseBrowserAndOpenApp(String browser) {
	
	
	if(browser.equalsIgnoreCase("chrome"))
	{
		driver = new ChromeDriver();
	}
	else if (browser.equalsIgnoreCase("edge")) {
		driver = new EdgeDriver();
	}
	else if (browser.equalsIgnoreCase("firefox")) {
		driver = new FirefoxDriver();
	}
	else if (browser.equalsIgnoreCase("safari")) {
		driver = new SafariDriver();
	}
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(utilities.IMPLICIT_WAIT_TIME));
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(utilities.PAGE_WAIT_TIME ));
	driver.get(prop.getProperty("url"));
	return driver;
}
}
