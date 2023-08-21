package Tests;

import org.testng.annotations.Test;

import Utils.amazonUtils;

public class AmazonTest3MensWatches extends amazonUtils
{
	@Test
	public void testcase3() throws Throwable
	{
		//openBrowser();
		
		clickOnDontChange();
		clickOnTodaysDeal();
		selectCheckbox("mensWatches");
		clickOnFirstItem();
		clickOnFirstItemInSublist();
		clickOnAdd2Cart();
		verifySucessMsg("mensWatches");
		
		//closeBrowser();
				
	}
}
