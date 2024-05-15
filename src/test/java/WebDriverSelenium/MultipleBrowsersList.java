package WebDriverSelenium;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleBrowsersList
{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@id='Wikipedia1_wikipedia-search-input']")).sendKeys("UFT");
		driver.findElement(By.xpath("//input[@class='wikipedia-search-button']")).click();
		List<WebElement> lnks = driver.findElements(By.xpath("//div[contains(text(),'Search results')]/following-sibling::div//a"));
		for (WebElement lnk:lnks) {
			lnk.click();
		}
		
		Set<String> winIDs= driver.getWindowHandles();
		List<String> winIDsList = new ArrayList(winIDs);
		for(int i=0;i<winIDsList.size();i++) {
			String wind = winIDsList.get(i);
			driver.switchTo().window(wind);			
			System.out.println(driver.getTitle());			
		}
		//below code is to handle windows using list of window handles
		/*for(String wind:winIDsList) {
			driver.switchTo().window(wind);			
			System.out.println(driver.getTitle());				
		}
		
		for(int i=0;i<winIDsList.size();i++) {
		String wind = winIDsList.get(i);
		driver.switchTo().window(wind);			
		driver.close();		
		}
		for(String wind:winIDsList) {
			driver.switchTo().window(wind);			
			driver.close();		
		}*/		
	}
}
