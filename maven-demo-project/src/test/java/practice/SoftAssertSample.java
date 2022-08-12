package practice;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertSample {
	
	@Test
	public void createCustomerTest() {
		System.out.println("Step 1");
		System.out.println("Step 2");
		SoftAssert s=new SoftAssert();
		s.assertEquals("A", "B");
		System.out.println("Step 3");
		s.assertEquals("x", "Y");
		System.out.println("Step 4");
		s.assertAll();
	}
	
	@Test
	public void modifyCustmer() {
		
		System.out.println("===============================");
		System.out.println("Step 1");
		System.out.println("Step 2");
		System.out.println("Step 3");
		System.out.println("Step 4");
		
	}

}
