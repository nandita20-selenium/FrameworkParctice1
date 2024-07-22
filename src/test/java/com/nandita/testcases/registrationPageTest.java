package com.nandita.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.nandita.base.base;
import com.nandita.pages.LoginPageFramework;
import com.nandita.pages.userSignUp;

public class registrationPageTest extends base {
	
	LoginPageFramework login;
	@Test
	public void newUserClick()
	{
		login = PageFactory.initElements(driver, LoginPageFramework.class);
		userSignUp sign= login.signUpClick();
		sign.verifyCheckboxes();
        driver.navigate().back();
	}

}
