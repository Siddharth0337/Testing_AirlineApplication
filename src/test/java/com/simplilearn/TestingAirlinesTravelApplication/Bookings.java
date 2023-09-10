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
import io.github.bonigarcia.wdm.WebDriverManager;

public class Bookings {
	
public void flights() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("http://localhost:9090/FlyAway/home");
		Thread.sleep(2000);
		driver.findElement(By.linkText("Login/Signup")).click();
		driver.findElement(By.name("email_id")).sendKeys("surya@gmail.com");
		driver.findElement(By.name("pwd")).sendKeys("surya@123");
		driver.findElement(By.tagName("button")).click();
		driver.findElement(By.linkText("Home")).click();
		Select src = new Select(driver.findElement(By.xpath("//select[@name='source']")));
		src.selectByValue("1");
		Select dstn = new Select(driver.findElement(By.xpath("//select[@name='destination']")));
		dstn.selectByValue("4");
		driver.findElement(By.tagName("button")).click();
		driver.findElement(By.linkText("Book Flight")).click();
		driver.findElement(By.linkText("Click to complete booking")).click();
		driver.findElement(By.linkText("See Your Bookings")).click();
		// Capture a screenshot as a File object
		File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
		    // Define the location where you want to save the screenshot
		    File destination = new File("D:\\Course_work\\Capstone_Projects\\projects\\TestingAirlinesTravelApplication\\Screenshots\\Bookings.png");	    
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
		driver.quit();
	}
		
}
