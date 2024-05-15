package WebDriverSelenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class DemoAutomationExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://blazedemo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement depCity = driver.findElement(By.xpath("//select[@name='fromPort']"));
		Select depCitySlct = new Select(depCity);
		depCitySlct.selectByValue("Paris");
		
		WebElement destCity = driver.findElement(By.xpath("//select[@name='toPort']"));
		Select destCitySlct = new Select(destCity);
		destCitySlct.selectByVisibleText("London");
		driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
		
		List<WebElement> flightsRows = driver.findElements(By.xpath("//table[@class='table']//tr"));
		List<WebElement> flightsCols = driver.findElements(By.xpath("//table[@class='table']//th"));
		int rowsCnt = flightsRows.size();
		int colsCnt = flightsCols.size();
		//List<WebElement> flightsTable = driver.findElements(By.xpath("//table[@class='table']//tr//td"));
		System.out.println(flightsRows.size());
		System.out.println(flightsCols.size());
		Double[] prices = new Double[rowsCnt]; 
		ArrayList<Double> arr=new ArrayList<>();
		
		
		for(int i=1;i<rowsCnt;i++) {
			String cellvalue = driver.findElement(By.xpath("//table[@class='table']//tr["+i+"]//td[6]")).getText();
			String[] cellfinalArr = cellvalue.split("\\$");
			//System.out.println(cellfinalArr[1]);
			prices[i]= Double.parseDouble(cellfinalArr[1]);
			System.out.println(prices[i]);
			arr.add(Double.parseDouble(cellfinalArr[1]));
			
		}
		Arrays.sort(prices);
		Collections.sort(arr);
		System.out.println(prices[1]);
		System.out.println(arr.get(0));
		System.out.println(Arrays.toString(prices));
		/*for(int r=1; r<rowsCnt; r++) {
			for(int c=1; c<colsCnt; c++) {
				WebElement flightsCell = driver.findElement(By.xpath("//table[@class='table']//tr["+r+"]//td["+c+"]"));
				System.out.println(flightsCell.getText());
			} 
		}*/
		
	}

}
