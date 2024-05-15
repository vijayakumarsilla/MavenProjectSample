package PageObjectModelStuff;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

public class CrossBrowserTesting 
{
	WebDriver driver;
	WebElement cntryElement;
	Select country;
	
	@BeforeClass
	@Parameters({"browserType"})
	public void Setup(String browser)	
	{
		switch (browser)
		{
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
		}
				
	}
	
	@Test(priority=2)
	@Parameters({"urlText"})
	public void openURL(String appURL)
	{
		driver.get(appURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Test(priority=3)
	public void findElements()
	{
		cntryElement = driver.findElement(By.xpath("//tr/td/select[@name='country']"));
		country = new Select(cntryElement);
	}
	
	@Test(priority=4)
	@Parameters({"Text1"})
	public void selectByText(String countryText)
	{
		country.selectByVisibleText(countryText);
		String captureText = country.getFirstSelectedOption().getText();
		Assert.assertEquals(countryText, captureText);
	}
	
	@Test(priority=5)
	@Parameters({"Text2"})
	public void selectByValue(String countryValueText)
	{
		country.selectByValue(countryValueText);
		String captureText = country.getFirstSelectedOption().getText();
		Assert.assertEquals(countryValueText, captureText);		
	}
	
	@Test(priority=6)
	@Parameters({"Text3"})
	public void selectByIndex(int countryIndex)
	{
		country.selectByIndex(countryIndex);
		Assert.assertTrue(true);
	}
	
	@AfterClass
	public void closeBrowsers()
	{
		driver.close();
	}
}
