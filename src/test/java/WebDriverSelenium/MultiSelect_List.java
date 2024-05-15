package WebDriverSelenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MultiSelect_List {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/select-menu");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement lst = driver.findElement(By.xpath("//select[@id='cars']"));
		Select mulSelct = new Select(lst);
		
		System.out.println(mulSelct.isMultiple());
		mulSelct.selectByIndex(0);
		mulSelct.selectByValue("saab");
		
		List<WebElement> opts1 = mulSelct.getAllSelectedOptions();
		for(WebElement op:opts1) {
			System.out.println(op.getText());
		}
		
		System.out.println(mulSelct.getFirstSelectedOption().getText());
		mulSelct.deselectAll();
		int cnt = mulSelct.getOptions().size();
		List<WebElement> slcLstOpt = mulSelct.getOptions();
		for(int i = 0; i<cnt; i++) {
			slcLstOpt.get(i).click();
		}
		
		mulSelct.deselectAll();
		for(WebElement opt:slcLstOpt) {
			opt.click();
		}
	}

}
