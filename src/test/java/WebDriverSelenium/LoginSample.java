package WebDriverSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginSample {

	public static void main(String[] args) throws InterruptedException {
		String title1;
		// TODO Auto-generated method stub
		//WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		EdgeDriver driver1 = (EdgeDriver)driver;
		driver1.get("https://www.flipkart.com/");
		driver1.manage().window().maximize();
		Thread.sleep(5000);
		//title1 = driver.findElement(By.xpath("//*/span[@class='_1XjE3T']/span[contains(text(),'Electronics')]")).getText();
		//System.out.println(title1);
		//driver.quit();

	}

}
