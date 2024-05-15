package TestNGStuff;

import org.testng.annotations.*;

public class secondExample {
	
	@Test(priority=10)
	public void login() {
		System.out.println("application logged in");
	}
	
	@Test(priority=20)
	public void test() {
		System.out.println("test validation completed");
	}

	@Test(priority=25)
	public void closeapp() {
		System.out.println("application closed");
	}
	@BeforeMethod
	public void BeforeAnyMethod() {
		System.out.println("before every method exe");
	}
	@AfterMethod
	public void AfterAnyMethod() {
		System.out.println("after every method exe");
	}
//	@BeforeSuite
//	public void BeforeSuiteExe() {
//		System.out.println("before entire suite exe");
//	}
//	@AfterSuite
//	public void AfterSuiteExe() {
//		System.out.println("after entire suite exe");
//	}
}
