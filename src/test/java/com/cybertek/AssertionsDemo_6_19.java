package com.cybertek;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class AssertionsDemo_6_19 {
	// Assertion is a method that does testing and used to verify data, we have many assert versions such as assert.True, assert.False, assert.Equal etc
	
	@AfterMethod
    public void tearMethod() {
		System.out.println("cleaning up"); // This will always run after each method and does not matter the test or method failed or pass
	}
	
	@Test
	public void testOne() {
		
	//	String a ="Asd";
	//	String b = "ASdfs";
		
		System.out.println("asserting first");
		
		Assert.assertTrue(true);  // We place the logic inside, pass false also to see the test result
//		Assert.assertTrue(false);  // If assertion fails, the rest of the code inside that method will not run. But other methods still will run
		System.out.println("done asserting");
		
		
	}

	 @Test
	  public void testTwo() {
	    System.out.println("asserting second");
	    Assert.assertTrue(false);
	    System.out.println("done asserting second");
	  }
	
	
}
