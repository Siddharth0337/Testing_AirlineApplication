package com.simplilearn.TestingAirlinesTravelApplication;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Homepage {
	@Test
	public void homepage() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("http://localhost:9090/FlyAway");
		Thread.sleep(2000);
		
		Select src = new Select(driver.findElement(By.xpath("//select[@name='source']")));
		src.selectByValue("1");
		Select dstn = new Select(driver.findElement(By.xpath("//select[@name='destination']")));
		dstn.selectByValue("4");
		driver.findElement(By.tagName("button")).click();
		// Capture a screenshot as a File object
				File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

				try {
				    // Define the location where you want to save the screenshot
				    File destination = new File("D:\\Course_work\\Capstone_Projects\\Screenshots\\screenshot3.png");
				    
				    // Copy the captured screenshot to the specified location
				    FileUtils.copyFile(screenshotFile, destination);
				    
				    System.out.println("Screenshot captured and saved to: " + destination.getAbsolutePath());
				} catch (IOException e) {
				    e.printStackTrace();
				}
		WebElement table = driver.findElement(By.cssSelector("table[border='1']"));
		List<WebElement> rows = table.findElements(By.xpath(".//tr"));
		for (WebElement row : rows) {
			List<WebElement>cells = row.findElements(By.xpath(".//td"));
			for (WebElement cell : cells) {
					System.out.println(cell.getText());
					}
		}
		
		
	}
	
}
