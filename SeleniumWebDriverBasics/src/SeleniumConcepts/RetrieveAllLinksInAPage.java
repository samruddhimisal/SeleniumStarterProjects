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

public class RetrieveAllLinksInAPage 
{
	WebDriver driver;
	String Browser="chrome";
	@Test
	public void retrieveLinksTestCase()
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
		
		driver.get("https://www.opencart.com/"); //open URL
		driver.manage().window().maximize(); //maximize the browser window
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//Retrieve all links -- includes empty links i.e. links with no text/labels
		List<WebElement> li1 = driver.findElements(By.xpath("//a"));
		System.out.println("<---- All Links ----> ");
		for(WebElement x : li1)
		{			
				System.out.println(x.getText());
			
		}
		System.out.println();
		
		//Retrieve labeled links
		List<WebElement> li2 = driver.findElements(By.tagName("//a"));
		System.out.println("<---- Labeled Links ----> ");
		for(WebElement y : li2)
		{
			if(!y.getText().isEmpty())
			{
				System.out.println(y.getText());
			}
		}
		
		driver.quit();
	}
}
