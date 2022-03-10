package com.Sample.AdvancedConcepts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MultiSelectable {

	public static void main(String[] args) {
	
	WebDriver driver = DriverFactory.openBrowser("edge");
	
	driver.get("http://www.leafground.com/");
	
	WebElement selectableElement = driver.findElement(By.xpath("//img[@alt='selectable']"));
	
	selectableElement.click();
	
	List<WebElement> multiSelectElement = driver.findElements(By.xpath("//*[@id='selectable']/li"));
	
	System.out.println(multiSelectElement.size());
	
	/*
	 * Actions action = new Actions(driver);
	 * 
	 * action.keyDown(Keys.CONTROL).click(multiSelectElement.get(0))
	 * .click(multiSelectElement.get(1)) .click(multiSelectElement.get(2))
	 * .build().perform();
	 */
	
	Actions action1 = new Actions(driver);
	action1.clickAndHold(multiSelectElement.get(0));
	action1.clickAndHold(multiSelectElement.get(1));
	action1.clickAndHold(multiSelectElement.get(2));
	action1.build().perform();
	
	}
	
}
