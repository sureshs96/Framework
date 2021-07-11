package com.learnautomation.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.learnautomation.pages.BaseClass;
import com.learnautomation.pages.loginPage;

public class LoginCRM extends BaseClass{
	
	@Test(priority=1)
	public void loginApp() throws InterruptedException  {
		
		logger = report.createTest("login into fb application");
		
		//Abstraction method -- showing the essential features but hiding the internal logic..
		loginPage LoginPage = PageFactory.initElements(driver, loginPage.class);
		logger.info("Starting Application");
		LoginPage.LogintoFB(data.getStringData("Sheet1", 1, 0), data.getStringData("Sheet1", 1, 1));
		
		Thread.sleep(3000);
		logger.pass("user loggin successfull");
		
	}
	
	@Test(priority=2)
	public void loginApp1() throws InterruptedException  {
		
		logger = report.createTest("logout from fb");
		
		logger.fail("user logout fail");
	}
}
