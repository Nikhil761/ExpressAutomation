package com.XBP.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.XBP.base.TestBase;
import com.XBP.util.TestUtil;

public class LoginPage extends TestBase {
	AccountsPage accountsPage;
	// PageFactory - OR
	@FindBy(id="Id_LoginEmail")
	WebElement username;
	
	@FindBy(id="Id_Password")
	WebElement password;
	
	@FindBy(xpath = "//button[@class='btn btn-next']")
	WebElement loginButton;
	
	@FindBy(xpath = "//a[@href='/admin']")
	WebElement VerifyLoginPage;
	
	//Initialize the elemnts
	public LoginPage() {
		PageFactory.initElements(driver, this);
		
	}
	
	public String validateTitlePage()	{
		return driver.getTitle();
		
	}
	
	public boolean verifyLoginPage() {
		return VerifyLoginPage.isDisplayed();
	}
	
	public AccountsPage Login(String uname, String pass) {
		username.sendKeys(uname);
		password.sendKeys(pass);
		loginButton.click();
		
		return new AccountsPage();
		
	}
	
	public void verifyTitle() {
		String title=validateTitlePage();
		Assert.assertEquals(title, "Xpress Bill Pay");		
	}
	public void verifyXBPLoginPage() {		
		boolean flag=verifyLoginPage();		
		Assert.assertTrue(flag);
		
	}
public void LoginXBP() throws InterruptedException {				
		accountsPage=Login(prop.getProperty("username"), prop.getProperty("password"));
		driver.manage().timeouts().pageLoadTimeout(TestUtil.LOAD_TIME_OUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_TIME_OUT, TimeUnit.SECONDS);		
	}

}
