package com.XBP.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.XBP.base.TestBase;
import com.XBP.util.TestUtil;
import com.XBP.util.WebDriverWaitClass;

public class AutoPayPage extends TestBase {
	AccountsPage accountsPage;
	WebDriverWaitClass webDriverWait;
	TestUtil testUtil;
	// PageFactory - OR
	
	@FindBy(xpath="//input[@id='Id_Search']")
	WebElement clickSearchBar;
	
	@FindBy(xpath="//span[@class='search']")
	WebElement clickSearchIcon;
	
	@FindBy(xpath="//tr[1]/td/div[2]/div/div/span[6]/button[1][text()='Edit']")
	WebElement clickEditButton;
	
	@FindBy(xpath="//tr[1]/td/div[2]/div/div/span[6]/button[1][text()='Setup']")
	WebElement clickSetUpButton;
	
	@FindBy(xpath="//tr[1]/td/div[2]/div/div/span[6]/button[1][@type='button']")
	WebElement getButtonElementText;
	
	@FindBy(xpath="//h5[text()='Payment Schedule']")
	WebElement verifyPaymentSchedule;
	
	@FindBy(xpath="//div[1]/div/div/ng-include/button[@ng-click='doNext()']")
	WebElement clickNextButton1;
	
	@FindBy(xpath="//div[2]/div/div/ng-include/button[@ng-click='doNext()']")
	WebElement clickNextButton2;
	
	@FindBy(xpath="//div[3]/div/div/ng-include/button[@ng-click='doNext()']")
	WebElement clickNextButton3;	
	
	@FindBy(xpath="//div[4]/div/div/ng-include/button[@ng-click='doNext()']")
	WebElement clickNextButton4;
	
	@FindBy(xpath="//div[5]/div/div/ng-include/button[text()='Save Changes']")
	WebElement clickSummaryPageSaveButton;
	
	@FindBy(xpath="//div[4]/div/div/ng-include/button[text()='Save Changes']")
	WebElement clickNotificationPageSaveButton;	
	
	@FindBy(xpath="//div[5]/div/div/ng-include/button[text()='Close']")
	WebElement clickCloseButton;		
	
	@FindBy(id="Id_DayOfMonth")
	WebElement selectDayOfMonth;
	
	@FindBy(id="Id_BasedDueDateRadio")
	WebElement selectDueDate;
	
	@FindBy(id="Id_BasedCalendarRadio")
	WebElement selectCalenderDate;
	
	@FindBy(id="Id_DaysBeforeDueDate")
	WebElement daysBeforeDueDate;	
	
	@FindBy(id="Id_PaymentAmount")
	WebElement selectPaySetAmount;
	
	@FindBy(id="Id_PaySetAmount")
	WebElement enterPaySetAmount;
	
	@FindBy(id="Id_EmailNotification")
	WebElement IdEmailNotification;
	
	@FindBy(id="Id_PaymentAmountOption")
	WebElement enterFullBillSetAmount;	
		
	@FindBy(xpath="//a[text()='Add Primary']")
	WebElement checkPayMethod;
	
	@FindBy(xpath="//div/div[@aria-expanded='false']")
	WebElement payMethod;
		
	@FindBy(xpath="//ul[1]/li[@class='ng-scope']/div[@class='payment-method']/div/span[@class='icon']/img[@alt='eCheck - Savings']")
	WebElement clickOnEftPayMethod;
	
	@FindBy(xpath="//div/div[@class='payment-method']/div[@class='add']/a[text()='Add Primary']")
	WebElement clickOnAddPayMethod;
	
	@FindBy(xpath="//ul[1]/li[@class='ng-scope']")
	WebElement clickArrowIcon;
		
	@FindBy(xpath="//div[@id='primary-payment-method']/xbp-payment-method-selector/div[@class='payment-method-container']")
	WebElement hoverElement;
	
	@FindBy(xpath="//div[@id='primary-payment-method']/xbp-payment-method-selector/div/ul/li[6]/div[@class='payment-method']")
	WebElement clickFirstMethod;
	
	@FindBy(xpath="//div[@id='primary-payment-method']/xbp-payment-method-selector/div/div/span/span[4]")
	WebElement getToolTip;		
	
