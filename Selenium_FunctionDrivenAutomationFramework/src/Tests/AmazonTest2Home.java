package Tests;

import org.testng.annotations.Test;

import Utils.amazonUtils;

public class AmazonTest2Home extends amazonUtils
{
	@Test
	public void testcase2() throws Throwable
	{
		//openBrowser();
		
		clickOnDontChange();
		clickOnTodaysDeal();
		selectCheckbox("home");
		clickOnFirstItem();
		clickOnFirstItemInSublist();
		clickOnAdd2Cart();
		verifySucessMsg("home");
		
		//closeBrowser();
				
	}
}
