package SeleniumConcepts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class NavigateBackForwardRefresh 
{
	WebDriver driver;
	String Browser ="edge";
	@Test
	public void BackForwardAndRefreshTest() throws Throwable 
	{
		SoftAssert st=new SoftAssert();
		if(Browser.equalsIgnoreCase("chrome"))
			           driver=new ChromeDriver();
		else if (Browser.equalsIgnoreCase("mozilla"))
			           driver=new FirefoxDriver();
		else if(Browser.equalsIgnoreCase("edge"))
			          driver=new EdgeDriver();
		driver.get("https://www.opencart.com/"); //open url
		driver.manage().window().maximize(); //maximize browser window
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		System.out.println("Home page Title = "+driver.getTitle());
		//click on login
		driver.findElement(By.linkText("LOGIN")).click(); //login page
		Thread.sleep(4000);
		System.out.println("Page Title after clicking login button= "+driver.getTitle());
		//navigate back to homepage
		driver.navigate().back(); //home page
		Thread.sleep(4000);
		driver.navigate().forward(); //Login page
		Thread.sleep(4000);
		driver.findElement(By.id("input-email")).sendKeys("tester");
		Thread.sleep(4000);
		//driver.navigate().refresh();
		driver.get(driver.getCurrentUrl());
		
		//Navigate to another website
		driver.navigate().to("https://www.amazon.com/");
		//driver.manage().deleteAllCookies();
		
		//navigate back to opencart.com
		driver.navigate().back();
		
		
		//Tool tip msg
		String tooltipmsg = driver.findElement(By.xpath("/html/body/header/nav/div/div[1]/a/img")).getAttribute("title");
		System.out.println("Tool tip msg ="+tooltipmsg);		
		
		driver.quit();
}
}
