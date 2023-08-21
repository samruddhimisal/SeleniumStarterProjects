package SeleniumConcepts;

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

public class MouseActions 
{
	WebDriver driver;
	String Browser ="edge";
	@Test
	public void mouseActionsTest1() 
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
		action.moveToElement(panchang).build().perform();
		
		//click on Gujarati Panchang
		action.click(driver.findElement(By.xpath("//*[@id=\"dp-menu\"]/li[3]/div[2]/div[2]/a[4]"))).build().perform();
		/*action.click(); // left click 
		action.click(panchang);//left click on panchang
		action.doubleClick(target); //double click
		action.contextClick(target) //right click
		action.clickAndHold(panchang).moveToElement(panchang).release(); //Drag and drop
		action.dragAndDrop(src, target); //Drag and drop
		*/
				
		
	}
		
}
