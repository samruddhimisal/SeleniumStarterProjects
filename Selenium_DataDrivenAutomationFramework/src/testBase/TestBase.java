package testBase;

import java.io.FileReader;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

public class TestBase 
{
	public static Properties prop;
	public static String Browser;
	public  static WebDriver driver;
	public static SoftAssert sa;
	
	@BeforeSuite	
	public static  void openBrowser() throws Throwable
	{
		sa = new SoftAssert();
		prop=new Properties();
		prop.load(new FileReader("src\\PageObjects\\PO.properties"));
		Browser=prop.getProperty("browser");
		if(Browser.equalsIgnoreCase("chrome"))
	           driver=new ChromeDriver();
		else if (Browser.equalsIgnoreCase("mozilla"))
	           driver=new FirefoxDriver();
		else if(Browser.equalsIgnoreCase("edge"))
	          driver=new EdgeDriver();
		driver.get(prop.getProperty("url")); //open url
		driver.manage().window().maximize(); //maximize browser window
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@AfterSuite
	public static void closeBrowser(){
		driver.quit();
	}
}
