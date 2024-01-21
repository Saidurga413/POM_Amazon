package com.Ecom.Amazon.utils;

import Amazon.Login.Page.LoginPage;
import Amazon.Login.Test.LoginTest;
import Amazon.ProductSearchAndInCart.Page.ProductSearchPageAndAddInCartPage;

public class PageInitialiser{

	protected static LoginPage loginPage;
	protected static CommonUtils commonUtils;
	protected static LoginTest logintest;
	protected static ProductSearchPageAndAddInCartPage productSearchPageAndAddInCartPages;

	
	public static void initializeAllPages() {

		loginPage = new LoginPage();
		commonUtils = new CommonUtils();
		logintest = new LoginTest();
		productSearchPageAndAddInCartPages = new ProductSearchPageAndAddInCartPage();
		
	}

}
