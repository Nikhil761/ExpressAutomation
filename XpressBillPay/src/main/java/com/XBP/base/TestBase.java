package com.XBP.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.XBP.util.TestUtil;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public static ExtentReports report;
	public static ExtentTest logger;
	public TestBase()
	{
		try {
			prop=new Properties();
			FileInputStream fis=new FileInputStream("D:\\DE_WorkSpace1\\XpressBillPay\\src\\main\\java\\com\\XBP\\config\\Config.properties");
			try {
				prop.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch(FileNotFoundException ex) {
			ex.printStackTrace();
		}
		
	}
	public static void initilization()
	{
		String browserName=prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\drivers\\chromedriver.exe");
			driver=new ChromeDriver();			
		}
		else if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "D:\\drivers\\geckodriver.exe");
			driver=new FirefoxDriver();
		}		
		
	}	
	
	public void loginXBPV2() {	
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.LOAD_TIME_OUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_TIME_OUT, TimeUnit.SECONDS);		
		driver.get(prop.getProperty("url"));	
				
	}

}
