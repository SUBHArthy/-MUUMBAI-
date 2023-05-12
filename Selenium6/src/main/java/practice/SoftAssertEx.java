package practice;


import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertEx {

	@Test
	public void softAssertEx() {
		System.out.println("step1");
		System.out.println("step2");
		System.out.println("step3");
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(false,false);
		System.out.println("step4");
		System.out.println("step5");
		soft.assertAll();
	}
}
