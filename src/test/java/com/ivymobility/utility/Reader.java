package com.ivymobility.utility;

import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;

public class Reader {

	public static HSSFWorkbook workbook = null;
	public static HSSFSheet sheet = null;
	public static HSSFRow row = null;
	public static HSSFCell cell = null;
	public String Path = null;

	public Reader(String Path) {
		this.Path = Path;
		try {
			FileInputStream ip = new FileInputStream(Path);
			workbook = new HSSFWorkbook(ip);
			sheet = workbook.getSheetAt(0);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public int getRowCount(String Sheetname) {
		int index = workbook.getSheetIndex(Sheetname);
		if (index == -1)
			return 0;
		else {
			sheet = workbook.getSheetAt(index);
			int number = sheet.getLastRowNum() + 1;

			return number;
		}

	}

	public boolean isSheetExist(String sheetName) {
		int index = workbook.getSheetIndex(sheetName);
		if (index == -1) {
			index = workbook.getSheetIndex(sheetName.toUpperCase());
			if (index == -1)
				return false;
			else
				return true;
		} else
			return true;
	}

	public int getColumnCount(String sheetName) {
		// check if sheet exists
		if (!isSheetExist(sheetName))
			return -1;

		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(0);

		if (row == null)
			return -1;

		return row.getLastCellNum();

	}

	public String getCellData(String sheetName, int colNum, int rowNum) {
		try {
			if (rowNum <= 0)
				return "";

			int index = workbook.getSheetIndex(sheetName);

			if (index == -1)
				return "";

			sheet = workbook.getSheetAt(index);
			row = sheet.getRow(rowNum - 1);
			if (row == null)
				return "";
			cell = row.getCell(colNum);
			if (cell == null)
				return "";

			if (cell.getCellTypeEnum() == CellType.STRING)
				return cell.getStringCellValue();
			// else if(cell.getCellType()==Cell.CELL_TYPE_NUMERIC ||
			// cell.getCellType()==Cell.CELL_TYPE_FORMULA ){
			else if (cell.getCellTypeEnum() == CellType.NUMERIC) {
				String cellText = String.valueOf(cell.getNumericCellValue());

				return cellText;
			} else if (cell.getCellTypeEnum() == CellType.BLANK)
				return "";
			else
				return String.valueOf(cell.getBooleanCellValue());
		} catch (Exception e) {

			e.printStackTrace();
			return "row " + rowNum + " or column " + colNum + " does not exist in xls";
		}
	}
	

}
