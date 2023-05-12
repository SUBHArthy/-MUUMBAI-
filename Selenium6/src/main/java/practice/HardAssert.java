package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssert {

	@Test
	public void m1() {
		System.out.println("step1");
		System.out.println("step2");
		System.out.println("step3");
		Assert.assertEquals(true,true);
		System.out.println("step4");
		System.out.println("step5");
		System.out.println("step6");
	}
	@Test
	public void m2() {
		String act="Pushpabati";
		String exp="Pushpabati";
		Assert.assertEquals(act, exp);
	}

	@Test
	public void m3() {
		String act="Subharthy";
		String exp="Subharthy";
		Assert.assertEquals(act, exp);
	}
}

