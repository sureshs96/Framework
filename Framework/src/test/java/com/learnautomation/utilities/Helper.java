package com.learnautomation.utilities;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import freemarker.template.SimpleDate;

public class Helper {

	public static String capturescreenshot(WebDriver driver) {
		String screenshotpath = System.getProperty("user.dir")+"./Screenshots/screenshot_"+ getCurrentDate() +".png";
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try {
			FileHandler.copy(src, new File(screenshotpath));
			System.out.println("SC Captured...");
			
		} catch (Exception e) {
			System.out.println("unable to take sc"+e.getMessage());
		}
		
		return screenshotpath;
	}
	
	public static String getCurrentDate() {
		DateFormat changeformat = (DateFormat) new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentdate = new Date();
		return ((DateFormat) changeformat).format(currentdate);
	}
	
}
