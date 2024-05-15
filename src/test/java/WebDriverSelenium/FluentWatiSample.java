package WebDriverSelenium;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
public class FluentWatiSample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.irctc.co.in/nget/train-search");
		
		FluentWait mywait = new FluentWait(driver);
		mywait.withTimeout(Duration.ofSeconds(10));
		mywait.pollingEvery(Duration.ofSeconds(3));
		mywait.ignoring(NoSuchElementException.class);

		driver.manage().window().maximize();
		
		WebElement loginBtn = driver.findElement(By.xpath("//*/a[contains(text(),'LOGIN')]"));
		loginBtn.click();
		
		Object obj = mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*/input[@placeholder='User Name']")));
		WebElement login = (WebElement)obj;
		login.sendKeys("sillavijay");
		
	}

}
