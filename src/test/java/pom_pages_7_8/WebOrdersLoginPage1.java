package pom_pages_7_8;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/*
 * Finding element only once, we need to create an object of this class and keep using the same web element again and again
 * Developers can change codes id, names some times, we just need to come to this class and update only those changes. This class used as
 * centralized maintenance of all locators and elements, we can easily add new elements or remove  here,we do not extend this class unless it's really necessary
 * In our action class "WebOrderLoginTests" we can create many tests cases without finding those elements again and again. We can create positive and negative scenarios.
 * 
 * 
 */

public class WebOrdersLoginPage1 {
	
	
	public WebOrdersLoginPage1(WebDriver driver) {   // This is our constructor that will allow to initialiaze all the web elements
		PageFactory.initElements(driver, this);  // driver here will find all elements below, and pageFActory will use driver and  initialize or locate all. for now driver is null.
		
	}
	
	@FindBy(id="ctl00_MainContent_username")  // this is finding the element and assigning to username
	public WebElement userName;
	
	
	@FindBy(id="ctl00_MainContent_password")
	public WebElement password;
	
	
	@FindBy(id="ctl00_MainContent_login_button")
	public WebElement loginButton;
	
	@FindBy(id="ctl00_MainContent_status")
	public WebElement invalidUserNameErrMsg;
	
	public void login(String uid, String pwd) {
		userName.sendKeys(uid);
		password.sendKeys(pwd);
		loginButton.click();
	}

}
