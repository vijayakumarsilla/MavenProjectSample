package WebDriverSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class iFramesSample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://ui.vision/demo/webtest/frames/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//WebElement frameEle = driver.findElement(By.xpath("//frame[contains(@src,'html')]"));
		WebElement frameEle1 = driver.findElement(By.xpath("//frame[@src='frame_1.html']"));
		driver.switchTo().frame(frameEle1);
		driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("vijay");
		
		driver.findElement(By.xpath("//frame[@src='frame_2.html']")).sendKeys("frame2");
		
	}

}
