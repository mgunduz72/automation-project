package com.cybertek;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownDemo_6_17_4th {
	
	// In this class we will work on drop down list. In selenium everthing with the same about other items except drop down list
	// it has special case to handle. Select is used for drop down list in html, and each item in drop down list represent with option in html
//	<select>
//	    <option>Madrid</option>
//	    <option>New york</option>
//	    <option>Munih</option>
//	 </select>
	
	/*
	 * First we need to find the select tag  in html
	 * Then we need to create an object from the select tag
	 */
	
	
	public static void main(String[] args) {
		
		 WebDriverManager.chromedriver().setup();
		    WebDriver driver = new ChromeDriver();
		    driver.manage().window().fullscreen();
		    driver.get("http://tutorialehtml.com/en/html-tutorial-drop-down-lists-menu/");
		    
		    //First we need to find the select tag  in html
		    WebElement selectTag = driver.findElement(By.name("my_html_select_box"));
		    
		    //Then we need to create an object from the select tag
		    
		    Select lst = new Select(selectTag); // To use this, our drop down must have a select tag on html page
		    
		    // Select object has many options to use, we can use lst. to see all available options.
		    
		    WebElement selected = lst.getFirstSelectedOption();// getFirstSelectedOption() --> this will not print the option it will only return the selected element
		   
		    System.out.println(selected.getText()); // then we need to print selected value:Option1 (Whatever on the first option as city)
	        // We can also print it in one line.
		    
		    System.out.println(lst.getFirstSelectedOption().getText());

//		    // To print all the available options(selected or not selected, everything). To do this we use getOptions() method available
//		    
//		 // printing all the available options
//			// In this case we need to use list to get all the list that we have in our WebElement. Then we need to loop through each option 
//
			List<WebElement> options = lst.getOptions();
			System.out.println("______________");
			for (WebElement webElement : options) {
				System.out.println(webElement.getText());
			}

			System.out.println("______________");
			// select using the visible text
			lst.selectByVisibleText("Bucharest");

			System.out.println("selected:\t" + lst.getFirstSelectedOption().getText());
//
//			// select using the index
//			// count starts from 0
			lst.selectByIndex(2);
			System.out.println("selected:\t" + lst.getFirstSelectedOption().getText());
//
//			// select using value
			// list.selectByValue("ASDfasdfsaf");  // We do not have value option n our website, therefore we can not use it here.
//
			System.out.println("***************************");

			Select secondList = new Select(driver.findElement(By.cssSelector("select[multiple='yes']")));
//
			secondList.selectByVisibleText("New York");
			secondList.selectByVisibleText("Madrid");
			secondList.selectByVisibleText("Bucharest");
			List<WebElement> allSelectedOptions = secondList.getAllSelectedOptions();

			for (WebElement webElement : allSelectedOptions) {
		//		System.out.println("***************************");
				System.out.println(webElement.getText());
			}
			System.out.println(allSelectedOptions.size());
			secondList.deselectAll();
			allSelectedOptions = secondList.getAllSelectedOptions();
			System.out.println(allSelectedOptions.size());
		    
	}
}
