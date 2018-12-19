package com.porsche;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PorscheCheckoutTNG {
	WebDriver driver;

	int modelStartPrice;
	int basePrice;
	int eqPrice;
	int dphPrice;
	int totalPrice;
	int miamiBluePrice;
	int eqMiamiPrice;
	int total1Price;
	int wheelsPrice;
	int eqMiamiWheelsPrice;
	int total2Price;
	int powerSeatsPrice;
	int eqMiamiWheelsSeatsPrice;
	int total3Price;
	int carbonPrice;
	int eqMiamiWheelsSeatsCarbonPrice;
	int total4Price;
	int speed7Price;
	int brakesPrice;
	int eqMiamiWheelsSeatsCarbon7BrakesPrice;
	int total5Price;

	
	public String getTextfromXpath(String a) {

		String b = driver.findElement(By.xpath(a)).getText();
		return b;
	}

	public int getIntFromText(String a) {
		int b = Integer.parseInt(a.replaceAll("\\D+", ""));

		return b;

	}

	
	@BeforeClass // runs once for all tests
	public void setUp() {
		// 1.open browser
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().fullscreen();

		// 2. go to url “https://www.porsche.com/usa/modelstart/”
		String url = "https://porsche.com/usa/modelstart/";
		driver.get(url);
		// 3.Select model 718
		driver.findElement(By.xpath("//div[@class='b-teaser-preview-wrapper']/img[@title='Porsche - 718']")).click();
		// 4.Remember the price of 718Cayman
		String a = "//div[@id='m982120']/div/div/div[@class='m-14-model-price']";
		String start = getTextfromXpath(a);
		String modelStart = start.replace(".00*", "");
		modelStartPrice = getIntFromText(modelStart);

		// 5.Click on Build & Price under 718Cayman
		driver.findElement(By.xpath("//div[@id='m982120']/div[2]/div/a/span")).click();

		String parentWindowHandler = driver.getWindowHandle();
		String subWindowHandler = null;

		Set<String> handles = driver.getWindowHandles();
		Iterator<String> iterator = handles.iterator();
		while (iterator.hasNext()) {
			subWindowHandler = iterator.next();
		}

		driver.switchTo().window(subWindowHandler);

		/// 6.Verify that Base price displayed on the page is same as the price from
		/// step 4
		String b = "//section[@id='s_price']//div[@class='ccaPrice'][.='$56,900']";
		String base = getTextfromXpath(b);
		basePrice = getIntFromText(base);

		/// 7.Verify that Price for Equipment is 0
		String c = "//section[@id='s_price']/div//div[@class='ccaPrice'][.='$0']";
		String eq = getTextfromXpath(c);
		eqPrice = getIntFromText(eq);

		/// 8.Verify that total price is the sum of base price + Delivery, Processing
		/// and Handling Fee
		String d = "//section[@id='s_price']/div//div[@class='ccaPrice'][.='$1,050']";
		String dph = getTextfromXpath(d);
		dphPrice = getIntFromText(dph);

		String e = "//section[@id='s_price']/div//div[@class='ccaRow priceTotal highlighted']/div[@class='ccaPrice']";
		String total = getTextfromXpath(e);
		totalPrice = getIntFromText(total);

		// 9.Select color “Miami Blue”

		driver.findElement(By.xpath("//li[@id='s_exterieur_x_FJ5']/span")).click();
		String f = "//div[@class='tt_price tt_cell'][.='$2,580']";
		String miamiBlue = getTextfromXpath(f);
		miamiBluePrice = getIntFromText(miamiBlue);

		// 10.Verify that Price for Equipment is Equal to Miami Blue price

		String g = "//section[@id='s_price']/div//div[@class='ccaPrice'][.='$2,580']";
		String eqMiami = getTextfromXpath(g);
		eqMiamiPrice = getIntFromText(miamiBlue);

		// 11.Verify that total price is the sum of base price + Price for Equipment +
		// Delivery, Processing and Handling Fee
		String h = "//section[@id='s_price']/div//div[@class='ccaPrice'][.='$60,530']";
		String total1 = getTextfromXpath(h);
		total1Price = getIntFromText(total1);

		// 12.Select 20" Carrera Sport Wheels

		driver.findElement(By.xpath("//li[@id='s_exterieur_x_MXRD']//span[@class='img-element']")).click();

		String i = "//div[@id='s_exterieur_x_IRA']//div[@class='tt_price tt_cell']";
		String wheels = getTextfromXpath(i);
		wheelsPrice = getIntFromText(wheels);

		// 13.Verify that Price for Equipment is the sum of Miami Blue price + 20"
		// Carrera Sport Wheels

		String j = "//section[@id='s_price']/div//div[@class='ccaPrice'][.='$6,330']";
		String eqMiamiwheels = getTextfromXpath(j);
		eqMiamiWheelsPrice = getIntFromText(eqMiamiwheels);

		// 14.Verify that total price is the sum of base price + Price for Equipment +
		// Delivery, Processing and Handling Fee
		String k = "//section[@id='s_price']/div//div[@class='ccaPrice'][.='$64,280']";
		String total2 = getTextfromXpath(k);
		total2Price = getIntFromText(total2);

		// 15.Select seats ‘Power Sport Seats (14-way) with Memory Package

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,1000)", "");

		driver.findElement(By.xpath("//span[@id='s_interieur_x_PP06']")).click();

		String l = "//div[@class='pBox']/div[.='$2,330']";
		String powerSeats = getTextfromXpath(l);
		powerSeatsPrice = getIntFromText(powerSeats);

		// 16.Verify that Price for Equipment is the sum of Miami Blue price + 20"
		// Carrera Sport Wheels + Power Sport Seats (14-way) with Memory Package
		String m = "//section[@id='s_price']/div//div[@class='ccaPrice'][.='$8,660']";
		String eqMiamiWheelsSeats = getTextfromXpath(m);
		eqMiamiWheelsSeatsPrice = getIntFromText(eqMiamiWheelsSeats);

		// 17.Verify that total price is the sum of base price + Price for Equipment +
		// Delivery, Processing and Handling Fee

		String n = "//section[@id='s_price']/div//div[@class='ccaPrice'][.='$66,610']";
		String total3 = getTextfromXpath(n);
		total3Price = getIntFromText(total3);

		// 18.Click on Interior Carbon Fiber
		jse.executeScript("window.scrollBy(0,1000)", "");

		driver.findElement(By.xpath("//div[@id='IIC_subHdl']")).click();
		// 19.Select Interior Trim in Carbon Fiber i.c.w. Standard Interior
		driver.findElement(By.xpath("//span[@id='vs_table_IIC_x_PEKH_x_c01_PEKH']")).click();

		String o = "//div[@id='vs_table_IIC_x_PEKH']//div[@class='pBox']/div[.='$1,540']";
		String carbon = getTextfromXpath(o);
		carbonPrice = getIntFromText(carbon);

		// 20.Verify that Price for Equipment is the sum of Miami Blue price + 20"
		// Carrera Sport Wheels + Power Sport Seats (14-way) with Memory Package +
		// Interior Trim in Carbon Fiber i.c.w. Standard Interior
		String p = "//section[@id='s_price']/div//div[@class='ccaPrice'][.='$10,200']";
		String eqMiamiWheelsSeatsCarbon = getTextfromXpath(p);
		eqMiamiWheelsSeatsCarbonPrice = getIntFromText(eqMiamiWheelsSeatsCarbon);

		// 21.Verify that total price is the sum of base price + Price for Equipment +
		// Delivery, Processing and Handling Fee
		String q = "//section[@id='s_price']/div//div[@class='ccaPrice'][.='$68,150']";
		String total4 = getTextfromXpath(q);
		total4Price = getIntFromText(total4);

		// 22.Click on Performance
		driver.findElement(By.xpath("//div[@id='IMG_subHdl']")).click();

		// 23.Select 7-speed Porsche Doppelkupplung (PDK)
		driver.findElement(By.xpath("//span[@id='vs_table_IMG_x_M250_x_c11_M250']")).click();

		String r = "//div[@id='vs_table_IMG_x_M250']//div[@class='pBox']/div";
		String speed7 = getTextfromXpath(r);
		speed7Price = getIntFromText(speed7);

		// 24.Select Porsche Ceramic Composite Brakes (PCCB)
		jse.executeScript("window.scrollBy(0,500)", "");

		driver.findElement(By.xpath("//span[@id='vs_table_IMG_x_M450_x_c91_M450']")).click();

		String s = "//div[@id='vs_table_IMG_x_M450']/div/div[@class='pBox']/div";
		String brakes = getTextfromXpath(s);
		brakesPrice = getIntFromText(brakes);

		// 25.Verify that Price for Equipment is the sum of Miami Blue price + 20"
		// Carrera Sport Wheels + Power Sport Seats (14-way) with Memory Package +
		// Interior Trim in Carbon Fiber i.c.w. Standard Interior + 7-speed Porsche
		// Doppelkupplung (PDK) + Porsche Ceramic Composite Brakes (PCCB)
		String t = "//section[@id='s_price']/div//div[@class='ccaPrice'][.='$20,820']";
		String eqMiamiWheelsSeatsCarbon7Brakes = getTextfromXpath(t);
		eqMiamiWheelsSeatsCarbon7BrakesPrice = getIntFromText(eqMiamiWheelsSeatsCarbon7Brakes);

		// 26.Verify that total price is the sum of base price + Price for Equipment +
		// Delivery, Processing and Handling Fee
		String u = "//section[@id='s_price']/div//div[@class='ccaPrice'][.='$78,770']";
		String total5 = getTextfromXpath(u);
		total5Price = getIntFromText(total5);
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void basePriceTest() {
		int actual = modelStartPrice;
		int expected = basePrice;
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void equipmentPrice0Test() {
		int actual = 0;
		int expected = eqPrice;
		Assert.assertEquals(actual, expected);

	}

	@Test
	public void totalPriceStep8Test() {
		int expected = (basePrice + dphPrice);
		int actual = totalPrice;
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void equipmentMiamiPriceTest() {
		int expected = miamiBluePrice;
		int actual = eqMiamiPrice;
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void totalPriceStep11Test() {
		int expected = basePrice + eqMiamiPrice + dphPrice;
		int actual = total1Price;
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void equipmentMiamiWheelsPriceTest() {
		int expected = miamiBluePrice + wheelsPrice;
		int actual = eqMiamiWheelsPrice;
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void totalPriceStep14Test() {
		int expected = basePrice + eqMiamiWheelsPrice + dphPrice;
		int actual = total2Price;
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void equipmentMiamiWheelsSeatPriceTest() {
		int expected = miamiBluePrice + wheelsPrice + powerSeatsPrice;
		int actual = eqMiamiWheelsSeatsPrice;
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void totalPriceStep17Test() {
		int expected = basePrice + eqMiamiWheelsSeatsPrice + dphPrice;
		int actual = total3Price;
		Assert.assertEquals(actual, expected);

	}

	@Test
	public void equipmentMiamiWheelsSeatCarbonPriceTest() {
		int expected = miamiBluePrice + wheelsPrice + powerSeatsPrice + carbonPrice;
		int actual = eqMiamiWheelsSeatsCarbonPrice;
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void totalPriceStep21Test() {
		int expected = basePrice + eqMiamiWheelsSeatsCarbonPrice + dphPrice;
		int actual = total4Price;
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void equipmentMiamiWheelsSeatCarbonPrice7speedBrakesTest() {
		int expected = miamiBluePrice + wheelsPrice + powerSeatsPrice + carbonPrice + speed7Price + brakesPrice;
		int actual = eqMiamiWheelsSeatsCarbon7BrakesPrice;
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void totalPriceStep26Test() {
		int expected = basePrice + eqMiamiWheelsSeatsCarbon7BrakesPrice + dphPrice;
		int actual = total5Price;
		Assert.assertEquals(actual, expected);
	}

}