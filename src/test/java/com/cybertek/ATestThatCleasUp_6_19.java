package com.cybertek;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

/*
	 * Test Case 1
       Go to amazon
       search for something

       Test Case 2
       Go to Google
       Search for something
	 * 
	 */

public class ATestThatCleasUp_6_19 {
	
	
WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();  // Instead of writing WebDriver each time, we can declare it above 
	}
	
	@Test
	public void searchAmazon() {
//		WebDriverManager.chromedriver().setup();   // Instead of placing this in each method, we can place it in @BeferoTest annotation which will run for all methods
//		WebDriver driver = new ChromeDriver();
		
		driver.get("https://amazon.com");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("fathers day gift"+ Keys.ENTER);
		Assert.assertTrue(driver.getTitle().contains("Amazon.com"));
//		driver.close();  Instead of placing for each method to close the browser, we can add in @AfterMethod annotation which will run after each test case or method
	}
	
	@Test
	public void googleSearch() {
//		WebDriverManager.chromedriver().setup();   // Instead of placing this in each method, we can place it in @BeferoTest annotation which will run for all methods
//		WebDriver driver = new ChromeDriver();
		
		driver.get("https://google.com");
		driver.findElement(By.id("lst-ib")).sendKeys("selenium cookbook"+ Keys.ENTER);
		Assert.assertTrue(driver.getTitle().contains("selenium cookbook"));
		
//		driver.close();  Instead of placing for each method to close the browser, we can add in @AfterMethod annotation which will run after each test case or method
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();       //
	}

}
