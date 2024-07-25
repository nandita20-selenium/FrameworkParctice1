package com.nandita.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.nandita.base.Base;
import com.nandita.pages.LoginPageFramework;
import com.nandita.pages.UserSignUp;

public class RegistrationPageTest extends Base {
	
	LoginPageFramework login;
	@Test
	public void newUserClick()
	{
		login = PageFactory.initElements(driver, LoginPageFramework.class);
		UserSignUp sign= login.signUpClick();
		sign.verifyCheckboxes();
        driver.navigate().back();
	}

}
