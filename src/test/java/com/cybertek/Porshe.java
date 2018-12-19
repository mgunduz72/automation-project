package com.cybertek;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Porshe {
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.get("https://www.porsche.com/usa/modelstart/");
		//driver.findElement(By.cssSelector("a[href='/usa/modelstart/all/?modelrange=718']")).click();;
		driver.findElement(By.xpath("//span[.='718']")).click();
		String carPrice = driver.findElement(By.xpath("//div[@class=\"m-14-model-price\"][.='From $ 56,900.00*']")).getText();

		String updated = carPrice.replace("From $ ", "").replace(",", "").replace("*", "");
		//System.out.println(updated);
		double price = Double.parseDouble(updated);
		System.out.println(price);
		
//		String handle = driver.getWindowHandle();
//		System.out.println(driver.getTitle());
		
		driver.findElement(By.xpath("//span[.='Build & Price']")).click();
		
		for(String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println(driver.getTitle());
		String carPrice1 = driver.findElement(By.xpath("//section[@id=\"s_price\"]//div[@class='ccaPrice'][.='$56,900']")).getText();
		String updated1 = carPrice1.replace("$", "").replace(",", "");
//		System.out.println(updated1);
		
		double price1 = Double.parseDouble(updated1);
		System.out.println(price1);
		
		//Assert.assertTrue(price==price1);
		if(price ==price1) {
			System.out.println("Prices is confirmed");
		}else {
			System.out.println("Price not match");
		}
		String eqPrice = driver.findElement(By.xpath("//section[@id=\"s_price\"]//div[@class=\"ccaPrice\"][.='$0']")).getText();
		String updated2 = eqPrice.replace("$", "");
		double price2 = Double.parseDouble(updated2);
		System.out.println(price2);
		
		String delivery = driver.findElement(By.xpath("//section[@id=\"s_price\"]//div[@class=\"ccaPrice\"][.='$1,050']")).getText();
		String updated3 = delivery.replace("$", "").replace("," , "");
		double price3 = Double.parseDouble(updated3);
		System.out.println(price3);
		
		String total = driver.findElement(By.xpath("//section[@id=\"s_price\"]//div[@class=\"ccaPrice\"][.='$57,950']")).getText();
		String update4 =total.replace("$", "").replace("," , "");
		double price4 = Double.parseDouble(update4);
		System.out.println(price4);
		
		if(price4 == price3+price1) {
			System.out.println("Total price verified!");
		}else {
			System.out.println("Total price didn't match!");
		}
		
		
		driver.findElement(By.xpath("//span[@style=\"background-color: rgb(0, 120, 138);\"]")).click();
		String miami = driver.findElement(By.xpath(" //section[@id=\"s_exterieur\"]//div[@class=\"tt_price tt_cell\"][.='$2,580']")).getText();
		//System.out.println(miami);
		String pr = miami.replace("$", "").replace("," , "");
		double d = Double.parseDouble(pr);
		//System.out.println(d);
		
		String miami1 = driver.findElement(By.xpath("//section[@id=\"s_price\"]//div[@class=\"ccaPrice\"][.='$2,580']")).getText();
		String pr1 = miami1.replace("$", "").replace("," , "");
		double d1 = Double.parseDouble(pr1);
		
		if(d == d1) {
			System.out.println("Miami Blue Price Matched!");
		}else {
			System.out.println("Price not matched!!!");
		}
		
		String total2 = driver.findElement(By.xpath("//section[@id=\"s_price\"]//div[@class=\"ccaPrice\"][.='$60,530']")).getText();
		 //section[@id="s_price"]//div[@class="ccaPrice"][.='$60,530']
		 String pr2 = total2.replace("$", "").replace("," , "");
		 double d2 = Double.parseDouble(pr2);
		 
		 if(d2 == d1+price4) {
			 System.out.println("Total Price Matched!");
			}else {
				System.out.println("Total Price not matched!!!");
			}
	}

}
