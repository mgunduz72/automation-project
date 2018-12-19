package com.cybertek_6_30;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAsserts {
	/*
	 * There are 2 types of Asserts, HARD and SOFT asserts. So far we were using hard asserts, when it fails, it stops the whole
	 * execution in the test but other tests will still continue to execute.Soft assert is actually used in TestNG to cover the VERIFY feature which 
	 * is used for Selenium IDE (related to firefox). Verify is also similar to Soft assert which continue to execute the code, even it fails.
	 * To use softAssert we have to first create the object. It's very important to place notes in each assertion to see which assertion failed at the end of the execution.
	 * At work also, if we send just thestacTrace to developers without notes in assertions, they will confuse.
	 * After Soft assertions used we must add "softAssert.assertAll() to see all soft assertion results with the notes that we placed in each assertions.
	 * WHY USE SOFT ASSERTIONS, sometimes for simple things  like a dot or space character which may not affect funtionality,  we do not want our all codes to fail and 
	 * stop execution using hard assertions.
	 * 
	 * 
	 */
	SoftAssert softAssert = new SoftAssert();
	
	@Test
	public void test1() {
		int i = 100;
		int j = 200;
		
		System.out.println("First Assertion:");
		softAssert.assertEquals(i, j, "I and J is not equals");
		
		System.out.println("Second Assertion:");
		softAssert.assertNotEquals(i, j);
		
		System.out.println("Third Assertion");
		softAssert.assertTrue( i > j , "I is not greater than J");
		
		softAssert.assertAll();
		
	}
	
}

