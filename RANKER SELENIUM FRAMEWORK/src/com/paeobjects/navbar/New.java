package com.paeobjects.navbar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.paeobjects.home.Commonpage;

public class New extends Commonpage{
	
	private WebDriver driver;
	
	public New(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}

	private By recentList(){
		return By.xpath("//h1[text()=' Recent Lists ']");
	}
	
	public boolean verifyRecentListHeader(){
		return isElementPresent(recentList(), MEDIUMWAIT);
	}

}
