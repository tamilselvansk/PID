package com.ivymobility.utility;

public class TestUtil {
	
	public static Object[][] getdata(Reader excel,String testCaseName)  // from the excel sheet with test sheet name = TestcaseName
	{
	
		if(!excel.isSheetExist(testCaseName))  // if sheet with same name "TestCaseName" doesn't exists then this function will return [! false] which is true and therefore go inside the if loop )
					{
						excel=null;  // for memory clean up
						return new Object[1][0];   // and it returns and object array with one row and zero column will return  i.e hypothetical array.
						                            // we are making sure that atleast once the test will execute
					
					}


		// if sheet is existing with name testCaseName
	int rows = excel.getRowCount(testCaseName);  				 // from the testcaseName= TestCaseA sheet 
	int columns = excel.getColumnCount(testCaseName);


	 Object[][] data =new Object[rows-1][columns];
	// extract data from cell
	 for (int rowNum =2;rowNum<= rows;rowNum++)
		{
			for (int ColNum =0;ColNum<= columns-1;ColNum++)
			{
			//System.out.print(excel.getCellData(TestCaseA, ColNum, rowNum)+ "----");
				data[rowNum-2][ColNum]= excel.getCellData(testCaseName, ColNum, rowNum); // columns-3 because last 3 columns will record runmode, results and error due to failure 
		}
			
	}
		
	 return data;


	}	

}
