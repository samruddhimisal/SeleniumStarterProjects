package SeleniumConcepts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class WorkWithBrowsers 
{
	WebDriver driver;
	String Browser="edge";
	@Test
	public void WorkWithBrowsers()
	{
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
		//WebDriver driver = new ChromeDriver(); //open chrome browser
		//WebDriver driver = new FirefoxDriver(); //open FF browser
		//WebDriver driver = new EdgeDriver(); //open edge browser
		driver.get("https://www.amazon.com/"); //open URL
		driver.manage().window().maximize(); //maximize the browser window
	}
}
