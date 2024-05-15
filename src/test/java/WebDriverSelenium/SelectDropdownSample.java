package WebDriverSelenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropdownSample {

	public static void main(String[] args) throws InterruptedException {
		int cnt;
		
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/newtours/register.php");
		WebElement droDwn = driver.findElement(By.xpath("//tr/td/select[@name='country']"));  //this element should be select only
		Select cntrySlct = new Select(droDwn);
		
		System.out.println(cntrySlct.getOptions().size());
		
		cntrySlct.selectByVisibleText("INDIA");
		Thread.sleep(1000);
		cntrySlct.selectByValue("BAKER ISLAND");
		Thread.sleep(1000);
		cntrySlct.selectByIndex(10);
		System.out.println("Multiple or not : "+cntrySlct.isMultiple());
		System.out.println("type of selected options "+cntrySlct.getAllSelectedOptions().getClass());
			
		List <WebElement> opts = cntrySlct.getOptions();
		cnt = opts.size();
		for (int i=0;i<cnt;i++) {
			if (opts.get(i).getText().equals("UGANDA")) {
				opts.get(i).click();
			}
		}
		
		for(WebElement opt:opts) {
			if (opt.getText().equals("ZIMBABWE")) {
				opt.click();
			}			
		}
		droDwn.sendKeys("INDIA");
	}
}
