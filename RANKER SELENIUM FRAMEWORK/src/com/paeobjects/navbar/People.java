package com.paeobjects.navbar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.seleniumhq.jetty7.util.thread.Timeout.Task;
import org.testng.Assert;

import com.paeobjects.home.Commonpage;

public class People extends Commonpage{
	
	private WebDriver driver;
	
	private By peopleHeader(){
		return By.xpath("//h1[text()=' People']");
	}
	private By seeAllPeople(){
		return By.xpath("//a[text()='see all  People ']");//div[@id='siteNavCatLists']/a
	}
	
	private By tag(){
		return By.xpath("//div[@id='siteNavCategories']//a[contains(@href,'tags')]");
	}
	
	private By clazz(){
		return By.xpath("//div[@id='siteNavCategories']//a[contains(@href,'lists') and(not(contains(text(), 'lists-of')))]");
	}
	
	private By category(){
		return By.xpath("//div[@id='siteNavCategories']//a[contains(@href,'lists-of')]");
	}
	
	private By allRankertoics(){
		return By.xpath("//a[text()=' all ranker topics ']");
	}
	

	public People(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	public boolean verifyPeopleHeader(){
		return isElementPresent(peopleHeader());
	}
	
	public void clickOnSeeAllPeople(){
		safeClick(seeAllPeople());
	}
	
	public boolean clickonTag(){
		if(isElementPresent(tag()))
		{
			safeClick(tag());
			return true;
		}
		else return false;
	}
	
	public boolean clickonClass(){
		if(isElementPresent(clazz()))
		{
			safeClick(clazz());
			return true;
		}
		else return false;
	}
	
	public boolean clickonCateory(){
		if(isElementPresent(category(),VERYSHORTWAIT))
		{
			safeClick(category());
			return true;
		}
		else return false;
	}
	
	public void clickOnAllRankerToics(){
		safeClick(allRankertoics());
	}

}
