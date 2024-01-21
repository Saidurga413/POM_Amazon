package com.Ecom.Amazon.utils;

import Amazon.Login.Page.LoginPage;
import Amazon.Login.Test.LoginTest;

public class PageInitialiser{

	protected static LoginPage loginPage;
	protected static CommonUtils commonUtils;
	protected static LoginTest logintest;

	
	public static void initializeAllPages() {

		loginPage = new LoginPage();
		commonUtils = new CommonUtils();
		logintest = new LoginTest();
		
	}

}
