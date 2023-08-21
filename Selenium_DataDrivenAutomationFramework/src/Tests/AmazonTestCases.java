package Tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utils.amazonUtils;
import xls.ShineXlsReader;

public class AmazonTestCases extends amazonUtils
{
	@Test(dataProvider="getdata")
	public void testCase123(String checkbox) throws Throwable
	{
		
		clickOnDontChange();
		clickOnTodaysDeal();
		selectCheckbox(checkbox);
		clickOnFirstItem();
		clickOnFirstItemInSublist();
		clickOnAdd2Cart();
		verifySucessMsg(checkbox);
	}
	@DataProvider
	public Object[][] getdata(){
		ShineXlsReader xls=new ShineXlsReader("src\\excelFiles\\TestData.xlsx");
		int rowCount = xls.getRowCount("Sheet1");
		int columnCount = xls.getColumnCount("Sheet1");
		Object obj[][]=new Object[rowCount-1][columnCount];
		
		for(int i=2;i<=rowCount;i++){
			for(int j=0;j<columnCount;j++){
				obj[i-2][j]=xls.getCellData("Sheet1", j, i);
			}
		}
		return obj;
	}
}