	@FindBy(xpath="//div[@id='primary-payment-method']/xbp-payment-method-selector/div/div[@class='payment-method-selector tooltipster selected']")
	WebElement alreadyPayMethodSelected;
	
	@FindBy(xpath="//label[@for='notify-payment-processed']")
	WebElement notifyPaymentProcessed;		
	@FindBy(xpath="//label[@for='notify-fails-payment']")
	WebElement notifyFailsPayment;	
	@FindBy(xpath="//label[@for='notify-new-payment-scheduled']")
	WebElement notifyNewPaymentScheduled;	
	@FindBy(xpath="//label[@for='notify-auto-pay-disabled']")
	WebElement notifyAutopayDisabled;	
	@FindBy(xpath="//label[@for='notify-auto-pay-enabled']")
	WebElement notifyAutopayEnabled;	
	
	private static String locator="//div[@id='primary-payment-method']/xbp-payment-method-selector/div/div[@class='payment-method-selector tooltipster selected']"; 
	private static String fixedPaySetAmount="2";
	private static String PAYMENT_SCHEDULE ="PAYMENT SCHEDULE";
	private static String EDIT_AUTOPAY ="EDIT";
	private static String SETUP_AUTOPAY ="SETUP";
	private static String ACCOUNT_NUMBER ="4011015";
	//private static String RGBGREEN="rgb(57, 181, 74)"; 
	private static String RGBGREY="rgb(179, 179, 179)";
	private static String EmailCheck="nikhilkh@alohatechnology.com";
	
	
		public AutoPayPage() {
		PageFactory.initElements(driver, this);
		}
	
		
		public void searchAutoPay()  {
			clickSearchBar.click();	
			int readExcel = (int) TestUtil.readExcelAccountNum();
		//	System.out.println("Data print"+readExcel);
			clickSearchBar.sendKeys(String.valueOf(readExcel));			
			clickSearchIcon.click();		
			
		}
	
		public boolean editOrSetUpAutoPay() {
		String textRead=getButtonElementText.getText();		
		if(textRead.equals(EDIT_AUTOPAY)) {			
			return true;
		}
			else if(textRead.equals(SETUP_AUTOPAY)){
			return false;
		}
		return false;
		
		}	
		public void setUpAutoPayToSetFixedDayFixedAmount() throws InterruptedException{
		
			clickSetUpButton.click();
			fixedDayPaymentScheduleTab();
			payFixedAmountTab();
			selectMethodTab();
			notificationTab();
			summaryTab();
		}
	
		public void setUpAutoPayToSetFixedDayFullAmount() throws InterruptedException{
		
			clickSetUpButton.click();
			fixedDayPaymentScheduleTab();
			payFullAmountTab();
			selectMethodTab();
			notificationTab();
			summaryTab();
		}
		
		public void setUpAutoPayToSetDueDateFullAmount() throws InterruptedException{
			
			clickSetUpButton.click();
			dueDatePaymentScheduleTab();			
			payFullAmountTab();
			selectMethodTab();
			notificationTab();
			summaryTab();
			}
	
		public void editAutopayToSetFixedDayFixedAmount() throws InterruptedException {
				
			clickEditButton.click();			
			fixedDayPaymentScheduleTab();
			payFixedAmountTab();
			selectMethodTab();
			notificationTab();
			summaryTab();
		}
	
		public void editAutopayToSetFixedDayFullAmount() throws InterruptedException {
		
			clickEditButton.click();			
			fixedDayPaymentScheduleTab();
			payFullAmountTab();
			selectMethodTab();
			notificationTab();
			summaryTab();
		}
		
		public void editAutopayToSetDueDateFullAmount() throws InterruptedException {
			
			clickEditButton.click();			
			dueDatePaymentScheduleTab();
			payFullAmountTab();
			selectMethodTab();
			notificationTab();
			summaryTab();
			}
		
	
		public void fixedDayPaymentScheduleTab() {
		String getText=verifyPaymentSchedule.getText();
		Assert.assertEquals(getText, PAYMENT_SCHEDULE);
		if(getText.equals(PAYMENT_SCHEDULE)) {		
			boolean radio=selectCalenderDate.isSelected();		
			if(radio==false) {				
				selectCalenderDate.click();									
			}	
			Select drop = new Select(selectDayOfMonth);
		    drop.selectByIndex(2);
			clickNextButton1.click();		
			
			}
		}	
		
