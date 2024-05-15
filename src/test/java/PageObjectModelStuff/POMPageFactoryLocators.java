package PageObjectModelStuff;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class POMPageFactoryLocators
{
	WebDriver driver;
	Select selectCountry;
	
	POMPageFactoryLocators(WebDriver driver)	
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//tr/td/select[@name='country']")
	WebElement countryElement;
	
	@FindBy(xpath="//tr/td/select[@name='country']/option")
	List<WebElement> countryOptions;
	
	public void selectByText(String text1)
	{
		selectCountry = new Select(countryElement);
		selectCountry.selectByVisibleText(text1);		
	}
	
	public void selectByValue(String text2)
	{
		selectCountry = new Select(countryElement);
		selectCountry.selectByValue(text2);
	}
	
	public void selectByIndex(int indx)
	{
		countryOptions.get(indx).click();
	}
	
	public void selectByTextandValidate(String text4)
	{
		String captureText;
		for(WebElement element:countryOptions)
		{
			captureText = element.getText();
			if (text4.equals(captureText))
			{
				element.click();
				Assert.assertEquals(text4, captureText);
				break;			
			}
		}
	}
}
