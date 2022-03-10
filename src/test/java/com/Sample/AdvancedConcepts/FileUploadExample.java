package com.Sample.AdvancedConcepts;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class FileUploadExample {

public static void main(String[] args) throws InterruptedException, AWTException {
		
		WebDriver driver = DriverFactory.openBrowser("chrome");
		
		driver.get("http://www.leafground.com/");
		
		Actions action = new Actions(driver);
		
		WebElement fileUploadElement = driver.findElement(By.xpath("//img[@alt='contextClick']"));
		fileUploadElement.click();
		
		Thread.sleep(3000);
		
		WebElement uploadButton = driver.findElement(By.cssSelector("input[name='filename']"));
		action.moveToElement(uploadButton).click().build().perform();
		
		Thread.sleep(3000);
		
		String path = "C:\\Users\\Valli\\Downloads\\testleaf.pdf";
		StringSelection selection = new StringSelection(path);
		
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
		Thread.sleep(3000);
		Robot robot = new Robot();
		
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		System.out.println("File Uploaded from this path: "+path);
		
	}
}