		public void dueDatePaymentScheduleTab() {
			String getText=verifyPaymentSchedule.getText();
			Assert.assertEquals(getText, PAYMENT_SCHEDULE);
			if(getText.equals(PAYMENT_SCHEDULE)) {
				boolean radio=selectDueDate.isSelected();		
				if(radio==false) {				
					selectDueDate.click();									
				}				
				Select drop = new Select(daysBeforeDueDate);
			    drop.selectByIndex(3);
				clickNextButton1.click();				
				
				}
			}	
	
		public void payFixedAmountTab() {
		boolean radio=selectPaySetAmount.isSelected();		
			if(radio==false) {				
				selectPaySetAmount.click();									
			}
			enterPaySetAmount.clear();	
			enterPaySetAmount.sendKeys(fixedPaySetAmount);
			clickNextButton2.click();			
		}
		
		public void payFullAmountTab() {
			boolean radio=enterFullBillSetAmount.isSelected();		
				if(radio==false) {				
					selectPaySetAmount.click();									
				}				
				clickNextButton2.click();				
			}
			
		
		public void selectMethodTab() {			
		
			boolean isElementDisplayed = false;			
			if (driver.findElements(By.xpath(locator)).size() != 0) {
                	WebElement element = driver.findElement(By.xpath(locator));
                	isElementDisplayed= element.isDisplayed();                	      
                	clickNextButton3.click();                	
				}
		
				else {
					clickOnAddPayMethod.click();					
					clickFirstMethod.click();
					clickNextButton3.click();								
				}
		}		
		
		
		public void notificationTab() {
			
			String notifyPaymentProcessedColor = ((JavascriptExecutor)driver).executeScript("return window.getComputedStyle(arguments[0], ':after').getPropertyValue('background-color')",notifyPaymentProcessed).toString();				
			if(notifyPaymentProcessedColor.equals(RGBGREY)) {
				notifyPaymentProcessed.click();								
			}
			String notifyFailsPaymentColor = ((JavascriptExecutor)driver).executeScript("return window.getComputedStyle(arguments[0], ':after').getPropertyValue('background-color')",notifyFailsPayment).toString();
			if(notifyFailsPaymentColor.equals(RGBGREY)) {
				notifyFailsPayment.click();								
			}
			String notifyNewPaymentScheduledColor = ((JavascriptExecutor)driver).executeScript("return window.getComputedStyle(arguments[0], ':after').getPropertyValue('background-color')",notifyNewPaymentScheduled).toString();
			if(notifyNewPaymentScheduledColor.equals(RGBGREY)) {
				notifyNewPaymentScheduled.click();								
			}
			String notifyAutopayDisabledColor = ((JavascriptExecutor)driver).executeScript("return window.getComputedStyle(arguments[0], ':after').getPropertyValue('background-color')",notifyAutopayDisabled).toString();
			if(notifyAutopayDisabledColor.equals(RGBGREY)) {
				notifyAutopayDisabled.click();								
			}
			String notifyAutopayEnabledColor = ((JavascriptExecutor)driver).executeScript("return window.getComputedStyle(arguments[0], ':after').getPropertyValue('background-color')",notifyAutopayEnabled).toString();
			if(notifyAutopayEnabledColor.equals(RGBGREY)) {
				notifyAutopayEnabled.click();		
			}
			
			String Email=IdEmailNotification.getAttribute("value");	
			String ReadEmail=TestUtil.readExcelEmail();
			if(Email.equals(ReadEmail)){
				System.out.println("Email available");
			} else {
				IdEmailNotification.clear();
				IdEmailNotification.sendKeys(EmailCheck);
			}
			if(clickNotificationPageSaveButton.isEnabled()) {			
			clickNotificationPageSaveButton.click();
			}
			clickNextButton4.click();			
		}
		
		public void summaryTab() {			
		if(clickSummaryPageSaveButton.isEnabled()) {
			clickSummaryPageSaveButton.click();
			}	
		
		}		
		
}	



