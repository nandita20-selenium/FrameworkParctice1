package com.nandita.testcases;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.nandita.base.base;
import com.nandita.dataprovider.MyDataProvider;
import com.nandita.pages.HomePageFramework;
import com.nandita.pages.LoginPageFramework;
import com.nandita.pages.addCategory;
import com.nandita.pages.manageCategories;

public class manageCategoryTest extends base {
	
	LoginPageFramework login;
	manageCategories mCat;
	@Test(dataProvider = "loginTestData", dataProviderClass = MyDataProvider.class)
	public void mCatLogin(String username, String password) 
	{
		login= PageFactory.initElements(driver, LoginPageFramework.class);
		HomePageFramework home=login.LoginApplication1(username, password);
		assertTrue(home.welcomeMessage(), "Login Failed");
		mCat=PageFactory.initElements(driver, manageCategories.class);
		addCategory addCat= mCat.mCategories();
		addCat.print();
	}

}
