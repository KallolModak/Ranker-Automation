package com.paeobjects.navbar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.selenium.SafeActions;

public class Sports extends SafeActions{
	
	private WebDriver driver;
	
	public Sports(WebDriver driver){
		super(driver);
		this.driver=driver;
		try{Thread.sleep(3000);}catch (Exception e){}
		
	}
	
	private By sportsHeader(){
		return By.xpath("//h1[text()=' Sports']");
	}
	
	private By seeAllSports(){
		return By.xpath("//a[text()='see all  Sports ']");
	}

	public boolean verifySportsHeader(){
		return isElementPresent(sportsHeader());
	}
	
	public void clickOnSeeAllSports(){
		safeClick(seeAllSports());
	}


}
