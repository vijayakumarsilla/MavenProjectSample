package TestNGStuff;

import org.testng.Assert;
import org.testng.annotations.*;

public class ParametersXML {
	//@Test(dataProvider="mydp")
	@Test
	@Parameters({"param1"})
	public void summation(int a) {
		int b = 100;
		int sum = a+b;
		System.out.println(sum);
		//Assert.assertTrue(true);
	}
	@Test
	@Parameters({"param1","param2"})
	public void multiply(float a, float b) {
		System.out.println(a*b);
	}
	//@DataProvider(name="mydp")
	public Object[][] values()
	{
		Object mydata[][]= 
			{
					{10,20},
					{111,222},
					{5,6}
			};
		return mydata;
	}
}
