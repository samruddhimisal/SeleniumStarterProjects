/*To check the number of frames in a page:
	Inpect Element > Ctrl+F > search for 'iframe'*/
package SeleniumConcepts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class JQueryExample 
{
	WebDriver driver;
	String Browser="chrome";
	@Test
	public void jqueryTest()
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
		
		driver.get("https://jqueryui.com/selectable/"); //open url
		driver.manage().window().maximize(); //maximize the browser window
					
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//switch driver reference to frame
		//driver.switchTo().frame("demo-frame"); //search using id or name paramater
		//driver.switchTo().frame(driver.findElement(By.className("demo-frame"))); //use webElement when if id or name not available
		driver.switchTo().frame(0); //to move to a frame using index. 
		
		

		//click on item4 button
		driver.findElement(By.xpath("//*[@id=\"selectable\"]/li[4]")).click();
		
		//switch driver reference to main window
		driver.switchTo().defaultContent();
		
		//click on draggable link
		driver.findElement(By.xpath("//*[@id=\"sidebar\"]/aside[1]/ul/li[1]/a")).click();		
		
		
		/*//Switching between multiple frames
		driver.switchTo().frame(0);
		driver.switchTo().frame(1);
		
		driver.switchTo().frame(0).switchTo().frame(1); //switch to frame1 which is inside frame0
		driver.switchTo().frame(0); //switch back to parent frame - way1
		driver.switchTo().parentFrame() //switch back to parent frame - way2
		
		driver.switchTo().parentFrame().switchTo().parentFrame(); //switch to parent frame in case of 2 nested frames
*/		
				
		driver.quit();
	}
}
