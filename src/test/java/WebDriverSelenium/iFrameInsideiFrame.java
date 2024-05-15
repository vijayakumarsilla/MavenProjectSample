package WebDriverSelenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class iFrameInsideiFrame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://ui.vision/demo/webtest/frames/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement frameEle = driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
		driver.switchTo().frame(frameEle);
		driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("vijay silla");
		
		driver.switchTo().frame(0);
		List<WebElement> chkBxs = driver.findElements(By.xpath("//div[@class='uHMk6b fsHoPb']"));
		
		for(WebElement chkBox:chkBxs) {
			chkBox.click();
		}
	}

}
