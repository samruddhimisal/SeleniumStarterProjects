package SeleniumConcepts;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class MouseActions2 
{
	WebDriver driver;
	String Browser ="edge";
	@Test
	public void mouseActionsTest2() throws Throwable 
	{
		SoftAssert st=new SoftAssert();
		if(Browser.equalsIgnoreCase("chrome"))
			           driver=new ChromeDriver();
		else if (Browser.equalsIgnoreCase("mozilla"))
			           driver=new FirefoxDriver();
		else if(Browser.equalsIgnoreCase("edge"))
			          driver=new EdgeDriver();
		
		driver.get("https://www.drikpanchang.com/"); //open url
		driver.manage().window().maximize(); //maximize browser window
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Mouse hover on panchang
		WebElement panchang = driver.findElement(By.xpath("//*[@id=\"dp-menu\"]/li[3]/a"));		
		Actions action=new Actions(driver);
				
		//right click on Panchang and copy link
		action.contextClick(panchang).build().perform();
		Robot r=new Robot();
		for(int i=1;i<=5;i++)
		{
			r.keyPress(KeyEvent.VK_DOWN);
			//action.sendKeys(Keys.ARROW_DOWN).build().perform();
			Thread.sleep(3000);
		}
		
		r.keyPress(KeyEvent.VK_ENTER);
		
	}
		
}
