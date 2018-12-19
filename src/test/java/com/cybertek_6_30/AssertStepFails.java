package com.cybertek_6_30;

import org.testng.Assert;
import org.testng.annotations.Test;

/*
 * Assertions below we used are hard assertion, if one of them failed it will stop the whole execution at that point in the test
 * but even we have a failed assertion in one test, other test will still continue to execute. 											```````
 * 
 * 
 * 
 */

public class AssertStepFails {
	@Test
	public void test1() {
	  int n = 10;
	  int k = 5;

	  Assert.assertEquals(n,k);
	  System.out.println("next step in Test1");
	  Assert.assertTrue(n>k);  
	}

	@Test
	public void test2() {
	  int n = 10;
	  int k = 5;

	  Assert.assertNotEquals(n,k);
	  System.out.println("next step in Test2");
	  Assert.assertTrue(n>k);  
	}
}
