package webtables;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TablePractice {
	
String url = "file:///Users/emin/Desktop/webtable.html";
	
	WebDriver driver;
	@BeforeClass //runs once for all tests
	public void setUp() {
		System.out.println("Setting up WebDriver in BeforeClass...");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().fullscreen();
	}
	
	@Test
	public void readScores() {
		driver.get(url);
		//read the whole table
		WebElement table = driver.findElement(By.tagName("table"));
		System.out.println(table.getText());
		//find out how many rows in the table
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='worldcup']/tbody/tr"));
		System.out.println(rows.size());
		String headerPath = "//table[@id='worldcup']/thead/tr/th";
		List<WebElement> headers = driver.findElements(By.xpath(headerPath));
		for(WebElement each : headers) {
			System.out.println(each.getText());
		}
		List<String> expected = Arrays.asList("Team1","Score","Team2");
		List<String> actual = new ArrayList<>();
		
		for(WebElement h : headers) {
			actual.add(h.getText());
		}
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actual, expected);
		
		////write xpath and findelement gettext -> needs to print Egypt
		
		String eg = driver.findElement(By.xpath("//table[@id='worldcup']/tbody/tr[3]/td[3]")).getText();
		soft.assertEquals(eg, "Egypt");
		
		//loop it and print all data
		//get number of rows, columns then nested loop
		
		int numRows = driver.findElements(By.xpath("//table[@id='worldcup']/tbody/tr")).size();
		int numCol = driver.findElements(By.xpath("//table[@id='worldcup']/thead/tr/th")).size();
		
		for (int row = 1;  row<= numRows; row++) {
			for(int col = 1;col<=numCol;col++) {
				String xpath = "//table[@id='worldcup']/tbody/tr["+row+"]/td["+col+"]";
				String data = driver.findElement(By.xpath(xpath)).getText();
				System.out.print(data +"\t");
			}
			System.out.println();
			
		}
		soft.assertAll();
	}

}
