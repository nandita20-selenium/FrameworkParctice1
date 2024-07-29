package com.nandita.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserSignUp {


	
	public WebDriver driver;
	
	public UserSignUp(WebDriver driver1)
	{
		this.driver=driver1;
	}
	public void verifyCheckboxes()
	 {
	List<WebElement> checkboxes	= driver.findElements(By.xpath("//div[@class='interests-div']"));
	
	
		    System.out.println(checkboxes.size());
			for(WebElement l: checkboxes)
			{
				List<WebElement> boxes=l.findElements(By.className("form-check-input"));
				int c=boxes.size();
				System.out.println("Total Checkboxes available..." +c);
				//driver.navigate().back();
			}
	 }
	
}
