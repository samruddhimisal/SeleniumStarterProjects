package Tests;

import org.testng.annotations.Test;

import Utils.amazonUtils;

public class AmazonTest1Computer extends amazonUtils
{
	@Test
	public void testcase1() throws Throwable
	{
		//openBrowser();
		
		clickOnDontChange();
		clickOnTodaysDeal();
		selectCheckbox("computer");
		clickOnFirstItem();
		clickOnFirstItemInSublist();
		clickOnAdd2Cart();
		verifySucessMsg("computer");
		
		//closeBrowser();
				
	}
}
