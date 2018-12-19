package com.cybertek;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifySearch_6_17_1st {
	public static void main(String[] args) {
		
		  WebDriverManager.chromedriver().setup();
		    WebDriver driver = new ChromeDriver();
		    driver.manage().window().fullscreen();
		    driver.get("http://etsy.com");
		    String searchTerm = "fathers day gifts";
		    
		    WebElement input = driver.findElement(By.id("search-query"));
		    
		    input.sendKeys(searchTerm+Keys.ENTER);// page refreshed/ directed to results page
		    // locate the element again. 
		   
		    input = driver.findElement(By.id("search-query")); //We are on different page now, that's why we do not get exception because all values here are the same 
		                                                    // in above WebElement input
		    // get the text of the element

//		    for normal tags like <h1> or <font> we can use the getText() which will get the text between the openning and closing tags
//		    However with input tags getText does not works the same way
//		    if you want to get the text inside the search box then you use the getAtribute("value") to read the text inside the value atribute of the input tag
		  
		    String actual = input.getAttribute("value");
		    
		    System.out.println(actual);

		    if (actual.equals(searchTerm)) {
		      System.out.println("pass");
		    } else {
		      System.out.println("fail");
		      System.out.println("expected:\t"+searchTerm);
		      System.out.println("found:\t"+actual);
		
		


		
	}

	}
}
