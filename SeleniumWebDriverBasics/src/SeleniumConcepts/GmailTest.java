package SeleniumConcepts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class GmailTest 
{
	WebDriver driver;
	String Browser ="edge";
	@Test
	public void gmailTestCase() throws Throwable 
	{
		SoftAssert sa=new SoftAssert();
		if(Browser.equalsIgnoreCase("chrome"))
			           driver=new ChromeDriver();
		else if (Browser.equalsIgnoreCase("mozilla"))
			           driver=new FirefoxDriver();
		else if(Browser.equalsIgnoreCase("edge"))
			          driver=new EdgeDriver();
		
		driver.get("https://gmail.com/"); //open url
		driver.manage().window().maximize(); //maximize browser window
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10)); //webDriver wait
		
		//Fluent Wait
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(2));
		
		//enter incorrect email id
		driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys("abjggasd");
		
		driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button/span")).click();
				
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/div/div[1]/div/form/span/section/div/div/div[1]/div/div[2]/div[2]"))));
		String getErrorText = driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/div/div[1]/div/form/span/section/div/div/div[1]/div/div[2]/div[2]/div")).getText();
		System.out.println(getErrorText);
		sa.assertEquals(getErrorText, "Enter a valid email or phone number");		
		System.out.println("Error message displayed");
		
		driver.quit();
	}
}
