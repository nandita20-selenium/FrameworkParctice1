package com.nandita.dataprovider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nandita.pages.HomePageFramework;
import com.nandita.pages.UserSignUp;


public class LoginPageFramework {
	
 public WebDriver driver; //instance variable
	
	public LoginPageFramework(WebDriver driver1)//here constructor is required to initiate driver otherwise null point exception will come
	{
		this.driver=driver1;
		
	}
	
	private By username=By.xpath("//input[@id='email1']");
	private By password=By.xpath("//input[@id='password1']");
	private By LoginButton=By.xpath("//button[normalize-space()='Sign in']");
	private By newUserlink=By.xpath("//a[normalize-space()='New user? Signup']");
	
    
	
	public boolean newUserLink()
	{
		boolean status=driver.findElement(newUserlink).isDisplayed();
		return status;
	}
	

	
	public HomePageFramework LoginApplication1(String uname, String pwd)
	{
		driver.findElement(username).sendKeys(uname);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(LoginButton).click();
		//HomePage home=new HomePage(driver); or
		HomePageFramework home1=PageFactory.initElements(driver, HomePageFramework.class);
		return home1;
				
	}
	public void signUpClick() 
	{
		
		
	}

	
}
