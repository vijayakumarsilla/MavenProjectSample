package WebDriverSelenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//textarea[@name='q']")).sendKeys("visakhpatnam");
		//div[@class='wM6W7d' and @role='presentation']//span
		List<WebElement> autoLst = driver.findElements(By.xpath("//div[contains(@class,'wM6W7d') and @role='presentation']//span"));
		System.out.println(autoLst.size());
		int cnt = autoLst.size();
		
		for (int i =0; i<cnt; i++) {
			System.out.println(autoLst.get(i).getText());
			String strText = autoLst.get(i).getText();
			if (strText.equals("visakhapatnam pincode")) {
				autoLst.get(i).click();				
			}
		}
	}

}
