package com.nandita.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class HomePageFramework {
	
	 public WebDriver driver;
	
	public HomePageFramework(WebDriver driver1)
	{
		this.driver=driver1;
		
	}
	
	By welcomemsg=By.xpath("//h4[normalize-space()='Welcome Admin Manager to Learn Automation Courses']");

	
	public boolean welcomeMessage()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		boolean status=driver.findElement(welcomemsg).isDisplayed();
		return status;
		
	}


	
	
}

