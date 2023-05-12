package practice;

import org.testng.annotations.Test;
@Test
public class SampleClass {
	@Test(invocationCount = 3)
	public void createContact() {
//		int[] arr= {1,2,3};
//		System.out.println(arr[5]);
		System.out.println("Created");
	}
	@Test
	public void modifyContact() {
		System.out.println("modified");
	}
	@Test
	public void deleteContact() {
		System.out.println("deleted");
	}
}
