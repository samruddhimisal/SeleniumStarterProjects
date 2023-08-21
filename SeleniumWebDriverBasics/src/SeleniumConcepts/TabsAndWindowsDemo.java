package SeleniumConcepts;

import java.io.File;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TabsAndWindowsDemo 
{
	WebDriver driver;
	String Browser="chrome";
	@Test
	public void tabsAndWindowsTest() throws Throwable
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
	driver.get("https://www.timesjobs.com/"); //open url
	driver.manage().window().maximize(); //maximize browser window
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	//click on jobbuzz
	driver.findElement(By.xpath("//*[@id=\"site\"]/header/div[1]/div/ul[1]/li[2]/a")).click();
	
	Set<String> allIds = driver.getWindowHandles();
	Iterator<String> it = allIds.iterator();
	String mid = it.next();
	String t1 = it.next();
	
	//switch driver reference to window
	driver.switchTo().window(t1);
	
	//Tab window
	driver.findElement(By.id("compamySearchText")).sendKeys("tester");
	
	//close tab window
	driver.close();
	
	//switch to main window
	driver.switchTo().window(mid);
	
	//click on gulfjobs
	driver.findElement(By.xpath("//*[@id=\"site\"]/header/div[1]/div/ul[1]/li[3]/a"));
	
	File f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileHandler.copy(f, new File("Testpic.png"));
	
	driver.quit();
	}
}
