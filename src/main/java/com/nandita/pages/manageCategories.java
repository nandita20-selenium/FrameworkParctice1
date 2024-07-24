package com.nandita.pages;

import java.awt.Desktop.Action;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class manageCategories {
	
	public WebDriver driver;
	
	
	public manageCategories(WebDriver driver1)
	{
		this.driver=driver1;
	}

	public addCategory mCategories()
	{
	 Actions act=new Actions(driver);
	 WebElement manage=driver.findElement(By.xpath("//span[normalize-space()='Manage']"));
	 act.moveToElement(manage).perform();
	 driver.findElement(By.xpath("//a[normalize-space()='Manage Categories']")).click();
	 addCategory category=new addCategory();
	return category;
	
	}
}
