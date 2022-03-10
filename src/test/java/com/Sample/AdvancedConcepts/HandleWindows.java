package com.Sample.AdvancedConcepts;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HandleWindows 
{
	public static void main(String args[]) {
		
		WebDriver driver = DriverFactory.openBrowser("edge");
		
		driver.get("http://www.leafground.com/");
		driver.findElement(By.xpath("//*[@id=\"post-153\"]/div[2]/div/ul/li[11]/a/img")).click();
		
		String oldWindow = driver.getWindowHandle();
		
		WebElement homeElement = driver.findElement(By.id("home"));
		homeElement.click();
		
		Set<String> handleWindows = driver.getWindowHandles();
		
		for(String newWindow : handleWindows)
		{
			driver.switchTo().window(newWindow);
		}
		
		WebElement editButton = driver.findElement(By.xpath("//*[@id=\"post-153\"]/div[2]/div/ul/li[1]/a"));
		editButton.click();
		
		driver.close();
		driver.switchTo().window(oldWindow);
		
		WebElement multipleElement = driver.findElement(By.cssSelector("button[onclick='openWindows()']"));
		multipleElement.click();
		
		int numberOfWindows = driver.getWindowHandles().size();
		
		System.out.println("Number of Windows "+numberOfWindows);
		
		WebElement dontCloseMe = driver.findElement(By.id("color"));
		
		dontCloseMe.click();
		
		Set<String> newWindowHandles = driver.getWindowHandles();
		
		for (String windows : newWindowHandles) {
			if(!windows.equalsIgnoreCase(oldWindow))
			{
				driver.switchTo().window(windows);
				driver.close();
			}
		}
	}
}
