package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertSample {
	
	@Test
	public void createCustomerTest() {
		System.out.println("Step 1");
		System.out.println("Step 2");
		Assert.assertEquals("A","B");
		System.out.println("Step 3");
		System.out.println("Step 4");
	}
	
	@Test
	public void modifyCustomerTest() {
		System.out.println("====================================");
		System.out.println("Step 1");
		System.out.println("Step 2");
		System.out.println("Step 3");
	}

}
