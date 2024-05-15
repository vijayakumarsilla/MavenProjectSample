package WebDriverSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseEventsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		WebElement desktopMenu = driver.findElement(By.xpath("//a[text()='Desktops']"));
		WebElement macMenu = driver.findElement(By.xpath("//a[starts-with(text(),'Mac (')]"));
		
		Actions act = new Actions(driver);
		act.moveToElement(desktopMenu).moveToElement(macMenu).click().build().perform();
		
	
	}

}
