package WebDriverSelenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NonSelectDropDown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@id='justAnInputBox']")).click();
		String strXpath = "//input[@id='justAnInputBox']/ancestor::div[1]/following-sibling::div//ul//li[@class=('ComboTreeItemChlid' or 'ComboTreeItemParent')]/span/input[@type='checkbox']";
		List<WebElement> dpdwnOpts = driver.findElements(By.xpath(strXpath));
		//input[@fdprocessedid='8ixy8b']/ancestor::div[1]/ul//li[@class=('ComboTreeItemChlid' or 'ComboTreeItemParent')]/span/input[@type='checkbox']
		
		System.out.println(dpdwnOpts.size());
		int cnt = dpdwnOpts.size();
		/*for(int i = 0; i<cnt; i++) {
			dpdwnOpts.get(i).click();
		}	*/
		for(WebElement opt:dpdwnOpts) {
			opt.click();
		}
		for(WebElement opt:dpdwnOpts) {
			opt.click();
		}
	}

}
