package com.XBP.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.XBP.base.TestBase;

public class AccountsPage extends TestBase{
	//PageFactory -- OR
	AutoPayPage autoPayPage;
	
	@FindBy(xpath="//span[text()='Nikhil Khanna']")
	WebElement userNameLabel;
	
	@FindBy(xpath="//ul/li[3]/a[text()='Auto Pays']")
	WebElement clickAutoPayLink;
	
	public AccountsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean VerifyUsername() {
		return userNameLabel.isDisplayed();		
	}
	
	
	public AutoPayPage goToAutoPays()	{
		
		clickAutoPayLink.click();			
		return new AutoPayPage();
		
		
	}
	
}
