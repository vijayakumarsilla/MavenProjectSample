package TestNGStuff;

import org.testng.annotations.Test;

public class NewTest {
	
  @Test(priority=1)
  public void abc() 
  {
	  System.out.println("test1");
  }
 
  @Test(priority=3)
  public void def() 
  {
	  System.out.println("test3");
  }
  
  @Test(priority=2)
  public void xyz() 
  {
	  System.out.println("test2");
  }
  
}
