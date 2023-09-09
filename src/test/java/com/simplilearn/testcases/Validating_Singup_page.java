package com.simplilearn.testcases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Validating_Singup_page {
	/* validating the Registration Page
	 * checking existing user trying to create account with same email, then should display error "Email already Registered"
	 * checking password and confirm password are different then it should an error message "error password mismatch"
	 * checking name field is empty, then it should display "error name field is empty"
	*/
	private WebDriver driver;
	
	@BeforeTest
	public void openbrowser() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("http://localhost:9090/FlyAway/home");
		Thread.sleep(2000);
	}
	
	@Test
	public void validating_email() {
		
		driver.findElement(By.linkText("Login/Signup")).click();
		driver.findElement(By.cssSelector("a[href='signup']")).click();
		driver.findElement(By.name("email_id")).sendKeys("surya@gmail.com");
		driver.findElement(By.name("pwd")).sendKeys("surya@123");
		driver.findElement(By.name("pwd2")).sendKeys("surya@123");
		driver.findElement(By.name("name")).sendKeys("surya");
		driver.findElement(By.name("address")).sendKeys("surya nagar");
		driver.findElement(By.name("city")).sendKeys("suryapet");
		driver.findElement(By.tagName("button")).click();
		// Capture a screenshot as a File object
				File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				try {
				    // Define the location where you want to save the screenshot
				    File destination = new File("D:\\Course_work\\Capstone_Projects\\projects\\TestingAirlinesTravelApplication\\Screenshots\\Validating_email.png");
				    // Copy the captured screenshot to the specified location
				    FileUtils.copyFile(screenshotFile, destination);			    
				    System.out.println("Screenshot captured and saved to: " + destination.getAbsolutePath());
				} catch (IOException e) {
				    e.printStackTrace();
				}			
				WebElement bodyele = driver.findElement(By.tagName("body"));
				String body_text  = bodyele.getText();
				String errormsg = "This email id already exists";
				Assert.assertTrue(body_text.contains(errormsg) );	
				System.out.println(errormsg);	
	}
	
	@Test
	public void validating_pwd() {
		
		driver.findElement(By.linkText("Login/Signup")).click();
		driver.findElement(By.cssSelector("a[href='signup']")).click();
		driver.findElement(By.name("email_id")).sendKeys("sr@gmail.com");
		driver.findElement(By.name("pwd")).sendKeys("surya@12");
		driver.findElement(By.name("pwd2")).sendKeys("surya@123");
		driver.findElement(By.name("name")).sendKeys("surya");
		driver.findElement(By.name("address")).sendKeys("surya nagar");
		driver.findElement(By.name("city")).sendKeys("suryapet");
		driver.findElement(By.tagName("button")).click();
		// Capture a screenshot as a File object
				File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				try {
				    // Define the location where you want to save the screenshot
				    File destination = new File("D:\\Course_work\\Capstone_Projects\\projects\\TestingAirlinesTravelApplication\\Screenshots\\Validating_password.png");
				    // Copy the captured screenshot to the specified location
				    FileUtils.copyFile(screenshotFile, destination);			    
				    System.out.println("Screenshot captured and saved to: " + destination.getAbsolutePath());
				} catch (IOException e) {
				    e.printStackTrace();
				}			
				WebElement bodyele = driver.findElement(By.tagName("body"));
				String body_text  = bodyele.getText();
				String errormsg =	"Error , Passwords do not match";
				Assert.assertTrue(body_text.contains(errormsg) );	
				System.out.println(errormsg);
				
	}
	
	@Test
	public void validating_Name() {
		
		driver.findElement(By.linkText("Login/Signup")).click();
		driver.findElement(By.cssSelector("a[href='signup']")).click();
		driver.findElement(By.name("email_id")).sendKeys("sr@gmail.com");
		driver.findElement(By.name("pwd")).sendKeys("surya@123");
		driver.findElement(By.name("pwd2")).sendKeys("surya@123");
		driver.findElement(By.name("name")).sendKeys("");
		driver.findElement(By.name("address")).sendKeys("surya nagar");
		driver.findElement(By.name("city")).sendKeys("suryapet");
		driver.findElement(By.tagName("button")).click();
		// Capture a screenshot as a File object
				File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				try {
				    // Define the location where you want to save the screenshot
				    File destination = new File("D:\\Course_work\\Capstone_Projects\\projects\\TestingAirlinesTravelApplication\\Screenshots\\Validating_Name.png");
				    // Copy the captured screenshot to the specified location
				    FileUtils.copyFile(screenshotFile, destination);			    
				    System.out.println("Screenshot captured and saved to: " + destination.getAbsolutePath());
				} catch (IOException e) {
				    e.printStackTrace();
				}			
				WebElement bodyele = driver.findElement(By.tagName("body"));
				String body_text  = bodyele.getText();
				String errormsg =	"Name is required";
				Assert.assertTrue(body_text.contains(errormsg) );	
				System.out.println(errormsg);
				
	}
	
	@AfterTest
	public void closebrowser() {
		
		driver.close();
		
	}
	
	
}
