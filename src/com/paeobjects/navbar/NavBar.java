package com.paeobjects.navbar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.paeobjects.home.Commonpage;

public class NavBar extends Commonpage{
	
	private WebDriver driver;

	public NavBar(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}

	/***************************Page locators*******************************/
	private By newlnk(){
		return By.id("nav_recent");
	}
	
	private By people(){
		return By.id("nav_people");
	}
	
	private By film(){
		return By.id("nav_film");
	}
	
	private By tv(){
		return By.xpath("nav_tv");
	}
	
	private By music(){
		return By.id("nav_music");
	}
	
	private By overlay(){
		return By.id("siteNavCategories");
	}
	
	private By overlayImages(int i){
		return By.xpath("//div[@id='siteNavCatLists']//li["+i+"]/a/img");
	}
	
	private By overlayList(int i){
		return By.xpath("//div[@id='siteNavCategories']/ul/li["+i+"]/a");
	}
	
	private By seeAlltopics(){
		return By.xpath("//a[text()=' all ranker topics ']");
	}
	
	/******************************Safe operations**************************/
	public New clickNew(){
		safeClick(newlnk(),LONGWAIT);
		return new New(driver);
	}
	
	public void hoverNew(){
		mouseHover(newlnk(),LONGWAIT);
	}
	
	public People clickPeople(){
		safeClick(people(), LONGWAIT);
		return new People(driver);
	}
	
	public void hoverPeople(){
		mouseHover(people(), LONGWAIT);
	}
	
	public boolean verifyOverlay(){
		return isElementDisplayed(overlay());
	}
	
	public boolean verifyoverlayblockActive(int i) throws Exception{
		By e=overlayList(i);
		WebElement ee=driver.findElement(e);
				String s=ee.getAttribute("class");
				highlightElement(ee);
				boolean b=s.equals("block active");
		return b;
	}
	
	public boolean verifyoverlayImages(int i){
		return isElementPresent(overlayImages(i));
	}
	
	public boolean verifySeeAlltopics(){
		return isElementPresent(seeAlltopics());
	}
	
	
}
