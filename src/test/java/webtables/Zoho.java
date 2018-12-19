package webtables;

import static org.testng.Assert.assertEquals;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Zoho {
	 String url = "https://forms.zohopublic.com/murodil/report/Applicants/reportperma/DibkrcDh27GWoPQ9krhiTdlSN4_34rKc8ngubKgIMy8";// read
     // web
     // tables
// /html/body/table/tbody/tr[2]/td[4]

public static WebDriver driver;
HashMap<Integer, String> applicantInfoMap;

@BeforeClass // runs once for all tests
public void setUp() {
System.out.println("Setting up WebDriver in BeforeClass...");
WebDriverManager.chromedriver().setup();
driver = new ChromeDriver();
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
// driver.manage().window().fullscreen();
}

@Test
public void readAndStoreAll() {
// go to web page
driver.get(url);
// click on options
driver.findElement(By.xpath("//select[@id='recPerPage']")).click();
// choose 100
driver.findElement(By.xpath("//select[@id='recPerPage']/option[4]")).click();
HashMap<Integer, String> allOfThem = new HashMap<>();
WebElement nextPage = driver.findElement(By.className("nxtArrow"));
// <a class="nxtArrow smallDim" onclick=""></a>
while (nextPage.isEnabled()) {

allOfThem.putAll(readAndStore100());
// go to next page
nextPage.click();
}
// <span id="total">2131</span>
String maxRows = driver.findElement(By.xpath("//span[@id='total']")).getText();
int expectedRows = Integer.parseInt(maxRows);
int actualRows = allOfThem.size();
assertEquals(expectedRows, actualRows);
// System.out.println(allOfThem.size() );
}

public static HashMap<Integer, String> readAndStore100() {

HashMap<Integer, String> applicantInfoMap = new HashMap<>();
int columnCount = driver.findElements(By.xpath("//table[@id='reportTab']/thead/tr/th")).size();
int idKey = 0;
String idStr = null;
String infoEach = "";
String applicantInfo = "";

for (int i = 1; i <= 100; i++) {
for (int j = 1; j < columnCount; j++) {
idStr = driver.findElement(By.xpath("//table[@id='reportTab']/tbody/tr[" + i + "]/td[1]")).getText();
idKey = Integer.parseInt(idStr);

infoEach = driver
.findElement(By.xpath("//table[@id='reportTab']/tbody/tr[" + i + "]" + "/td[" + (j + 1) + "]"))
.getText();

applicantInfo = applicantInfo.concat(infoEach + " ");

}
applicantInfoMap.put(idKey, applicantInfo);
// System.out.println(applicantInfo); just checking
applicantInfo = "";

}
// <a class="nxtArrow" onclick=""></a>

return applicantInfoMap;
}

@AfterClass
public void tearDown() {
driver.quit();
}
}