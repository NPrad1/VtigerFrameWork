package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
	
	@Test(dataProvider="dataProvider_test")
	
	public void bookTicket(String src,String dst) {
		System.out.println("Book tickets from "+src+" to "+dst);
	}
	@DataProvider
public Object[][]dataProvider_test(){
	Object[][] objarr=new Object[5][2];
	
	objarr[0][0]="Banglore";
	objarr[0][1]="Delhi";
	objarr[1][0]="Banglore";
	objarr[1][1]="goa";
	objarr[2][0]="Banglore";
	objarr[2][1]="goa";
	objarr[3][0]="Banglore";
	objarr[3][1]="goa";
	objarr[4][0]="Banglore";
	objarr[4][1]="mumbai";
	return objarr;
	
}
}
