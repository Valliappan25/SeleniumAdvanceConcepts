package com.Sample.AdvancedConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DragandDrop {

	public static void main(String[] args) {
		WebDriver driver = DriverFactory.openBrowser("edge");
		
		driver.get("http://www.leafground.com/");
		
		WebElement dragAndDropElement = driver.findElement(By.cssSelector("img[alt='drop']"));
		dragAndDropElement.click();
		
		WebElement fromElement = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement toElement = driver.findElement(By.xpath("//div[@id='droppable']"));
		
		Actions action = new Actions(driver);
		
		//action.clickAndHold(fromElement).moveToElement(toElement).release().build().perform();
		action.dragAndDrop(fromElement, toElement).build().perform();
		
		
	}
}
