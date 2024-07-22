package com.nandita.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.nandita.dataprovider.configReader;
import com.nandita.factory.BrowserFactory;
import com.nandita.pages.LoginPageFramework;

public class base {
	
   public WebDriver driver;
	
	@BeforeMethod
	public void setup()
	{
		System.out.println("Log In - Browser Started, before the method");
		//driver=BrowserFactory.startBrowser(configReader.getProperty("browserName"), configReader.getProperty("appURLQA")+"/login");
		driver=BrowserFactory.startBrowser(configReader.getProperty("browserName"), configReader.getProperty("appURLQA"));
		System.out.println("Browser is up and running");
		
	}
	
	@AfterMethod
	public void teardown()
	{
	//if(driver !=null)
		//System.out.println("Browser is closed after the method");
	    BrowserFactory.QuitBrowser(driver);
		System.out.println("Session closed");
	} 

	/*@AfterMethod
	 public void goBack()
	 {
		BrowserFactory.BackBrowser(driver);
		
	 }*/
	 
	 
}
