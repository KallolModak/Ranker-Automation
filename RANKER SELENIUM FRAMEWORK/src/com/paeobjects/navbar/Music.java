package com.paeobjects.navbar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.selenium.SafeActions;

public class Music extends SafeActions{
	
	private WebDriver driver;
	
	public Music(WebDriver driver){
		super(driver);
		this.driver=driver;
		try{Thread.sleep(3000);}catch (Exception e){}
		
	}
	
	private By musicHeader(){
		return By.xpath("//h1[text()=' Music']");
	}
	
	private By seeAllMusic(){
		return By.xpath("//a[text()='see all  Music ']");
	}

	public boolean verifyMusicHeader(){
		return isElementPresent(musicHeader());
	}
	
	public void clickOnSeeAllMusic(){
		safeClick(seeAllMusic());
	}


}
