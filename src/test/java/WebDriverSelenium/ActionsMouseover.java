package WebDriverSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsMouseover {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		Actions act = new Actions(driver);
		WebElement electronicsMenu = driver.findElement(By.xpath("//div[@class='_1wE2Px']"));
		//WebElement comppherpMenu = driver.findElement(By.linkText("Computer Peripherals"));
		//WebElement comppherpMenu1 = driver.findElement(By.xpath("//a[contains(text(),'Computer Peripherals')]"));
		WebElement comppherpMenu1 = driver.findElement(By.xpath("//a[@class='_1BJVlg _11MZbx']"));
		
		
		act.moveToElement(electronicsMenu).build().perform();
		
		
	}

}
