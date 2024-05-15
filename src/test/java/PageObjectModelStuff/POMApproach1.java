package PageObjectModelStuff;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;

public class POMApproach1 
{
	WebDriver driver;
	POMLocators p;
	
	@BeforeClass
	@Parameters({"browserType"})
	public void setup(String browser)
	{
		switch (browser)
		{
			case "chrome":
				driver = new ChromeDriver();
				break;
			case "edge":
				driver = new EdgeDriver();
				break;
		}		
	}
	
	@Test(priority=1)
	@Parameters({"urlText"})
	public void openURL(String urlText1)
	{
		driver.get(urlText1);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@Test(priority=2)
	@Parameters({"Text1","Text2","Text3","Text4"})
	public void selectingCountries(String country1, String country2, int cntryIndx, String country3) throws InterruptedException
	{
		p = new POMLocators(driver);
		p.selectByTextCountry(country1);
		Thread.sleep(1000);
		p.selectByTextCountry2(country2);
		Thread.sleep(1000);
		p.selectByIndex(cntryIndx);
		Thread.sleep(1000);
		p.selectByTextCountry3(country3);
		
	}
	
	@AfterClass
	public void closeBrowsers()
	{
		driver.quit();
	}
}
