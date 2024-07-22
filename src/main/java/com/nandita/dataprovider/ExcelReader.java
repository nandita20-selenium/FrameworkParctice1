package com.nandita.dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	static XSSFWorkbook wb;
	public static Object[][] getDatafromExcel(String Sheetname)
	{
		try {
			wb=new XSSFWorkbook(new FileInputStream(new File("./TestData/TestDataLogin.xlsx")));
		
		} catch (Exception e) {
			
			System.out.println("File not found" +e.getMessage());
		} 
		int row=wb.getSheet(Sheetname).getPhysicalNumberOfRows();
		int col=wb.getSheet(Sheetname).getRow(0).getPhysicalNumberOfCells();
		
		Object [][]arr=new Object[row-1][col];
		
		for(int i=1;i<row;i++)
		 {
			 for(int j=0;j<col;j++)
			 {
				 arr[i-1][j]=getdata(Sheetname,i,j);
			 }
		 }
		//System.out.println("after passing excell values into 2D Object array\n");
		 
		//System.out.println(arr[0][0]);
		               
		try {
			wb.close();
		} catch (Exception e) {
			
			System.out.println("File could not closed" +e.getMessage());
		}	
		return arr;
		
	}

	public static String getdata(String sheetname, int row, int col)
	{
		String value="";
         org.apache.poi.ss.usermodel.CellType type= wb.getSheet(sheetname).getRow(row).getCell(col).getCellType();
	
         if(type==org.apache.poi.ss.usermodel.CellType.NUMERIC)
         {
        	double dvalue= wb.getSheet(sheetname).getRow(row).getCell(col).getNumericCellValue();
             value=String.valueOf(dvalue);
         }
         else
        	 if(type==org.apache.poi.ss.usermodel.CellType.BOOLEAN)
        	 {
        		boolean bvalue= wb.getSheet(sheetname).getRow(row).getCell(col).getBooleanCellValue();
        	  value=String.valueOf(bvalue);
        	 }
        	 else
        		 if(type==org.apache.poi.ss.usermodel.CellType.STRING)
        		 {
        			value= wb.getSheet(sheetname).getRow(row).getCell(col).getStringCellValue();
        		 }
         if(type==org.apache.poi.ss.usermodel.CellType.BLANK)
         {
        	value="";
         }
         return value;
	}
}
