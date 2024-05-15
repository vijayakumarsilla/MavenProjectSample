package TestNGStuff;


import org.testng.annotations.*;
import org.testng.annotations.Test;

public class BeforeAfterAnnotations {
	
//	@BeforeMethod
//	public void BeforeMethodExe() {
//		System.out.println("before method execution");
//	}
//	@AfterMethod
//	public void AfterMethodExe() {
//		System.out.println("after method execution");
//	}
	
	@BeforeTest
	public void BeforeTestExe() {
		System.out.println("Before any test execution");
	}
	@AfterTest
	public void AfterTestExe() {
		System.out.println("after any test execution");
	}
	@BeforeClass
	public void BeforeClassExe() {
		System.out.println("before execution of class");
	}
	@AfterClass
	public void AfterClassExe() {
		System.out.println("after execution of class");
	}
	
	@Test(priority=1)
	public void test1() {
		System.out.println("testing1 validation");
	}	
	@Test(priority=1)
	public void test2() {
		System.out.println("testing2 valiation");
	}
	@BeforeSuite
	public void beforesuiteexe() {
		System.out.println("before entire suite execution");
	}
	@AfterSuite
	public void aftersuiteexe() {
		System.out.println("after entire suite execution");
	}
}
