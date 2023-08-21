package SeleniumConcepts;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class WebTableDemo 
{
	WebDriver driver;
	String Browser="chrome";
	@Test
	public void retrieveTableData()
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
		
		driver.get("https://money.rediff.com/gainers"); //open URL -- This is a dynamic web page
		driver.manage().window().maximize(); //maximize the browser window
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//<----------------------------------------------------------------->
		//Fetching WebTable rows
		/*List<WebElement> wt = driver.findElements(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr"));
		System.out.println("Row Count = "+wt.size());
		
		//print table rows
		System.out.println("<---- Printing WebTable Data ----> ");		
		for(WebElement x : wt)
		{			
			System.out.println(x.getText());						
		}*/
		
		//<----------------------------------------------------------------->	
		/*//check if a particular text exists in the table
		List<WebElement> wt1 = driver.findElements(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr/td"));
		System.out.println("Row Count = "+wt.size());
		for(int i=0;i<wt1.size();i++)
		{
			if(wt1.get(i).getText().contains("Creative Eye"))
			{
				System.out.println("Creative Eye exists.");
				break;
			}
		}*/
		
		//<----------------------------------------------------------------->
		//Click on a particular Company link
		List<WebElement> li = driver.findElements(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr/td/a")); //xpath to get all links in the page
		for(int i=0;i<li.size();i++)
		{
			if(li.get(i).getText().equalsIgnoreCase("Creative Eye"))
			{
				System.out.println("Creative Eye exists.");
				li.get(i).click();
				break;
			}
		}
		
	}
}
