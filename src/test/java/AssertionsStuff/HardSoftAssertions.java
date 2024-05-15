package AssertionsStuff;

import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class HardSoftAssertions {
	public String str1,str2;
	SoftAssert sa;
	
	@Test
	public void Test1() {
		Assert.assertTrue(1>2);	
		System.out.println("Assert True - Test1 - After assertion statement");
	}
	@Test
	public void Test2() {
		Assert.assertFalse(1>2);
		System.out.println("Assert False - Test2 - After assertion statement");
	}
	@Test
	public void Test3() {
		str1 = "vijay";
		str2 = "kumar";
		Assert.assertNotEquals(str1, str2);
		System.out.println("Assert Not equals - Test3 - After assertion statement");
	}
	@Test
	public void Test4() {
		str1 = "vijay";
		str2 = "VIJAY";
		Assert.assertEquals(str1, str2);
		System.out.println("Assert equals - Test4 - After assertion statement");
	}
	@Test
	public void softAssertSample() {
		sa = new SoftAssert();
		str1 = "Google";
		str2 = "Gooooogle";
		String str3 = "GOOGLE";
		sa.assertTrue(str1.contains(str2));
		System.out.println("statements after soft true assertion continuous.....");
		sa.assertEquals(str1.toLowerCase(), str3.toLowerCase());
		System.out.println("statements after assert equal continuous.....");
		sa.assertAll();  // if this statement is not included though this TC is fail but it will show as PASS hence we must include
	}
}
