package com.learnautomation.pages;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.learnautomation.utilities.BrowserFactory;
import com.learnautomation.utilities.ConfigData;
import com.learnautomation.utilities.ExcelDataProvider;
import com.learnautomation.utilities.Helper;

public class BaseClass {
	public WebDriver driver;
	public ConfigData config;
	public ExcelDataProvider data;
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite
	public void setUpSuite() {
		
		Reporter.log("Test requirements are gathering and test is ready", true);
		config = new ConfigData();
		data = new ExcelDataProvider();
		
		ExtentSparkReporter extent = new ExtentSparkReporter(new File(System.getProperty("user.dir")+"/Reports/SC_"+Helper.getCurrentDate()+".html"));
		report = new ExtentReports();
		report.attachReporter(extent);
		Reporter.log("Test requirements gathered and test is started", true);
	}
	
	@BeforeClass
	public void setup(){
		Reporter.log("Browser started", true);
		driver = BrowserFactory.StartApplication(driver, config.getBrowser(),config.getUrl());
		Reporter.log("Browser launched successfully", true);
	}
	
	@AfterClass
	public void teardown() {
		Reporter.log("Browser started", true);
		BrowserFactory.quitBrowser(driver);
		Reporter.log("Browser closed successfully", true);
	}
	
	@AfterMethod
	public void tearDownMethod(ITestResult Result) throws InterruptedException {
		Reporter.log("capturing sc", true);
		Thread.sleep(1000);
		if(Result.getStatus() == ITestResult.FAILURE) {
			logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.capturescreenshot(driver)).build());
		}else if(Result.getStatus() == ITestResult.SUCCESS) {
			logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.capturescreenshot(driver)).build());
//			logger.pass("details").addScreenCaptureFromPath(Helper.capturescreenshot(driver));
		}
		report.flush();
		Reporter.log("Reports generated succssfully", true);
	}
	
}
