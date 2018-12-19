package practice1;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Iframe1 extends AlertExtension {
	
	 @Test 
	  public void iframeTest1() {
	    driver.get("http://the-internet.herokuapp.com/iframe");
	    assertTrue(driver.findElement(By.linkText("Elemental Selenium")).isDisplayed());
	    
	    WebElement fr = driver.findElement(By.tagName("iframe"));
	    driver.switchTo().frame(fr);
	    driver.findElement(By.id("tinymce")).sendKeys("More Text");
	    
	    driver.switchTo().defaultContent();
	    assertTrue(driver.findElement(By.linkText("Elemental Selenium")).isDisplayed());
	    
	 }
	 
	 @Test
	 public void iframeTest2() {
		 driver.get("http://the-internet.herokuapp.com/iframe");
		 assertTrue(driver.findElement(By.linkText("Elemental Selenium")).isDisplayed());
		 
		 driver.switchTo().frame("mce_0_ifr");
		 driver.findElement(By.id("tinymce")).sendKeys(" more text");
		 
		 driver.switchTo().defaultContent();
		 Assert.assertTrue(driver.findElement(By.linkText("Elemental Selenium")).isDisplayed());
		 
		 
	 }
	 @Test
	 public void iframeTest3() {
		 
		 driver.get("http://the-internet.herokuapp.com/iframe");
		 assertTrue(driver.findElement(By.linkText("Elemental Selenium")).isDisplayed());
		 
		driver.switchTo().frame(0);
		driver.findElement(By.id("tinymce")).sendKeys(" more text");
		
		driver.switchTo().parentFrame();
		Assert.assertTrue(driver.findElement(By.linkText("Elemental Selenium")).isDisplayed());
	 }
	 
}
