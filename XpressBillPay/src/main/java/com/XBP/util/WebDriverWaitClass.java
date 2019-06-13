package com.XBP.util;

import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.TestException;

import com.XBP.base.TestBase;

public class WebDriverWaitClass extends TestBase {
	

    private WebDriver webDriver;
    protected static final int WAIT_TIME_10_SEC = 10;
    protected static final int WAIT_TIME_20_SEC = 20;
    protected static final int WAIT_TIME_30_SEC = 30;
    protected static final int WAIT_TIME_60_SEC = 60;
    protected static final int WAIT_TIME_120_SEC = 120;
    
    protected WebDriverWaitClass() {
        this.webDriver = driver;
    }


    protected WebDriver getWebDriver() {
        return webDriver;
    }


    public WebDriverWait getWebDriverWait(long timeOutInSeconds) {
        return ((WebDriverWait)new WebDriverWait(webDriver, timeOutInSeconds).ignoring(NoSuchElementException.class));
    }

    protected static <T> boolean successOf(WebDriverWait wait, ExpectedCondition<T> condition) {
        try {
            wait.until(condition);
            return true;
        } catch (TestException e) {
            System.out.println ("Condition failed \n" + e.getMessage()+ "\n" + e.getStackTrace()[3] + "\n" + e.getStackTrace()[4] +"\n" + e.getStackTrace()[5]) ;
        }
        return false;
    }

    protected boolean isWebElementPresent(By by) {
        try {
            successOf(getWebDriverWait(WAIT_TIME_60_SEC), (ExpectedConditions.presenceOfElementLocated(by)));
            webDriver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

 
}
