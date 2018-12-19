package pom_pages_7_8;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage3 {
	
	//add constructor
		public ProductsPage3(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(xpath="//table[@class='ProductsTable']/tbody/tr/td[1]")
		public List<WebElement> productNames;

		@FindBy(xpath="//table[@class='ProductsTable']/tbody/tr")
		public List<WebElement> productsRows;
		
	}
