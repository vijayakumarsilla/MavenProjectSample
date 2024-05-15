package PageObjectModelStuff;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;

public class POMPageFactoryApproach 
{
	POMPageFactoryLocators pfc;
	WebDriver driver;
	
	@BeforeClass
	@Parameters({"browserType"})
	public void browsersetup(String browser)
	{
		switch(browser)
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
	public void openURL(String urlText)
	{
		driver.get(urlText);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Test(priority=2)
	@Parameters({"Text1","Text2","Text3","Text4"})
	public void selectCountries(String cntrText1, String cntryText2, int cntryIndx, String cntryText3) throws InterruptedException
	{
		pfc = new POMPageFactoryLocators(driver);
		pfc.selectByText(cntrText1);
		Thread.sleep(1000);
		pfc.selectByValue(cntryText2);
		Thread.sleep(1000);
		pfc.selectByIndex(cntryIndx);
		Thread.sleep(1000);
		pfc.selectByTextandValidate(cntryText3);
	}
	
	@Test(priority=3)
	public void closeBrowsers()
	{
		driver.quit();
	}
}
