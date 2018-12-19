package pomtest_7_11;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	
	
WebDriver driver;
	
    @BeforeClass
   public void setupClass() {
    	WebDriverManager.chromedriver().setup();
    	driver = new ChromeDriver();
    	
//      WebDriverManager.firefoxdriver().setup();
//      driver = new FirefoxDriver();
    }
    
    @AfterMethod
    public void tearDown() {
     // driver.quit();
    }
    
  
}