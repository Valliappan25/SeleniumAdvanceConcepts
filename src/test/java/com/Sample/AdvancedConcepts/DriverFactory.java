package com.Sample.AdvancedConcepts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public static WebDriver openBrowser(String browserType)
	{
		
		//browserType = System.getProperty("browser");
		if(browserType.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().cachePath("Driver").setup();
	        return new ChromeDriver();
		}
		else if(browserType.equalsIgnoreCase("edge"))  {
			WebDriverManager.edgedriver().cachePath("Driver").setup();     
			return new EdgeDriver();
		}
		else {
			WebDriverManager.firefoxdriver().cachePath("Driver").setup();     
			return new FirefoxDriver();
		}
	
	}
}
	
	
