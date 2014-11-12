package com.paeobjects.navbar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.paeobjects.home.Commonpage;
import com.pageobject.search.SearchRanker;

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
	
	private By overlayFilm(){
		return By.xpath("//ul[@class='float relative lowercase main']//a[text()=' Film']");
	}
	
	private By overlayTv(){
		return By.xpath("//ul[@class='float relative lowercase main']//a[text()=' TV']");
	}
	
	private By overlayMusic(){
		return By.xpath("//ul[@class='float relative lowercase main']//a[text()=' Music']");
	}
	
	private By overlaySports(){
		return By.xpath("//ul[@class='float relative lowercase main']//a[text()=' Sports']");
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
	
	private By sports(){
		return By.id("nav_sports");
	}
	
	private By videos(){
		return By.xpath("//nav[@id='siteNav']/ul/li[7]/a");
	}
	
	private By more(){
		return By.id("nav_more");
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
	
	private By cctLinks(){
		return By.xpath("//div[@id='siteNavMoreSub']//a");
	}
	
	private By faq(){
		return By.xpath("//span[text()=' frequently asked questions']");
	}
	
	private By contactUs(){
		return By.xpath("//span[text()=' contact us']");
	}
	
	private By forms(){
		return By.xpath("//span[text()=' forums']");
	}
	
	private By topRankers(){
		return By.xpath("//span[text()=' top rankers']");
	}
	
	private By listopedia(){
		return By.xpath("//span[text()=' listopedia']");
	}
	
	private By embedList(){
		return By.xpath("//span[text()=' embed a list']");
	}
	
	private By searchBtn(){
		return By.xpath("//span[@class='relative block icon search grey']");
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
	
	public Film clickOnFilim(){
		safeClick(film(), LONGWAIT);
		return new Film(driver);
	}
	
	public TV clickOnTV(){
		safeClick(tv(), LONGWAIT);
		return new TV(driver);
	}
	
	public Music clickOnMusic(){
		safeClick(music(), LONGWAIT);
		return new Music(driver);
	}
	
	public Sports clickOnSports(){
		safeClick(sports(),LONGWAIT);
		return new Sports(driver);
	}
	
	public void hoverTV(){
		mouseHover(tv(), LONGWAIT);
	}
	
	public void hoverMusic(){
		mouseHover(music(), LONGWAIT);
	}
	public void hoverSports(){
		mouseHover(sports(), MEDIUMWAIT);
	}
	
	public void hoverVideos(){
		mouseHover(videos(), MEDIUMWAIT);
	}
	
	public void hoverMore(){
		mouseHover(more(), MEDIUMWAIT);
	}
	
	public boolean verifyMoreOverlay(){
		return driver.findElement(more()).getAttribute("class").equals("block active");
	}
	
	public boolean verifyOverlay(){
		return isElementDisplayed(overlay());
	}
	
	public boolean verifyoverlayblockActive(int i){
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
	
	public Film clickOnOverlayFilm(){
		safeClick(overlayFilm());
		return new Film(driver);
	}
	
	public Videos clickOnVideos(){
		safeClick(videos());
		return new Videos(driver);
	}
	
	public More clickOnMore(){
		safeClick(more());
		return new More(driver);
	}
	
	public TV clickOnOverlayTv(){
		safeClick(overlayTv());
		return new TV(driver);
	}
	
	public Music clickOnOverlayMusic(){
		safeClick(overlayMusic());
		return new Music(driver);
	}
	
	public Sports clickOnOverlaySports(){
		safeClick(overlaySports());
		return new Sports(driver);
	}
	
	public boolean verifyURL(String parseURL){
		return getCurrentURL().contains(parseURL);
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
	
	public int cctlinksCount(){
		return driver.findElements(cctLinks()).size();
	}
	
	public boolean verifyFAQPresent(){
		return isElementPresent(faq());
	}
	
	public boolean verifyContactus(){
		return isElementPresent(contactUs());
	}
	
	public boolean verifyForms(){
		return isElementPresent(forms());
	}
	
	public boolean verifyTopRankers(){
		return isElementPresent(topRankers());
	}
	
	public boolean verifylistopedia(){
		return isElementPresent(listopedia());
	}
	
	public boolean verifyembedList(){
		return isElementPresent(embedList());
	}
	
	public SearchRanker clickOnsearch(){
		safeClick(searchBtn());
		return new SearchRanker(driver);
	}
	
}
