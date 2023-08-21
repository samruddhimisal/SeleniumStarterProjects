package SeleniumConcepts;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AjaxAutoSuggestElement 
{
	WebDriver driver;
	String Browser="chrome";
	@Test
	public void retrieveTableData()
	{
		
		SoftAssert sa = new SoftAssert();
		
		if(Browser.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(Browser.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else if(Browser.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
		}
		
		driver.get("https://in.search.yahoo.com/?fr2=inr"); //open URL 
		driver.manage().window().maximize(); //maximize the browser window
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//type a value in text field to search
		driver.findElement(By.name("p")).sendKeys("bang");
		
		//print all suggested items in the auto suggest list		
		List<WebElement> li = driver.findElements(By.xpath("//*[@id=\"sbq-wrap\"]/div/div/div/ul/li/span"));
		for(WebElement x : li)
		{			
			if(x.getText().equalsIgnoreCase("bangkok"))
			{
				x.click();
				break;
			}
		}
	
		driver.quit();
	}
}
