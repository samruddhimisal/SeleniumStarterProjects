package SeleniumConcepts;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

//import org.apache.commons.io.FilenameUtils;
//import java.lang.Object;

public class UploadFilesUsingSikuli 
{
	WebDriver driver;
	String Browser="chrome";
	@Test
	public void sikuliTest() throws Throwable
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
		driver.get("https://pdf2doc.com/"); //open url
		driver.manage().window().maximize(); //maximize browser window
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//click on upload files button
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/label/span")).click();
		
		//Sikuli to select file from system and upload
		Screen s = new Screen();
		s.type("D:\\Eclipse\\Sikuli\\images\\fileName.PNG","D:\\Eclipse\\EclipseWorkspace\\JavaBasics\\InputFiles\\StarHealthMedicalInsurance.pdf");
		s.click("D:\\Eclipse\\Sikuli\\images\\openButton.PNG");
		
		Thread.sleep(15000);
		//click on download all button
		/*String wId = driver.getWindowHandle();
		driver.switchTo().window(wId);*/
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[3]/button/span[2]"));
		
		//save the converted file
		s.type("D:\\Eclipse\\Sikuli\\images\\downloadFile.PNG", "D:\\Eclipse\\EclipseWorkspace\\SeleniumWebDriver\\SikuliDemoFiles\\pdf2doc.zip");	
		s.click("D:\\Eclipse\\Sikuli\\images\\saveConvertedFile.PNG");
		
		
		
	
	
	
	}
}
