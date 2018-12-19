package com.cybertek;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorsExamples_6_17_2nd {
	public static void main(String[] args) {
		
		 WebDriverManager.chromedriver().setup();
		    WebDriver driver = new ChromeDriver();
		    driver.manage().window().fullscreen();
		    driver.get("http://etsy.com");
		   
		    
		    WebElement input = driver.findElement(By.id("search-query"));
		    System.out.println(input.getAttribute("outerHTML"));
		    
		
	}

}
