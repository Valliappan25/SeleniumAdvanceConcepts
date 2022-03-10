package com.Sample.AdvancedConcepts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DynamicTablesExample {

	public static void main(String[] args) {
		WebDriver driver = DriverFactory.openBrowser("edge");
		
		driver.get("http://www.leafground.com/pages/table.html");
		
		List<WebElement> tableRows = driver.findElements(By.tagName("tr"));
		
		System.out.println("Number of Rows "+tableRows.size());
		
		List<WebElement> tableCloumns = driver.findElements(By.tagName("th"));
		
		System.out.println("Number of Columns "+tableCloumns.size());
		
		WebElement getPercentage = driver.findElement(By.xpath("//td[normalize-space()='Learn to interact with Elements']//following::td[1]"));
		System.out.println(getPercentage.getText());
		
		List<WebElement> valueElement = driver.findElements(By.xpath("//td[2]"));
		
		List<Integer> numberList = new ArrayList<Integer>();
		
		for(WebElement element : valueElement)
		{
			String percentageValue = element.getText().replace("%", "");
			
			numberList.add(Integer.parseInt(percentageValue));
		}
		
		System.out.println(numberList);
		
		int smallValue = Collections.min(numberList);
		System.out.println(smallValue);
		
		String finalXpath = "//td[normalize-space()='"+Integer.toString(smallValue)+"%']//following::td[1]/input";
		
		System.out.println(finalXpath);
		driver.findElement(By.xpath(finalXpath)).click();
	}
}
