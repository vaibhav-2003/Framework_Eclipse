package com.ibm.stax.BusinessUtilities;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbookType;

public class ExcelReader {
	
	XSSFWorkbook wb;
	public ExcelReader()
	{
	
	File src=new File("C:/Users/VAIBHAV/git/Framework_Eclipse/FrameworkProject/TestData/Test_Data.xlsx");
	
	try
	{
	FileInputStream fis=new FileInputStream(src);
	
    wb=new XSSFWorkbook(fis);
	}
	catch(Exception e)
	{
		e.printStackTrace();
		System.out.println("Unable to read Excel File" + e.getMessage());
	}}
	
	public String getStringdata(String sheetname,int row,int column)
	{
		return wb.getSheet(sheetname).getRow(row).getCell(column).getStringCellValue();
	}
	
	public String getStringdata(int sheetid,int row,int column)
	{
		return wb.getSheetAt(sheetid).getRow(row).getCell(column).getStringCellValue();
	}
	
	public double getnumericdata(String sheetname,int row,int column)
	{
		return wb.getSheet(sheetname).getRow(row).getCell(column).getNumericCellValue();
	}
	
	
}
