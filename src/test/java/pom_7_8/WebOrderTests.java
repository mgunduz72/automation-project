package pom_7_8;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pom_pages_7_8.AllOrdersPage2;
import pom_pages_7_8.ProductsPage3;
import pom_pages_7_8.WebOrdersLoginPage1;

public class WebOrderTests {
	WebDriver driver;
	WebOrdersLoginPage1 loginPage;
	AllOrdersPage2 allOrdersPage;
	ProductsPage3 productsPage;
	String userId = "Tester";
	String password = "test";
	

	
	@BeforeClass
	   public void setup() {
	    	WebDriverManager.chromedriver().setup();
	    	driver = new ChromeDriver();
	    	driver.manage().window().fullscreen();
	 
	    
	}
	
	@BeforeMethod
	public void setUpApplication() {
		driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
		
	}
	@Test(description="Verify labels and tab links are displayed", priority = 1) // We can add notes and add comma the add the priority
	public void labelsVerification() {
		assertEquals(driver.getTitle(),"Web Orders Login","LoginPage is not displayed. Application is down.");
		/*  loginPage.userName.sendKeys(userId);
            loginPage.password.sendKeys(password);
		    loginPage.loginButton.click();
		*/
		loginPage = new WebOrdersLoginPage1(driver);
		loginPage.login(userId, password);
		
		allOrdersPage = new AllOrdersPage2(driver);
		assertTrue(allOrdersPage.webOrders.isDisplayed(),"Web Orders is not displayed");
		assertTrue(allOrdersPage.listOfAllOrders.isDisplayed(),"List Of All Orders label is not displayed");
		assertEquals(allOrdersPage.welcomeMsg.getText().replace(" | Logout", ""),"Welcome, " + userId + "!");
		assertTrue(allOrdersPage.viewAllOrders.isDisplayed(),"viewAllOrders is not displayed");
		assertTrue(allOrdersPage.orderTab.isDisplayed(),"orderTab is not displayed");
	}
	
	/*
	 *  Step 1. Navigate to loginpage
		Step 2. Assert that you are on loginpage
		Step 3. Login using valid credentials
		Step 4. Click on view all products
		Step 5. Verify following products are displayed:
				MyMoney
				FamilyAlbum
				ScreenSaver
		Step 6. Verify prices and discounts :
				MyMoney	    $100 8%
				FamilyAlbum	$80	15%
				ScreenSaver	$20	10%
	 */
	@Test(description="Verify default Products and prices")
	public void availableProductsTest() {
		assertEquals(driver.getTitle(),"Web Orders Login","LoginPage is not displayed. Application is down.");
		loginPage = new WebOrdersLoginPage1(driver);
		loginPage.login(userId, password);
		allOrdersPage = new AllOrdersPage2(driver);
		allOrdersPage.viewAllProducts.click();
		productsPage = new ProductsPage3(driver);
		List<String> expProducts = Arrays.asList("MyMoney","FamilyAlbum","ScreenSaver");
		List<String> actProducts = new ArrayList<>();		
		
//		productsPage.productNames.forEach(
//				elem -> actProducts.add(elem.getText())
//		);
		for(WebElement prod : productsPage.productNames) {
			actProducts.add(prod.getText());
		}
		assertEquals(actProducts,expProducts);
		
		for (WebElement row : productsPage.productsRows) {

			System.out.println(row.getText());
			String[] prodData = row.getText().split(" ");
			switch(prodData[0]) {
				case "MyMoney":
					assertEquals(prodData[1],"$100");
					assertEquals(prodData[2],"8%");
					break;
				case "FamilyAlbum":
					assertEquals(prodData[1],"$80");
					assertEquals(prodData[2],"15%");
					break;
				case "ScreenSaver":
					assertEquals(prodData[1],"$20");
					assertEquals(prodData[2],"10%");
					break;		
			}
			
		}
		
	} 
	
	
	//logout after each test
	@AfterMethod
	public void logout() {
	allOrdersPage.logout();
	}
}
