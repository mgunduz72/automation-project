package com.cybertek_7_7;

import static org.testng.Assert.assertEquals;

import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TabsWindowsExample4 extends TestBaseClass{
	 @Test
	  public void switchToWindow() {
	    driver.get("http://the-internet.herokuapp.com/windows");
	    System.out.println(driver.getTitle());

	    driver.findElement(By.linkText("Click Here")).click();

	    // windowsHandle == id provided by selenium for current open tabs
	    // getWindowHandle() == gets the handle, id of the current window
	    String firstWindow = driver.getWindowHandle();

	    System.out.println("current:   " + firstWindow);
	    // driver.getWindowHandles() --> returns handles of all the current tabs

	    Set<String> windowHandles = driver.getWindowHandles();
	    // go through the list of all the handles, if we find one that is not
	    // equal to the current, we will switch to it
	    for (String string : windowHandles) {
	      System.out.println(string);

	      // switchTo().window() --> used to switch to new tab/window
	      if (!firstWindow.equals(string)) {
	        driver.switchTo().window(string);
	      }
	    }

	    System.out.println(driver.getTitle());

	  }

	  @Test
	  public void switchByTitleTest() {
	    driver.get("http://the-internet.herokuapp.com/windows");
	    driver.findElement(By.linkText("Click Here")).click();
	    String expectedTitle = "New Window";
	    
	    switchByTitle(expectedTitle);
	    
	    assertEquals(driver.getTitle(), expectedTitle, "Title did not match");
	  }

	}



