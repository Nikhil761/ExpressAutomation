package com.XBP.test;

import org.testng.annotations.BeforeMethod;

import com.XBP.base.TestBase;
import com.XBP.pages.AccountsPage;
import com.XBP.pages.LoginPage;

public class AddPayMethod extends TestBase{	
		LoginPage loginPage;
		AccountsPage accountsPage;
		
		
		public AddPayMethod() {
			super();
		}
			
		@BeforeMethod
		public void setUp() {
			initilization();
			loginPage=new LoginPage();
			accountsPage=new AccountsPage();
			
			
		}	
}
