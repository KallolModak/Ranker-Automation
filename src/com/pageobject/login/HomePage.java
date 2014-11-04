package com.pageobject.login;

import org.openqa.selenium.WebDriver;

import com.dataprovider.ConfigManager;
import com.selenium.SafeActions;

public class HomePage extends SafeActions{
	
	private WebDriver driver;
	private ConfigManager config;
	public HomePage(WebDriver driver) {
		super(driver);
		config=new ConfigManager();
	}

}
