package WebDriverSelenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaticWebTableSample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		List<WebElement> rowEles = driver.findElements(By.xpath("//table[@name='BookTable']//tr"));
		System.out.println("No of table rows : "+rowEles.size());
		
		List<WebElement> colheadEles = driver.findElements(By.xpath("//table[@name='BookTable']//th"));
		System.out.println("No of columns : "+colheadEles.size());
		int rowsCnt = rowEles.size();
		int colsCnt = colheadEles.size();
		for (int h=1;h<=colsCnt; h++) {
			String headName = driver.findElement(By.xpath("//table[@name='BookTable']//tr[1]//th["+h+"]")).getText();
			System.out.print(headName+"\t");
		}
		System.out.println();
		for (int row=2; row<=rowsCnt; row++) {
			for(int col=1;col<=colsCnt; col++) {
				WebElement tableCell = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+row+"]//td["+col+"]"));
				String cellData = tableCell.getText();
				System.out.print(cellData+"\t");
			}
			System.out.println();
		}
		for(int r=2;r<=rowsCnt;r++) {
			WebElement cell = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[2]"));
			String cellText = cell.getText();
			if (cellText.equals("Amit")) {
				String subjText = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[3]")).getText();
				System.out.println("Amit"+"    "+subjText);
			}
		}
	}

}
