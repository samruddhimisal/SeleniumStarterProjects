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

public class AlertPractice 
{
	WebDriver driver;
	String Browser="chrome";
	Alert alert1,alert2,alert3,alert4; // this doesn't work. why??
	@Test
	public void alertPracticeTest() throws Throwable
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
		
		driver.get("https://demoqa.com/alerts"); //open url
		driver.manage().window().maximize(); //maximize the browser window
					
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Alert 1 - "Click Button to see alert"
		driver.findElement(By.id("alertButton")).click();
		Thread.sleep(3000);
		Alert alert1 = driver.switchTo().alert();
		System.out.println("Alert1 text = "+alert1.getText());
		alert1.accept(); //Ok button
		System.out.println();
		
		//Alert 2 - "On button click, alert will appear after 5 seconds"
		driver.findElement(By.id("timerAlertButton")).click();
		Thread.sleep(5000);
		Alert alert2 = driver.switchTo().alert();
		System.out.println("Alert2 text = "+alert2.getText());
		alert2.accept(); //Ok button
		Thread.sleep(3000);
		System.out.println();
				
		//Alert 3 - "On button click, confirm box will appear"
		driver.findElement(By.id("confirmButton")).click();
		Thread.sleep(3000);
		Alert alert3 = driver.switchTo().alert();
		System.out.println("Alert3 text = "+alert3.getText());
		alert3.accept(); //Ok button
		//Selection Result - OK
		String alert3TextOK = driver.findElement(By.id("confirmResult")).getText();
		sa.assertEquals(alert3TextOK, "You selected Ok");
		System.out.println("OK selected successfully for Alert3.");
		Thread.sleep(3000);
		System.out.println();
		
		//Alert 3(1) - "On button click, confirm box will appear"
		driver.findElement(By.id("confirmButton")).click();
		Thread.sleep(3000);
		Alert alert3_1 = driver.switchTo().alert();
		System.out.println("Alert3(1) text = "+alert3_1.getText());
		alert3.dismiss(); //Cancel button
		//Selection Result - Cancel
		String alert3TextCancel = driver.findElement(By.id("confirmResult")).getText();
		sa.assertEquals(alert3TextCancel, "You selected Cancel");
		System.out.println("Cancel selected successfully for Alert3.");
		Thread.sleep(3000);
		System.out.println();
				
		//Alert 4 - "On button click, prompt box will appear"
		driver.findElement(By.id("promtButton")).click();
		Thread.sleep(3000);
		Alert alert4 = driver.switchTo().alert();
		System.out.println("Alert4 text = "+alert4.getText());
		driver.switchTo().alert().sendKeys("Samruddhi");		
		alert4.accept(); //Ok button
		//Selection Result - OK
		String alert4TextOK = driver.findElement(By.id("promptResult")).getText();
		sa.assertEquals(alert4TextOK, "You entered Samruddhi Misal");
		System.out.println("OK selected successfully for Alert4 and text entered is: "+alert4TextOK);
		Thread.sleep(3000);
		System.out.println();
				
		//Alert 4 - "On button click, prompt box will appear"
		driver.findElement(By.id("promtButton")).click();
		Thread.sleep(3000);
		Alert alert4_1 = driver.switchTo().alert();
		System.out.println("Alert4(1) text = "+alert4_1.getText());
		driver.switchTo().alert().sendKeys("Misal");		
		alert4.dismiss(); //Cancel button		
		
		//CloseBrowser
		driver.quit();
				
	}
}
