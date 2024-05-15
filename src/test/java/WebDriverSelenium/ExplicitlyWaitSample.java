package WebDriverSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitlyWaitSample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		WebDriverWait mywait = new WebDriverWait(driver,Duration.ofSeconds(20));
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement loginBtn = driver.findElement(By.xpath("//*/a[contains(text(),'LOGIN')]"));
		loginBtn.click();
		
		WebElement login = mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*/input[@placeholder='User Name']")));
		login.sendKeys("sillavijay");
		
	}

}
