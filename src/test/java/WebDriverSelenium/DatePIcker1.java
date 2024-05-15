package WebDriverSelenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePIcker1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		String expctDay = "21";
		String expctMonth = "March"; 
		int expctYear = 2020;
		
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();
		
		
		WebElement year = driver.findElement(By.xpath("//script[contains(@type,'text/javascript')]/following-sibling::div//span[@class='ui-datepicker-year']"));
		WebElement mnth = driver.findElement(By.xpath("//script[contains(@type,'text/javascript')]/following-sibling::div//span[@class='ui-datepicker-month']"));
		int yrCapture = Integer.parseInt(year.getText());
		
		
		if (expctYear!=yrCapture) {
			if (expctYear > yrCapture) {
				while (true) {
					
					if (expctYear==yrCapture && mnth.getText().equals(expctMonth)) {
						break;
					}						
					driver.findElement(By.xpath("//script[contains(@type,'text/javascript')]/following-sibling::div//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
					mnth = driver.findElement(By.xpath("//script[contains(@type,'text/javascript')]/following-sibling::div//span[@class='ui-datepicker-month']"));
					year = driver.findElement(By.xpath("//script[contains(@type,'text/javascript')]/following-sibling::div//span[@class='ui-datepicker-year']"));
					yrCapture = Integer.parseInt(year.getText());

				}
			} 
			else if (expctYear < yrCapture){
				while(true) {

					if (expctYear==yrCapture && mnth.getText().equals(expctMonth)) {
						break;
					}					
					driver.findElement(By.xpath("//script[contains(@type,'text/javascript')]/following-sibling::div//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
					mnth = driver.findElement(By.xpath("//script[contains(@type,'text/javascript')]/following-sibling::div//span[@class='ui-datepicker-month']"));
					year = driver.findElement(By.xpath("//script[contains(@type,'text/javascript')]/following-sibling::div//span[@class='ui-datepicker-year']"));
					yrCapture = Integer.parseInt(year.getText());					
				}				
				
			}
		}

		List<WebElement> dates = driver.findElements(By.xpath("//script[contains(@type,'text/javascript')]/following::table//tr/td"));
		for (WebElement dt:dates) {
			if (dt.getText().equals(expctDay)) {
				dt.click();
			}
		}
	}

}
