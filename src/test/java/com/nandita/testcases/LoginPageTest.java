package com.nandita.testcases;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nandita.base.base;
import com.nandita.dataprovider.MyDataProvider;
import com.nandita.pages.HomePageFramework;
import com.nandita.pages.LoginPageFramework;
// This class is real Test which is using page object model
// here oops concepts are: Inheritance, encapsulation and abstraction

public class LoginPageTest extends base 
 {
	LoginPageFramework login;
	@Test(dataProvider = "loginTestData", dataProviderClass = MyDataProvider.class)
	public void Login(String username, String password) 
	{
		login= PageFactory.initElements(driver, LoginPageFramework.class);
		HomePageFramework home=login.LoginApplication1(username, password);
		assertTrue(home.welcomeMessage(), "Login Failed");
	}

	@Test
	public void verifyNewUserLink()
	{
		login= PageFactory.initElements(driver, LoginPageFramework.class);
		assertTrue(login.newUserLink(), "Link is not present");
    
	}
}
