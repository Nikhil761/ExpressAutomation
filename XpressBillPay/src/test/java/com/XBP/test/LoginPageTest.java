package com.XBP.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.XBP.base.TestBase;
import com.XBP.pages.AccountsPage;
import com.XBP.pages.AutoPayPage;
import com.XBP.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	AccountsPage accountsPage;
	AutoPayPage autoPayPage;
	
	public LoginPageTest() {
		super();
	}
		
	@BeforeMethod
	public void setUp() {
		initilization();
		loginPage=new LoginPage();
		accountsPage=new AccountsPage();
		autoPayPage=new AutoPayPage();
		
	}	
	
	@Test(priority=1)
	public void VerifyLogin() throws Exception {
		loginXBPV2();
		loginPage.verifyTitle();
		System.out.println("One");
		loginPage.verifyXBPLoginPage();	
		System.out.println("Two");
		loginPage.LoginXBP();
		accountsPage.VerifyUsername();		
		System.out.println("Three");		
		accountsPage.goToAutoPays();
		System.out.println("Four");
		autoPayPage.searchAutoPay();
		System.out.println("Five");
		autoPayPage.editOrSetUpAutoPay();
		System.out.println("Six");
			
	}	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}	

}
