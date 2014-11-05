package com.pageobject.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.dataprovider.ConfigManager;
import com.selenium.SafeActions;
import com.utilities.TimeOuts;

public class SigninPage extends SafeActions{
	
	private WebDriver driver;
	ConfigManager config;
	
	public SigninPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		config=new ConfigManager();
	}
	
	private By signIn(){
		return By.xpath("//span[text()='sign in']");
	}
	
	private By loginUser(){
		return By.id("loginUser");
	}
	
	private By password(){
		return By.id("loginPass");
	}
	
	private By btnSignin(){
		return By.id("loginButton");
	}
	
	public void clickSignin(){
		safeClick(signIn(), TimeOuts.LONGWAIT);
	}
	
	public boolean verifyLoginPage() throws Exception
	{
		return isElementPresent(signIn(), SHORTWAIT);
	}
		
	public void enterCredentels(String strUName, String strPwd){
		safeType(loginUser(), strUName);
		safeType(password(), strPwd);
		
	}
	public HomePage clickSubmit(){
		safeClick(btnSignin());
		return new HomePage(driver);
	}

	

}
