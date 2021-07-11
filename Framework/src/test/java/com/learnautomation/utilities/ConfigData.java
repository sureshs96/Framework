package com.learnautomation.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigData {
	Properties pro;
	
	public ConfigData() {
		
		File src = new File("./Config/Config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			
			pro = new Properties();
			pro.load(fis);
			
		} catch (Exception e) {
			System.err.println("unable to read config file"+e.getMessage());
		}
	}
	
	public String getBrowser() {
		return pro.getProperty("Browser");
	}
	
	public String getUrl() {
		return pro.getProperty("url");
	}
	
	public String getDataFromConfig(String keysearch) {
		return pro.getProperty(keysearch);
	}
}
