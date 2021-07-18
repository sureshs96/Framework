package com.learnautomation.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {
	
	@SuppressWarnings("deprecation")
	public static WebDriver StartApplication(WebDriver driver,String browsername, String appurl) {
		
		if(browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\SURESH\\eclipse-workspace\\Framework\\Drivers\\chromedriver.exe");		
			driver = new ChromeDriver();
			driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		}
		else if(browsername.equals("edge")){
			System.setProperty("webdriver.edge.driver","C:\\Users\\SURESH\\eclipse-workspace\\Framework\\Drivers\\msedgedriver.exe");
			driver = new EdgeDriver();
			driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		}
		else if(browsername.equals("ie")){
			System.setProperty("webdriver.ie.driver","C:\\Users\\SURESH\\eclipse-workspace\\Framework\\Drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		}
		else {
			System.out.println("the browser is not supported");
		}
		
		driver.manage().window().maximize();
		
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
		
	}
	
	public static void quitBrowser(WebDriver driver) {
		driver.quit();
		
	}
}


