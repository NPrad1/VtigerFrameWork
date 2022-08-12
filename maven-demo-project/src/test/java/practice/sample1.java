package practice;

import org.testng.annotations.Test;

public class sample1 {
	@Test (priority=-1)
	public void createContact() {
		System.out.println("contact created");
	}
	@Test(priority=-4)
	public void modifyContact() {
		System.out.println("Contact modified");
	}
	
	@Test
	public void deleteContact() {
		System.out.println("Delete Contact");
	}
}
