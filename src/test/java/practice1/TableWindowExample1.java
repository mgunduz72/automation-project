package practice1;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.SortedSet;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TableWindowExample1 extends AlertExtension {
	
	@Test
	  public void switchToWindow() {
	    driver.get("http://the-internet.herokuapp.com/windows");
	    System.out.println(driver.getTitle());
	    
	    driver.findElement(By.xpath("//a[.='Click Here']")).click();
	    
	    String firstWindow = driver.getWindowHandle();
	    System.out.println("current "+"\t" + firstWindow );
	    
	    
	    Set<String> winHandles =  driver.getWindowHandles();
//	    LinkedHashSet<String> winHandles = (LinkedHashSet<String>) driver.getWindowHandles();
	    
	    for(String wind : winHandles) {
	    	System.out.println(wind);
	   // go through the list of all the handles, if we find one that is not
	  // equal to the current, we will switch to it
	    	
	    	if(!firstWindow.equals(wind)) {
	    		driver.switchTo().window(wind);
	    	}
	    
	    }
	    System.out.println(driver.getTitle());
	    


	}
	@Test
	public void switchTest() {
		driver.get("http://the-internet.herokuapp.com/windows");
		driver.fin
		
	}
}
