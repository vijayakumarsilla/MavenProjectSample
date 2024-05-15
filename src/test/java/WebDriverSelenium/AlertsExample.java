package WebDriverSelenium;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class AlertsExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/delete_customer.php");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		
		WebDriverWait mywait = new WebDriverWait(driver,Duration.ofSeconds(10));
		//Alert myAlert = mywait.until(ExpectedConditions.alertIsPresent());
		try {
			Alert myAlert = mywait.until(ExpectedConditions.alertIsPresent());			
			System.out.println(myAlert.getText());
			myAlert.dismiss();
			//myAlert.accept();
		}
		catch (Exception e) {	
			System.out.println("Alert message is not available");
			System.out.println(e.getMessage());
		}
		driver.findElement(By.xpath("//input[@name='cusid']")).sendKeys("12");
	}

}
