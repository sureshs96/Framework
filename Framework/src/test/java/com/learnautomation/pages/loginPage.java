package com.learnautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPage {
	
	WebDriver driver;
	public loginPage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	@FindBy(xpath="//input[@name='email']") WebElement username;
	@FindBy(id="pass") WebElement password;
	@FindBy(name="login") WebElement submit;
	
	
	public void LogintoFB(String Username, String Password) throws InterruptedException {
		
		Thread.sleep(3000);
		
		username.sendKeys(Username);
		password.sendKeys(Password);
		submit.click();
	}

}
