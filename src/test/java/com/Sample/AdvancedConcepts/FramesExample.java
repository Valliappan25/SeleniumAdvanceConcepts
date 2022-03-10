package com.Sample.AdvancedConcepts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FramesExample {

	public static void main(String[] args) {
		WebDriver driver = DriverFactory.openBrowser("edge");
		
		driver.get("http://www.leafground.com/");
		
		WebElement frameWindow = driver.findElement(By.cssSelector("img[alt='Frame']"));
		frameWindow.click();
		
		driver.switchTo().frame(0);
		
		WebElement firstButton = driver.findElement(By.id("Click"));
		firstButton.click();
		
		System.out.println(firstButton.getText());
		
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame(1);
		driver.switchTo().frame("frame2");
		
		WebElement secondButton = driver.findElement(By.id("Click1"));
		
		secondButton.click();
		
		driver.switchTo().defaultContent();
		
		List<WebElement> numberOfFrames = driver.findElements(By.tagName("iframe"));
		
		System.out.println("Total number of Frames: "+numberOfFrames.size());

	}

}
