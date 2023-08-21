package SeleniumConcepts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class WorkWithSelectObject 
{
	WebDriver driver;
	String Browser="chrome";
	@Test
	public void selectTestCase()
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
		
		driver.get("https://www.timesjobs.com/candidate/register.html?pageFlow=TJ_HOME"); //open URL
		driver.manage().window().maximize(); //maximize the browser window
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//Selecting value from a drop-down
		WebElement sel = driver.findElement(By.id("curLocation"));
		
		Select s =new Select(sel);
		//s.selectByIndex(7);
		//s.selectByValue("198792");
		s.selectByVisibleText("Chennai");
		
		//driver.findElement(By.id("curLocation")).sendKeys("Delhi");  //workaround to select value from drop-drop. works only 70% of the time
		
		driver.quit();
	}
}
