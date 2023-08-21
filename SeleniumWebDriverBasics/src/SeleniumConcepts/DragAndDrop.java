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

public class DragAndDrop 
{
	WebDriver driver;
	String Browser ="chrome";
	@Test
	public void DragAndDropTest() 
	{
		SoftAssert sa=new SoftAssert();
		if(Browser.equalsIgnoreCase("chrome"))
			           driver=new ChromeDriver();
		else if (Browser.equalsIgnoreCase("mozilla"))
			           driver=new FirefoxDriver();
		else if(Browser.equalsIgnoreCase("edge"))
			          driver=new EdgeDriver();
		
		driver.get("https://jqueryui.com/droppable/"); //open url
		driver.manage().window().maximize(); //maximize browser window
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//switch driver ref to frame
		driver.switchTo().frame(0);
		
		//drag and drop
		WebElement src = driver.findElement(By.id("draggable"));
		WebElement tar = driver.findElement(By.id("droppable"));
		Actions action=new Actions(driver);
		
		//action.clickAndHold(src).moveToElement(tar).release().build().perform();
		action.dragAndDrop(src, tar).build().perform();
		
		String droppedText = driver.findElement(By.xpath("//*[@id=\"droppable\"]/p")).getText();
		sa.assertEquals(droppedText, "Dropped!");
		System.out.println("Element dropped successfully.");
		
		
	}
}
