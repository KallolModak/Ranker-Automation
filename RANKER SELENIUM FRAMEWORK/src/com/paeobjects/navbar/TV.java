package com.paeobjects.navbar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.selenium.SafeActions;

public class TV extends SafeActions{
	
	private WebDriver driver;
	
	public TV(WebDriver driver){
		super(driver);
		this.driver=driver;
		try{Thread.sleep(3000);}catch (Exception e){}
		
	}
	
	private By tvHeader(){
		return By.xpath("//h1[text()=' TV']");
	}
	
	private By seeAllTvs(){
		return By.xpath("//a[text()='see all  TV ']");
	}

	public boolean verifyTvHeader(){
		return isElementPresent(tvHeader());
	}
	
	public void clickOnSeeAllTv(){
		safeClick(seeAllTvs());
	}


}
