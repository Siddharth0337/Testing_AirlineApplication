package com.simplilearn.TestingAirlinesTravelApplication;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class RegistrationPage {
	
	
	public void register() throws InterruptedException {
	
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	driver.get("http://localhost:9090/FlyAway");
	Thread.sleep(2000);
	driver.findElement(By.linkText("Login/Signup")).click();
	driver.findElement(By.cssSelector("a[href='signup']")).click();
	driver.findElement(By.name("email_id")).sendKeys("srk12@gmail.com");
	driver.findElement(By.name("pwd")).sendKeys("surya@123");
	driver.findElement(By.name("pwd2")).sendKeys("surya@123");
	driver.findElement(By.name("name")).sendKeys("surya");
	driver.findElement(By.name("address")).sendKeys("surya nagar");
	driver.findElement(By.name("city")).sendKeys("suryapet");
	// Capture a screenshot as a File object
		File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

		try {
		    // Define the location where you want to save the screenshot
		    File destination = new File("D:\\Course_work\\Capstone_Projects\\projects\\TestingAirlinesTravelApplication\\Screenshots\\Registration.png");
		    
		    // Copy the captured screenshot to the specified location
		    FileUtils.copyFile(screenshotFile, destination);
		    
		    System.out.println("Screenshot captured and saved to: " + destination.getAbsolutePath());
		} catch (IOException e) {
		    e.printStackTrace();
		}

	driver.findElement(By.tagName("button")).click();
	driver.findElement(By.linkText("Login to continue checking flights")).click();
	driver.quit();
	
	
	}
	
	
}
