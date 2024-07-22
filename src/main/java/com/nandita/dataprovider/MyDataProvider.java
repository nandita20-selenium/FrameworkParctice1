package com.nandita.dataprovider;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;

public class MyDataProvider {
	
	@DataProvider(name="loginTestData")
	public static Object[][] generateUser()
	{
    	Reporter.log("Preparing Data from excell", true);
    	Object [][]arr=ExcelReader.getDatafromExcel("LoginCredential");
    	Reporter.log("Test Data Prepared", true);
    	return arr;
		}

}
