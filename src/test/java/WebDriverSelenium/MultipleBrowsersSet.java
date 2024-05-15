package WebDriverSelenium;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleBrowsersSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.xpath("//input[@id='Wikipedia1_wikipedia-search-input']")).sendKeys("python");
		driver.findElement(By.xpath("//input[@class='wikipedia-search-button']")).click();
		List<WebElement> lnks = driver.findElements(By.xpath("//div[contains(text(),'Search results')]/following-sibling::div//a"));
		for (WebElement lnk:lnks) {
			lnk.click();
		}
		
		Set <String> winIDs = driver.getWindowHandles();
		for(String winID:winIDs) {
			String winTitle = driver.switchTo().window(winID).getTitle();
			if (winTitle.equals("Python syntax and semantics - Wikipedia")) {
				driver.close();
			}
		}
	}

}
