package com.pageobject.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.dataprovider.ConfigManager;
import com.selenium.SafeActions;

public class HomePage extends SafeActions{
	
	private WebDriver driver;
	
	private By profileLogo(){
		return By.id("userProfileImg");
	}
	private ConfigManager config;
	public HomePage(WebDriver driver) {
		super(driver);
		config=new ConfigManager();
		this.driver=driver;
		Assert.assertTrue(isElementPresent(profileLogo()),"Profile page");
	}

}
