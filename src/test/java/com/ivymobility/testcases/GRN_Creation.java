package com.ivymobility.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ivymobility.pages.GRN_Page;
import com.ivymobility.utility.Base;
import com.ivymobility.utility.TestUtil;

public class GRN_Creation extends Base {
	
	@BeforeClass
	public void dataSetup() throws Exception{
		initialize();
		openBrowser();	
		branchLogin();
		
	}
	@Test(dataProvider="getTestData")
	public void GRN_Creat(String PO, String Warehouse,String SKU,String CaseQty,String PieceQty) throws InterruptedException
	{
		GRN_Page GC=PageFactory.initElements(driver,GRN_Page.class);
		GC.GRN_Creation_Page(PO, Warehouse, SKU , CaseQty ,PieceQty);
		
		
	}
	@DataProvider(name="getTestData")
	public Object[][] getTestData()
	{
		return TestUtil.getdata(dataxls,"GRN_Creation");
			
	}
	
	
	
                      
}
