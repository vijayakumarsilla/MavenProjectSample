package WebDriverSelenium;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertwithTextbox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.automationtesting.in/Alerts.html");
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//a[contains(text(),'Alert with Textbox')]")).click();
		driver.findElement(By.xpath("//div[@id='Textbox']//button[@class='btn btn-info']")).click();
		WebDriverWait mywait = new WebDriverWait(driver,Duration.ofSeconds(10));
		//Alert myalert = driver.switchTo().alert();
		Alert myalert = mywait.until(ExpectedConditions.alertIsPresent());
		System.out.println(myalert.getText());
	}

}
