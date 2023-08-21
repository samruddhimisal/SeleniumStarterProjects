package Utils;

import org.openqa.selenium.By;

import testBase.TestBase;

public class amazonUtils extends TestBase
{
	public static void clickOnDontChange(){
		try
		{			
			driver.findElement(By.xpath(prop.getProperty("dontChange"))).click();
		}
		catch(Throwable t)
		{
			
		}
	}
	
	public static void clickOnTodaysDeal(){
		driver.findElement(By.xpath(prop.getProperty("todaysDeal"))).click();
	}
	
	public static void selectCheckbox(String checkbox){
				driver.findElement(By.xpath(prop.getProperty(checkbox))).click();
	}
	
	public static void clickOnFirstItem(){
		driver.findElement(By.xpath(prop.getProperty("firstItemInItemsPage"))).click();
	}
	
	public static void clickOnFirstItemInSublist() throws Throwable
	{
		try
		{
		driver.findElement(By.xpath(prop.getProperty("firstItemInItemsSublist"))).click();
		}
		catch(Throwable t)
		{
			driver.findElement(By.xpath(prop.getProperty("firstItemInHomeSublist"))).click();
		}
	}
	
	public static void clickOnAdd2Cart(){
		driver.findElement(By.xpath(prop.getProperty("add2cart"))).click();
	}
	
	public static void verifySucessMsg(String selectedItem){
		try{
			String text = driver.findElement(By.xpath(prop.getProperty("successMsg_main"))).getText();
			System.out.println("Actual text = "+text+", Expected text = Added to Cart");
			sa.assertEquals(text, "Added to Cart");
			System.out.println(selectedItem + " item added to cart successfully.");
			}
		catch(Throwable t )
			{
				String text = driver.findElement(By.xpath(prop.getProperty("successMsg_slide"))).getText();				
				System.out.println("Actual text = "+text+", Expected text = Added to Cart");
				sa.assertEquals(text, "Added to Cart");
				System.out.println(selectedItem + " item added to cart successfully.");
				driver.navigate().refresh();
			}
		
		sa.assertAll();
	}
}
