package DataProviderStuff;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderSample {
	
  @Test(dataProvider="myDataProvider")
  public void summation(int a, int b, int c) {
	  System.out.println(a+b+c);
	  Assert.assertTrue(true);
  }
  @DataProvider(name="myDataProvider")
  public Object[][] myTest()
  {
	  Object myData[][] = 
		  {
				  {10,20,11},
				  {11,22,10},
				  {100,300,5}
		  };
	  return myData;
  }  
}
