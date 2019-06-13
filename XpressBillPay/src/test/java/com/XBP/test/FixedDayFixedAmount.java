package com.XBP.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.XBP.base.TestBase;
import com.XBP.pages.AccountsPage;
import com.XBP.pages.AutoPayPage;
import com.XBP.pages.LoginPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class FixedDayFixedAmount extends TestBase{
	LoginPage loginPage;
	AccountsPage accountsPage;
	AutoPayPage autoPayPage;
	
	public FixedDayFixedAmount() {
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
	public void FixedDayFixedAmountAutoPay() throws Exception {		
		ExtentHtmlReporter extent=new ExtentHtmlReporter("D:\\DE_WorkSpace1\\XpressBillPay\\Reports\\extentreport.html");
		ExtentReports report =new ExtentReports();
		report.attachReporter(extent);	
		ExtentTest logger=report.createTest("FixedDayFixedAmountAutoPay");	
		loginXBPV2();		
		logger.log(Status.INFO, "Staring Test Case");
		loginPage.verifyTitle();
		logger.pass("Verified Title");
		loginPage.verifyXBPLoginPage();	
		logger.pass("Verified Login Page");
		loginPage.LoginXBP();
		logger.pass("Verified Login Successful");
		accountsPage.VerifyUsername();		
		logger.pass("Verified User Name");		
		accountsPage.goToAutoPays();
		logger.pass("Verified AutoPay page");
		autoPayPage.searchAutoPay();
		logger.pass("Scheduling Fix Day Fixed Amount Auto Pay");
		autoPayPage.editOrSetUpAutoPay();			
		if(autoPayPage.editOrSetUpAutoPay()==true) {
			autoPayPage.editAutopayToSetFixedDayFixedAmount();
		}
		else if(autoPayPage.editOrSetUpAutoPay()==false) {		
		
			autoPayPage.setUpAutoPayToSetFixedDayFixedAmount();
		}
		logger.log(Status.INFO, "Finishing Test Case");
		report.flush();
	}	
	
	@AfterMethod
	public void tearDown() {			
		driver.quit();
	}	
}
