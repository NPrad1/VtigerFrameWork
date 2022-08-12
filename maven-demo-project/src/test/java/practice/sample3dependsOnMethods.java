package practice;

import org.testng.annotations.Test;

public class sample3dependsOnMethods {
	@Test
	public void createContact() {
		System.out.println("Contact created ");
		int[] arr= {1,3,4};
		System.out.println(arr[4]);
	}
	@Test(dependsOnMethods="createContact")
	public void ModifyContact() {
		System.out.println("Contact Modified");
	}
	@Test(dependsOnMethods="ModifyContact")
	public void DeleteContact() {
		System.out.println("Contact deleted");
	}
}
