package WebDriverSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PaginationTable {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://datatables.net/examples/basic_init/zero_configuration.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String pagesText = driver.findElement(By.xpath("//div[@id='example_info']")).getText();
		String[] arr = pagesText.split(" ");
		int entries = Integer.parseInt(arr[arr.length-2]);
		System.out.println(entries);
		System.out.println(pagesText);
		
		int noPages = entries/10;
		System.out.println(noPages);
		
		for (int i = 0; i<=noPages; i++) {
			WebElement pageButton = driver.findElement(By.xpath("//button[contains(@class,'dt-paging-button') and @data-dt-idx='"+i+"']"));
			System.out.println(pageButton.getText());
			pageButton.click();
			Thread.sleep(1000);
		}
	}

}
