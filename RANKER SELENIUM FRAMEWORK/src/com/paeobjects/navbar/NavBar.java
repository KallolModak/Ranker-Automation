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
	
	private By overlayPeople(){
		return By.xpath("//ul[@class='float relative lowercase main']//a[text()=' People']");
	}
	
	private By people(){
		return By.id("nav_people");
	}
	
	private By film(){
		return By.id("nav_film");
	}
	
	private By tv(){
		return By.id("nav_tv");
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
	
	public void hoverFilm(){
		mouseHover(film(), LONGWAIT);
	}
	
	public void hoverTV(){
		mouseHover(tv(), LONGWAIT);
	}
	
	public void hoverMusic(){
		mouseHover(music(), LONGWAIT);
	}
	
	public boolean verifyOverlay(){
		return isElementDisplayed(overlay());
	}
	
	public boolean verifyoverlayblockActive(int i) throws Exception{
		return driver.findElement(overlayList(i)).getAttribute("class").equals("block active");
	}
	
	public boolean verifyoverlayImages(int i){
		return isElementPresent(overlayImages(i));
	}
	
	public boolean verifySeeAlltopics(){
		return isElementPresent(seeAlltopics());
	}
	
	public People clickOnOverlayPeople(){
		safeClick(overlayPeople());
		return new People(driver);
	}
	
	public boolean verifyURL(String parseURL){
		return getCurrentURL().contains(parseURL);
	}
	
	
}
