package com.paeobjects.home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.selenium.SafeActions;

public abstract class Commonpage extends SafeActions{
	
	private WebDriver driver;
	public Commonpage(WebDriver driver) {
		super(driver);
	}
	
	private By rankerLogo(){
		return By.xpath("//a[@id='logo']");
	}
	
	public void clickOnLogo() throws Exception{
		safeClick(rankerLogo());
		waitForPageToLoad();
	}
	
	public boolean verifyRankerLogo(){
		return isElementPresent(rankerLogo());
	}
	
//	public abstract void m();

}
