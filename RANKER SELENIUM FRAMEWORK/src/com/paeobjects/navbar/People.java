package com.paeobjects.navbar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.paeobjects.home.Commonpage;

public class People extends Commonpage{
	
	private WebDriver driver;
	
	private By peopleHeader(){
		return By.xpath("//h1[text()=' People']");
	}
	private By seeAllPeople(){
		return By.xpath("//a[text()='see all  People ']");//div[@id='siteNavCatLists']/a
	}
	
	

	public People(WebDriver driver) {
		super(driver);
		this.driver=driver;
		try{Thread.sleep(3000);}catch (Exception e){}
	}
	
	public boolean verifyPeopleHeader(){
		return isElementPresent(peopleHeader());
	}
	
	public void clickOnSeeAllPeople(){
		safeClick(seeAllPeople());
	}
	
}
