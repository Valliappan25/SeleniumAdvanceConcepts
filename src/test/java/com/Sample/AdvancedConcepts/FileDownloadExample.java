package com.Sample.AdvancedConcepts;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FileDownloadExample {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = DriverFactory.openBrowser("chrome");
		
		driver.get("http://www.leafground.com/");
		
		WebElement fileDownloadElement = driver.findElement(By.xpath("//img[@alt='Download']"));
		
		fileDownloadElement.click();
		
		WebElement downloadLinkElement = driver.findElement(By.linkText("Download Excel"));
		downloadLinkElement.click();
		
		Thread.sleep(2000);
		
		String filePath = "C:\\Users\\Valli\\Downloads\\";
		File file = new File(filePath);
		
		File [] totalFiles = file.listFiles();
		
		for(File fileName : totalFiles)
		{
			if(fileName.getName().equals("testleaf.xlxs"));
			{
				System.out.println(fileName.getName());
				System.out.println("File Downloaded in path");
				break;
			}
		}

	}

}
