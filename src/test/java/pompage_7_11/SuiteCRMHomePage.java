package pompage_7_11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SuiteCRMHomePage {
	
	private WebDriver driver;   // We had to create a driver to reach in our below method.  By saying this.driver = driver, the this.driver is
	                           // pointing to the private driver that we had to create, and the other driver is the one in the  parameter. By saying this
	                           // we are passing the driver inside the constructor to our private driver so that we can access the same thing. 
	
	public SuiteCRMHomePage(WebDriver driver) {
		this.driver=driver;                    
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="CREATE")
	public WebElement create;
	
	public void createNewItem(String itemType) {
		Actions action = new Actions(driver);
		action.moveToElement(create).perform();
		driver.findElement(By.linkText(itemType)).click();
	}
}
