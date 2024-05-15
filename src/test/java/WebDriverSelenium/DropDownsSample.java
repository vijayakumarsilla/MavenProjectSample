package WebDriverSelenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class DropDownsSample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.flipkart.com/audio-video/pr?sid=0pm&otracker=categorytree&fm=neo%2Fmerchandising&iid=M_6e092ca9-6d77-4840-93cb-6358a96bd2c1_1_372UD5BXDFYS_MC.9JGNW7M0TUHD&otracker=hp_rich_navigation_1_1.navigationCard.RICH_NAVIGATION_Electronics~Audio~All_9JGNW7M0TUHD&otracker1=hp_rich_navigation_PINNED_neo%2Fmerchandising_NA_NAV_EXPANDABLE_navigationCard_cc_1_L2_view-all&cid=9JGNW7M0TUHD");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//section[6]//div[@class='_2gmUFU _3V8rao']")).click();
		List<WebElement> drpDwnOpts = driver.findElements(By.xpath("//section[6]//div//label[@class='_2iDkf8 t0pPfW']"));
		
		System.out.println(drpDwnOpts.size());
		
		for(int i=0;i<drpDwnOpts.size();i++) {
			System.out.println(drpDwnOpts.get(i).getText());			
		}
		drpDwnOpts.get(0).click();
		
	}

}
