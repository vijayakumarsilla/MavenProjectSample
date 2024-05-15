package AssertionsStuff;

import org.testng.annotations.*;

public class HardSoftAssertion_part2 {
	@Test
	public void sample() {
		System.out.println("test step1 - test method1");
	}
	@BeforeClass
	public void sample2() {
		System.out.println("pre requisite of test case - before class");
	}
	@AfterClass()
	public void sample3() {
		System.out.println("closing activities of test case - after class");
	}
	
}
