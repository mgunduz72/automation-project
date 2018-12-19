package practice1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertPractice extends AlertExtension {
	
	 Alert alert;
	
	@Test
	  public void jsAlertTest() throws InterruptedException {
	    driver.get("http://the-internet.herokuapp.com/javascript_alerts");
	    driver.findElement(By.xpath("//button[1]")).click();
	    alert = driver.switchTo().alert();
	    System.out.println(alert.getText());
	    Thread.sleep(1234);
	    alert.accept();
	    
	    driver.findElement(By.xpath("//button[.='Click for JS Confirm']")).click();
	    alert = driver.switchTo().alert();
	    System.out.println(alert.getText());
	    Thread.sleep(1234);
	    alert.dismiss();
	    
	    driver.findElement(By.xpath("//button[.='Click for JS Prompt']")).click();
	    alert = driver.switchTo().alert();
	    Thread.sleep(2232);
	    alert.sendKeys("asdasf");
	    Thread.sleep(2232);
	    System.out.println(alert.getText());
	    alert.accept();
	    
	    //HOW TO VERIFY ALERT IS PRESENT
	    try {
	    Alert alert1 = driver.switchTo().alert();
	    
	    }catch (NoAlertPresentException e) {
	    	
	    	Assert.fail("No alert present");
	    	
	    }
	    alert.accept();
	}
	
	@Test
	public void htmlPopUps() {
		driver.get("https://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml");
		driver.findElement(By.xpath("//span[.='Destroy the World']")).click();
		
        Assert.assertTrue(driver.findElement(By.xpath("//span[.='No']")).isDisplayed());
		driver.findElement(By.xpath("//span[.='No']")).click();
		
	}
}
