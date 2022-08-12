package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoRetry {
	@Test(retryAnalyzer=comcast.vtiger.genericUtility.ReTryImpClass.class)
	
	public void modifyContact() {
		Assert.assertEquals(true, false);
		System.out.println("modified contact");
	}

}
