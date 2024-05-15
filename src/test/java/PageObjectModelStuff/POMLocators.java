package PageObjectModelStuff;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class POMLocators 
{
	WebDriver driver;
	
	By cntryLocator = By.xpath("//tr/td/select[@name='country']");
	By cntryOptions = By.xpath("//tr/td/select[@name='country']/option");
	
	POMLocators(WebDriver driver)
	{
		this.driver = driver;
		
	}
	
	public void selectByTextCountry(String countryText)
	{
		String cntryCaptureText;
		WebElement countryList = driver.findElement(cntryLocator);
		Select cntrySelect = new Select(countryList);
		List <WebElement> countryOpts = cntrySelect.getOptions();
		for(WebElement cntryElement:countryOpts)
		{
			cntryCaptureText = cntryElement.getText();
			if (countryText.equals(cntryCaptureText))
			{
				cntryElement.click();
				break;
			}
		}		
	}
	public void selectByTextCountry2(String countryText)
	{
		String captureText;
//		WebElement selectElement = driver.findElement(cntryLocator);
//		Select countrySlect = new Select(selectElement);
		List <WebElement> countryList = driver.findElements(cntryOptions);
		for(WebElement element:countryList)
		{
			captureText = element.getText();
			if (countryText.equals(captureText))
			{
				element.click();
				break;
			}
		}
	}
	public void selectByIndex(int indx)
	{
		List <WebElement> countryList = driver.findElements(cntryOptions);
		countryList.get(indx).click();
	}
	public void selectByTextCountry3(String countryText)
	{
		String captureText;
		List<WebElement> countryElements = driver.findElements(cntryOptions);
		for(int j=0; j<countryElements.size(); j++) 
		{
			captureText = countryElements.get(j).getText();
			if (countryText.equals(captureText))
			{
				countryElements.get(j).click();
				break;
			}
		}
	}
}
