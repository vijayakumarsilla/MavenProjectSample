package WebDriverSelenium;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class checkBoxesSample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		String url = "https://designsystem.digital.gov/components/checkbox/";
		
		driver.navigate().to(url);
		
		List<WebElement> chkBxs = driver.findElements(By.xpath("//div//label[@class='usa-checkbox__label']"));
		
		
		/*for (int i = 0; i<chkBxs.size(); i++) {
			chkBxs.get(i).click();
		}*/	
		for(WebElement chkBx:chkBxs) {
			if (chkBx.isEnabled()) {
				chkBx.click();
			}
			
		}
	}

}
