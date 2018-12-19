package webtables;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HomeWork {
	WebDriver driver;
	
	@BeforeClass
	public void setupClass() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().fullscreen();
		driver.navigate().to("https://forms.zohopublic.com/murodil/report/Applicants/reportperma/DibkrcDh27GWoPQ9krhiTdlSN4_34rKc8ngubKgIMy8");
		

	}
	@Test
	public void applicationData() throws InterruptedException {
		Map<Integer, String> app = new HashMap<>();
		Select select = new Select(driver.findElement(By.xpath("//select[@id='recPerPage']")));
		Thread.sleep(1234);
		select.selectByIndex(3);
		Thread.sleep(1234);
	    WebElement table = driver.findElement(By.tagName("table"));
	    Thread.sleep(1234);
	   System.out.println(table.getText());
	   List<WebElement> lst = driver.findElements(by)
	   
			   
			   ////tr[contains(@id,'_tr')]//td[2]
	    
		
	}
	

}
