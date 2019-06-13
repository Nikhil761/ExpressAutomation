package com.XBP.util;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelSheetData {
	 public void readExcel() throws Exception{

		    //Create an object of File class to open xlsx file

		    File file =    new File("D:\\drivers\\Accounts.xls");

		    //Create an object of FileInputStream class to read excel file

		    FileInputStream fis = new FileInputStream(file);
		    XSSFWorkbook wb=new XSSFWorkbook(fis);
		    XSSFSheet sheet1=wb.getSheetAt(0);
		    String data=sheet1.getRow(1).getCell(1).getStringCellValue();

		  
		}
}
