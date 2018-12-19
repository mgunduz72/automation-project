package com.cybertek;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Porsche1 {
	WebDriver driver;
	
    @BeforeMethod
   public void setup() {
    	WebDriverManager.chromedriver().setup();
    	driver = new ChromeDriver();
    	driver.navigate().to("https://www.porsche.com/usa/modelstart/");
    	driver.manage().window().fullscreen();
    	
    }
    @AfterMethod
    public void tearDown() {
    	driver.close();
    }

    @Test
    public void selectCar(){
    	driver.findElement(By.xpath("//span[.='718']")).click();
    }
    
    @Test
    public void checkPrice() {
    	String carPrice = driver.findElement(By.xpath("//div[@class=\"m-14-model-price\"][.='From $ 56,900.00*']")).getText();
    	String updated = carPrice.replace("From $ ", "").replace(",", "").replace("*", "");
    	double price = Double.parseDouble(updated);
    }
    
    
}
