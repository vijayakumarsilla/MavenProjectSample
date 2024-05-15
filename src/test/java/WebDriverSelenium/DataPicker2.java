package WebDriverSelenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DataPicker2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'frame-one')]")));
		//frame-one796456169"
		String expctYear = "2000";
		String expctMonth = "September";
		String dt = "29";
		driver.findElement(By.xpath("//input[@id='dob']")).click();
		List<WebElement> months = driver.findElements(By.xpath("//select[@class='ui-datepicker-month']/option"));
		
		WebElement year = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
		
		for(WebElement mnth:months) {
			if (mnth.getText().equals(expctMonth)) {
				mnth.click();
			}
		}
		
		Select yearSlct = new Select(year);
		yearSlct.selectByVisibleText(expctYear);		
		
		List<WebElement> dates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));

		for(int i=0;i<dates.size();i++) {

			if(dates.get(i).getText().equals(dt)) {

				dates.get(i).click();
				break;
			}
		}
		driver.findElement(By.xpath("//button[contains(@class,'ui-datepicker-close')]")).click();
	}

}
