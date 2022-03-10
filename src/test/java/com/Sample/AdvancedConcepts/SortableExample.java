package com.Sample.AdvancedConcepts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SortableExample {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = DriverFactory.openBrowser("edge");
		
		driver.get("http://www.leafground.com/pages/sortable.html");
		
		List<WebElement> sortable = driver.findElements(By.xpath("//*[@id='sortable']/li"));
		
		WebElement fromElement1 = sortable.get(6);
		
		WebElement toElement1 = sortable.get(0);
		
		Actions action = new Actions(driver);
		
		action.clickAndHold(fromElement1);
		action.moveToElement(toElement1);
		action.release(toElement1);
		action.build().perform();
		
		Thread.sleep(1000);
		
		List<WebElement> sortable1 = driver.findElements(By.xpath("//*[@id='sortable']/li"));
		
		WebElement fromElement = sortable1.get(6);
		WebElement toElement = sortable1.get(1);
		
		action.clickAndHold(fromElement);
		action.moveToElement(toElement);
		action.release(toElement);
		action.build().perform();
		
		List<WebElement> sortable3 = driver.findElements(By.xpath("//*[@id='sortable']/li"));
		
		WebElement fromElement2 = sortable3.get(6);
		WebElement toElement2 = sortable3.get(2);
		
		action.clickAndHold(fromElement2);
		action.moveToElement(toElement2);
		action.release(toElement2);
		action.build().perform();
		
		List<WebElement> sortable4 = driver.findElements(By.xpath("//*[@id='sortable']/li"));
		
		WebElement fromElement3 = sortable4.get(6);
		WebElement toElement3 = sortable4.get(3);
		
		action.clickAndHold(fromElement3);
		action.moveToElement(toElement3);
		action.release(toElement3);
		action.build().perform();
		
		List<WebElement> sortable5 = driver.findElements(By.xpath("//*[@id='sortable']/li"));
		
		WebElement fromElement4 = sortable5.get(6);
		WebElement toElement4 = sortable5.get(4);
		
		action.clickAndHold(fromElement4);
		action.moveToElement(toElement4);
		action.release(toElement4);
		action.build().perform();
		
		List<WebElement> sortable6 = driver.findElements(By.xpath("//*[@id='sortable']/li"));
		
		WebElement fromElement5 = sortable6.get(6);
		WebElement toElement5 = sortable6.get(5);
		
		action.clickAndHold(fromElement5);
		action.moveToElement(toElement5);
		action.release(toElement5);
		action.build().perform();
	}
}
