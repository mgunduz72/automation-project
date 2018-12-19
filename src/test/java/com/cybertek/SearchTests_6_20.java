package com.cybertek;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchTests_6_20 {
	
	WebDriver driver;
	
	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		
	}

	@Test
	public void amazonSearchOne() {
		driver.get("http://amazon.com");
		String str = "Selenium Testing Tools Cookbook";
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(str + Keys.ENTER);
		
		    String xpath = "//h2[@class='a-size-medium s-inline  s-access-title  a-text-normal'][.='Selenium Testing Tools Cookbook']";
		    
		    // isDisplayed  -> returns true of the element we located is displayed on the page
		    
		    Assert.assertTrue(driver.findElement(By.xpath(xpath)).isDisplayed()); //While we are debuging, if we passed from this line to the next line
		    // which means Assert test passed, otherwise it will not pass the next line and throw an exception, in this case we should use try catch
		    driver.close();
		    
	}
}
