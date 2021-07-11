package com.learnautomation.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	XSSFWorkbook wb;
	
	public ExcelDataProvider() {
		
		File src = new File("./TestData/Data.xlsx");
		
		
		try {
			FileInputStream  fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
		} catch (IOException e) {
			System.out.println("unable to read file"+ e.getMessage());
		}
		
	}
	
	
	// overloading -- two methods with same name but diff params
	public String getStringData(int sheetIndex, int row, int col) {
		return wb.getSheetAt(sheetIndex).getRow(row).getCell(col).getStringCellValue();
	}
	
	public String getStringData(String sheetname, int row, int col) {
		return wb.getSheet(sheetname).getRow(row).getCell(col).getStringCellValue();
	}
	
	public double getNumericData(String sheetname, int row, int col) {
		return wb.getSheet(sheetname).getRow(row).getCell(col).getNumericCellValue();
	}

}
