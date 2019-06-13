package com.XBP.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.XBP.base.TestBase;
import com.XBP.pages.AccountsPage;
import com.XBP.pages.AutoPayPage;
import com.XBP.pages.LoginPage;

public class DueDateFullAmount extends TestBase {
	LoginPage loginPage;
	AccountsPage accountsPage;
	AutoPayPage autoPayPage;
	
	public DueDateFullAmount() {
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
	public void DueDateFullAmountAutoPay() throws Exception {
		loginXBPV2();
		loginPage.verifyTitle();
		System.out.println("Verified Title");
		loginPage.verifyXBPLoginPage();	
		System.out.println("Verified Login Page");
		loginPage.LoginXBP();
		System.out.println("Verified Login Successfull");
		accountsPage.VerifyUsername();		
		System.out.println("Verified Account with Username");		
		accountsPage.goToAutoPays();
		System.out.println("Verified AutoPay Page");
		autoPayPage.searchAutoPay();
		System.out.println("Searched for AutoPay");
		autoPayPage.editOrSetUpAutoPay();
		if(autoPayPage.editOrSetUpAutoPay()==true) {
			autoPayPage.editAutopayToSetDueDateFullAmount();
		}
		else if(autoPayPage.editOrSetUpAutoPay()==false) {		
		
			autoPayPage.setUpAutoPayToSetDueDateFullAmount();
		}
			
	}	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}	
}
