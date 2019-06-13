package com.XBP.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestUtil {
	public static long LOAD_TIME_OUT=120; 
	public static long IMPLICIT_TIME_OUT=120;
	private static String path="D:\\DE_WorkSpace1\\XpressBillPay\\src\\main\\java\\com\\XBP\\util\\Accounts.xls";
	
	 public static int readExcelAccountNum() { 	
		  	 	
		 	File file = new File(path);		 	
		    //Create an object of FileInputStream class to read excel file
		    FileInputStream fis = null;
			try {
				fis = new FileInputStream(file);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		    HSSFWorkbook wb = null;
			try {
				wb = new HSSFWorkbook(fis);
			//	Workbook workbook = WorkbookFactory.create(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    HSSFSheet sheetName = wb.getSheetAt(0); 
		    int data=(int) sheetName.getRow(1).getCell(0).getNumericCellValue();	    
		    return data;
		  
		}
	 
	 public static String readExcelEmail() { 	
	  	 	
		 	File file = new File(path);		 	
		    //Create an object of FileInputStream class to read excel file
		    FileInputStream fis = null;
			try {
				fis = new FileInputStream(file);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		    HSSFWorkbook wb = null;
			try {
				wb = new HSSFWorkbook(fis);
			//	Workbook workbook = WorkbookFactory.create(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    HSSFSheet sheetName = wb.getSheetAt(0); 
		    String data=sheetName.getRow(1).getCell(2).getStringCellValue();    
		    return data;
		  
		}

	
	
}
