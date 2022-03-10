package com.Sample.AdvancedConcepts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HyperlinkExample {

public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = DriverFactory.openBrowser("chrome");
		driver.navigate().to("http://www.leafground.com/pages/Link.html");
		
		WebElement homePage = driver.findElement(By.linkText("Go to Home Page"));
		homePage.click();
		driver.navigate().back();
		Thread.sleep(2000);
		
		WebElement link2 = driver.findElement(By.partialLinkText("Find where"));
		System.out.println("Destination for this link: "+link2.getAttribute("href"));
		Thread.sleep(2000);
		
		WebElement brokenLink = driver.findElement(By.linkText("Verify am I broken?"));
		brokenLink.click();
		Thread.sleep(2000);
		String title = driver.getTitle();
		if(title.contains("404"))
			System.out.println("WebPage is broken");
		else
			System.out.println("WebPage is not broken");
		driver.navigate().back();
		
		//System.out.println("Click homepage link using existing element"); //it causes StaleElementReferenceException
		WebElement homePage1 = driver.findElement(By.linkText("Go to Home Page"));
		homePage1.click();
		Thread.sleep(2000);
		
		driver.navigate().to("http://www.leafground.com/pages/Link.html");
		
		List<WebElement> totalLinks = driver.findElements(By.tagName("a"));
		
		System.out.println("Number of hyperlinks: "+totalLinks.size());
		
	}
}
