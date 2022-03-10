package com.Sample.AdvancedConcepts;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutoCompleteSelect {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = DriverFactory.openBrowser("edge");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.get("http://www.leafground.com/");
		
		WebElement autoCompleteElement = driver.findElement(By.xpath("//img[@alt='Auto Complete']"));
		
		autoCompleteElement.click();
		
		WebElement autoCompleteTextBox = driver.findElement(By.id("tags"));
		autoCompleteTextBox.sendKeys("a");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ui-id-1']/li")));		
		List<WebElement> options = driver.findElements(By.xpath("//*[@id='ui-id-1']/li"));
		
		System.out.println(options.toString());
		
		for (WebElement webElement : options) {
			
			if(webElement.getText().equalsIgnoreCase("rest api"))
			{
				System.out.println("Selected Option: "+webElement.getText());
				webElement.click();
				break;
			}
		}
		
	}
}
