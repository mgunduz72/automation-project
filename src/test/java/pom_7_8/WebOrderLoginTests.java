package pom_7_8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pom_pages_7_8.WebOrdersLoginPage1;

public class WebOrderLoginTests {
	
WebDriver driver;
	
    @BeforeClass
   public void setup() {
    	WebDriverManager.chromedriver().setup();
    	driver = new ChromeDriver();
    	driver.manage().window().fullscreen();
    	

    }
 /*   Step 1) enter userName
      Step 2) enter password
      Step 3) click login
 */

//  @Ignore  
    @Test (enabled=false)        // With old version login using findelement
    public void posiveLoginTest() {
    	driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
    	driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
    	driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
    	driver.findElement(By.id("ctl00_MainContent_login_button")).click();
    	
    }
    @Ignore
    @Test
    public void positiveLoginUsingPOM() {
    	driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
    	//create object from WebOrdersLoginPage class
    	
    	WebOrdersLoginPage1 loginPage = new WebOrdersLoginPage1(driver);
    	loginPage.userName.sendKeys("Tester");
    	loginPage.password.sendKeys("test");
    	loginPage.loginButton.click();
    	
    	
    }
    /*
     * Run a negative test scenario
     * 1- enter invalid 
     * 2- enter valid password
     * 3- click login
     * 4- Verify "Invalid Login or Password." message displayed.
     * 
     * 
     * 
     */
    
    @Test
    public void invalidUserName(){
    	driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
    	//create object from WebOrdersLoginPage class
    	
    	WebOrdersLoginPage1 loginPage = new WebOrdersLoginPage1(driver);
    	loginPage.userName.sendKeys("invalid");
    	loginPage.password.sendKeys("test");
    	loginPage.loginButton.click();
    	String errMsg = loginPage.invalidUserNameErrMsg.getText();
    	
    	Assert.assertEquals(errMsg, "Invalid Login or Password.");
    	
    	System.out.println("Sample");
    }
    
    	
    

}
