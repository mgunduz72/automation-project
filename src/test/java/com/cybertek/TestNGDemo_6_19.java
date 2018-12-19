package com.cybertek;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGDemo_6_19 {
	
	@BeforeClass
	public void setUpClass(){  // It runs only once before everything
		System.out.println("Runs before everything in this class"); 
	}
	
	@BeforeMethod
	public void setUpMethod(){
		System.out.println("Runs before every method");  // It will run as many time as need before depends on the number of the method, 
		                                                // it does not have to be at the first line
		
	}
	
	
	  @Test
	  public void testOne() {
	    System.out.println("First one");
	  }
	  
	  @Test
	  public void testSecond() {           // We can rigth click on the method name and run the TestNG test selectively, which means we test method only
		                                   // Or we can uncomment the first   // @Test and this time also will run only second one. Or instead of @Test 
		                                   // we can also write @Ignore, then we need to import annotation also for @Ignore
	    System.out.println("Second one");
	  }

    @AfterMethod
    public void tearDownMethod() {      // This method will always execute, regardlessly our test is failed or passed after each method. This method is for clean up, like if we search
    	                                // something on amazon, it will be saved somewhere and we would like to clean it up. It's also used for reporting.
	    System.out.println("Runs after every method");
	  }
    
    @AfterClass
	public void tearDownClass(){  // It runs only once after everything in this class
		System.out.println("Runs once after everything in this class"); 
		
		// NOTE : If we do not have @Test annotation in a class nothing will run, for other methods or annotation  to run. We need to have at least one, uncomment them and try. 
	    // For the annotations that runs only once, if we have 2 of them
    }
    
}
