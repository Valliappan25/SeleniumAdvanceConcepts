package com.Sample.AdvancedConcepts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalenderExample {

	public static void main(String[] args) {
		WebDriver driver = DriverFactory.openBrowser("edge");
		
		driver.get("http://www.leafground.com/pages/Calendar.html");
		
		WebElement calender = driver.findElement(By.id("datepicker"));
		
		calender.click();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Next']")));
		
		WebElement nextElement = driver.findElement(By.xpath("//a[@title='Next']"));
		
		nextElement.click();
		WebElement pickElement = driver.findElement(By.xpath("//a[contains(text(),10)]"));
		pickElement.click();
		
		System.out.println(driver.findElement(By.id("datepicker")).getText());

	}

}
