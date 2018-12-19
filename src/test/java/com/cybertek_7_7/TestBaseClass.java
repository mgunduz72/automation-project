package com.cybertek_7_7;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBaseClass{
	
	
	
	
WebDriver driver;
	
    @BeforeMethod
   public void setup() {
    	WebDriverManager.chromedriver().setup();
    	driver = new ChromeDriver();
    	
//      WebDriverManager.firefoxdriver().setup();
//      driver = new FirefoxDriver();
    }
    
    @AfterMethod
    public void tearDown() {
      driver.quit();
    }
    /*
     * @param expected title
     * 
     * will switch to new tab based on expected title
     * will switch back to the original tab, 
     * if the expected title does not exist
     */
    public void switchByTitle(String title) {
      String original = driver.getWindowHandle();
      
      for (String handle : driver.getWindowHandles()) {
        driver.switchTo().window(handle);
        if (driver.getTitle().equals(title)) {
          // do not do anything else and leave the method
          // since we are now in the right window
          return;
        }
      }
      
      driver.switchTo().window(original);
      
    }
    
// GOOD METHOD

//   public static void switchToNewWindowByTitle(WebDriver driver, String title){
//
//    String parentWindow = driver.getWindowHandle(); 
//
//    Set<String> handler= driver.getWindowHandles(); 
//
//    Iterator<String> it= handler.iterator(); 
//
//    boolean founded=false; 
//
//    while(it.hasNext()){
//
//    driver.switchTo().window(it.next());
//   if(driver.getTitle().equals(title)){
//   founded=true; 
//   break; 
//  }
// }
//   if(!founded){
//   driver.switchTo().window(parentWindow); 
// }
//}

 				




 
3 collaborators have joined the document.
   
}