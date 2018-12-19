package com.cybertek;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBoxTest_6_17_3rd {
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://the-internet.herokuapp.com/checkboxes");
		
		WebElement firstOne = driver.findElement(By.tagName("input")); // we had 3 input on html and this will take the first one
		// we can also use xpath version of this by finding the correct xpath format
//		WebElement secondOne = driver.findElement(null); // it will compile fine but we can not work with null, thefore null pointerException will be thron at the run time. 
		WebElement secondOne = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));

		System.out.println("first");
		
		System.out.println(firstOne.isSelected());  // isSelected will return true or false, depends on checked or unchecked
		firstOne.click();                           // if it was checked, it will uncheck and return false.
		System.out.println(firstOne.isSelected());

		
		System.out.println("second");
		
		System.out.println(secondOne.isSelected());
		secondOne.click();
		System.out.println(secondOne.isSelected());

		driver.close();
	


		
	}

}
