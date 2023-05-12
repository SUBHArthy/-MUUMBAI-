package practice;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertPractice {

	@Test
	public void assertPractice() {
		
		String act="Suraj";
		String exp="Suraj";
		
		System.out.println("step 1");
		System.out.println("step 2");
		System.out.println("step 3");
		SoftAssert ass=new SoftAssert();
		ass.assertNotEquals(act,exp);
		System.out.println("step 4");
		System.out.println("step 5");
		System.out.println("step 6");
		ass.assertAll();
		
		
	}
}
