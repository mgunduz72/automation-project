package practice1;

import java.awt.Desktop.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Action1 {
	

	WebDriver driver;
//	Actions act = new Actions(driver);
	
	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		
	}
	
//	@Test (priority = 1)
//	public void doubleClickTest() {
//		driver.get("https://www.primefaces.org/showcase/ui/misc/effect.xhtml");
//		WebElement slide = driver.findElement(By.xpath("//div[@id='slide_header']/span"));
//		Actions act = new Actions(driver);
//		act.doubleClick(slide).perform();
//	
//	
//	}
	
//    @Test (priority = 2)
//	  public void hoverTest1() throws InterruptedException {
//	    driver.get("http://amazon.com");
//	    Actions act = new Actions(driver);
//	    WebElement move = driver.findElement(By.xpath("//span[.='Back to top']"));
//	    act.moveToElement(move).perform();
//	    Thread.sleep(1000);
//	    move.click();
//	    
//	 }
    
	@Test
	  public void scrollTest() throws InterruptedException {
	    driver.get("http://amazon.com");
	    Actions action = new Actions(driver);
	    action.sendKeys(Keys.PAGE_DOWN).perform();
	    action.sendKeys(Keys.ARROW_LEFT).perform();
    }
	
	 @Test
	  public void dragDropTest1() throws InterruptedException {
	    driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
	    Actions action = new Actions(driver);
	    
	    WebElement drag = driver.findElement(By.id("draggable"));
	    WebElement drop = driver.findElement(By.id("droptarget"));
	    Thread.sleep(1000);
	    action.moveToElement(drag).clickAndHold().moveToElement(drop).release().perform();
	    
	 }
}
	 

