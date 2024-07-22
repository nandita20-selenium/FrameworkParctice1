package com.nandita.factory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.nandita.dataprovider.configReader;

public class BrowserFactory {
	
	public static WebDriver startBrowser(String Browser, String AppURL)
	{
		WebDriver driver=null;
		System.out.println("Log of" + AppURL + "on" +Browser);
		if(Browser.equalsIgnoreCase("Chrome"))
		{
			ChromeOptions opt=new ChromeOptions();
			if(configReader.getProperty("headless").equalsIgnoreCase("true"))
			{
			System.out.println("Application: " + AppURL + ",is running in headless mode on - " +Browser);
			opt.addArguments("--headless=new");
			}
			driver=new ChromeDriver(opt);
		}
		else if(Browser.equalsIgnoreCase("Firefox"))
		{
			FirefoxOptions opt=new FirefoxOptions();
			System.out.println("Headles ?"+configReader.getProperty("headless"));
			if(configReader.getProperty("headless").equalsIgnoreCase("true"))
			{
			System.out.println("Application: " + AppURL + ",is running in headless mode on - " +Browser);
			opt.addArguments("--headless");
			}
			driver=new FirefoxDriver(opt);
		}
		else if(Browser.equalsIgnoreCase("Edge"))
		{
			EdgeOptions opt=new EdgeOptions();
			if(configReader.getProperty("headless").equalsIgnoreCase("true"))
			{
			System.out.println("Application: " + AppURL + ",is running in headless mode on - " +Browser);
			opt.addArguments("--headless=new");
			}
			driver=new EdgeDriver(opt);
		}
		Long.parseLong(configReader.getProperty("implicitWait"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(configReader.getProperty("implicitWait"))));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Long.parseLong(configReader.getProperty("pageLoadWait"))));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(Long.parseLong(configReader.getProperty("scriptWait"))));
		driver.manage().window().maximize();
		driver.get(AppURL);		
		return driver;
	}
	
	public static void QuitBrowser(WebDriver driver)
	{
		driver.quit();
	}

	public static void BackBrowser(WebDriver driver)
	{
		driver.navigate().back();
	}
}
