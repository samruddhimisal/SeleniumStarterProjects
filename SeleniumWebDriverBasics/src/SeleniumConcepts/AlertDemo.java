package SeleniumConcepts;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AlertDemo 
{
	WebDriver driver;
	String Browser="chrome";
	@Test
	public void alertTest() throws Throwable
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
		
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi"); //open url
		driver.manage().window().maximize(); //maximize the browser window
					
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.name("proceed")).click();
		Thread.sleep(3000);
		//Alert
		Alert alert = driver.switchTo().alert();
		System.out.println("Alert text ="+alert.getText());
		alert.accept(); //Ok button
		//alert.dismiss(); //Cancel button
		
		//Enter username
		driver.findElement(By.id("login1")).sendKeys("tester");

		//CloseBrowser
		driver.quit();
				
	}
}
