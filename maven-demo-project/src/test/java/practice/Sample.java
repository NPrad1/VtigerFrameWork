package practice;

import org.testng.annotations.Test;

public class Sample {
	@Test(priority=1)
	public void createContact() {
		System.out.println("Contact Created");
	}
	@Test(priority=2)
	public void modifyContact() {
		System.out.println("Modify Contact");
	}
	@Test(priority=3)
	public void deleteContact() {
		System.out.println("Delete Contact");
	}
}
