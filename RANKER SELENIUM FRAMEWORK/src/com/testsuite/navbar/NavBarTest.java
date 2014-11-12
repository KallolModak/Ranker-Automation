package com.testsuite.navbar;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseSetup;
import com.dataprovider.ConfigManager;
import com.paeobjects.navbar.Film;
import com.paeobjects.navbar.Music;
import com.paeobjects.navbar.NavBar;
import com.paeobjects.navbar.New;
import com.paeobjects.navbar.People;
import com.paeobjects.navbar.Sports;
import com.paeobjects.navbar.TV;
import com.paeobjects.navbar.Videos;
import com.pageobject.login.AuthLoginPage;
import com.pageobject.search.SearchRanker;

public class NavBarTest extends BaseSetup{

	ConfigManager config=new ConfigManager();
	
	@BeforeClass
	public void classSetUp(){
		
		AuthLoginPage authlpg=new AuthLoginPage(getDriver());
		getDriver().get(new ConfigManager().getProperty("Url"));
		authlpg.enterCredentels(config.getProperty("Authuname"), config.getProperty("Authpwd"));
		authlpg.clickSubmit();
	}
	@BeforeMethod
	public void beforeMethod(){
		if(!getDriver().getCurrentUrl().equals(new ConfigManager().getProperty("Url")))
		getDriver().get(new ConfigManager().getProperty("Url"));
	}
	@Test(priority=1)
	public void Ranker_logo(){
		NavBar navbar=new NavBar(getDriver());
		navbar.clickPeople();
		//verify logo
		Assert.assertTrue(navbar.verifyRankerLogo(),"Ranker logo");
		navbar.clickNew();
		//verifylogo
		Assert.assertTrue(navbar.verifyRankerLogo(),"Ranker logo");
	}
	
	@Test(priority=2)
	public void New_hoverandclick(){
		NavBar navbar=new NavBar(getDriver());
		navbar.hoverNew();
		Assert.assertFalse(navbar.verifyOverlay());
		New nw=navbar.clickNew();
		Assert.assertTrue(nw.verifyRecentListHeader());
	}
	
	@Test(priority=3)
	public void People_hover() throws Exception{
		NavBar navbar=new NavBar(getDriver());
		navbar.hoverPeople();
		//verify people
		Assert.assertTrue(navbar.verifyoverlayblockActive(1),"people");
		//verify images
		for(int i=1;i<=8;i++){
			Assert.assertTrue(navbar.verifyoverlayImages(i),"OverlayImage : "+i);
		}
		//verify see all topics link
		Assert.assertTrue(navbar.verifySeeAlltopics(), "See all topics");
	}
	
	@Test(priority=4)
	public void People_links() throws Exception{
		NavBar navbar=new NavBar(getDriver());
		People people=navbar.clickPeople();
//		verify people
		Assert.assertTrue(people.verifyPeopleHeader(),"people link");
		//verify people URLsssss
		navbar.hoverPeople();
		navbar.clickOnOverlayPeople();
		String url=config.getProperty("Url")+"list-of/people";
		Assert.assertEquals(getDriver().getCurrentUrl(),url,"people URL");
		
		//verify Tags
		navbar.hoverPeople();
		if(navbar.clickonTag()){
			Assert.assertTrue(navbar.verifyURL("tags"),"Veify tags");
		}
		
		//verify Class
		navbar.hoverPeople();
		if(navbar.clickonClass()){
			Assert.assertTrue(navbar.verifyURL("list"),"Veify classes");
		}
		
		//verify Category
		navbar.hoverPeople();
		if(navbar.clickonCateory()){
			Assert.assertTrue(navbar.verifyURL("list-of"),"Veify categories");
		}
		
		// verify see all people
		navbar.hoverPeople();
		people.clickOnSeeAllPeople();
		Assert.assertEquals(getDriver().getCurrentUrl(),url,"See all people URL");
		
		// verify all Ranker topics
		navbar.hoverPeople();
		navbar.clickOnAllRankerToics();
		url=config.getProperty("Url")+"all-categories";
		Assert.assertEquals(getDriver().getCurrentUrl(),url,"All ranker topics");
	}
	
	@Test(priority=5)
	public void Film_hover() throws Exception{
		NavBar navbar=new NavBar(getDriver());
		navbar.hoverFilm();
		//verify Film
		Assert.assertTrue(navbar.verifyoverlayblockActive(2),"film");
		//verify Film images
		for(int i=1;i<=8;i++){
			Assert.assertTrue(navbar.verifyoverlayImages(i),"OverlayImage : "+i);
		}
		//verify see all topics link
		Assert.assertTrue(navbar.verifySeeAlltopics(), "See all topics");
	}
	@Test(priority=6)
	public void TV_hover() throws Exception{
		NavBar navbar=new NavBar(getDriver());
		navbar.hoverTV();
		//verify TV
		Assert.assertTrue(navbar.verifyoverlayblockActive(3),"TV");
		//verify TV images
		for(int i=1;i<=8;i++){
			Assert.assertTrue(navbar.verifyoverlayImages(i),"OverlayImage : "+i);
		}
		//verify see all topics link
		Assert.assertTrue(navbar.verifySeeAlltopics(), "See all topics");
	}
	
	@Test(priority=7)
	public void Music_hover() throws Exception{
		NavBar navbar=new NavBar(getDriver());
		navbar.hoverMusic();
		//verify Music
		Assert.assertTrue(navbar.verifyoverlayblockActive(4),"Music");
		//verify Music images
		for(int i=1;i<=8;i++){
			Assert.assertTrue(navbar.verifyoverlayImages(i),"OverlayImage : "+i);
		}
		//verify see all topics link
		Assert.assertTrue(navbar.verifySeeAlltopics(), "See all topics");
	}
	
	@Test(priority=8)
	public void Sports_hover() throws Exception{
		NavBar navbar=new NavBar(getDriver());
		navbar.hoverSports();
		//verify Sports
		Assert.assertTrue(navbar.verifyoverlayblockActive(5),"Sports");
		//verify Sports images
		for(int i=1;i<=8;i++){
			Assert.assertTrue(navbar.verifyoverlayImages(i),"OverlayImage : "+i);
		}
		//verify see all topics link
		Assert.assertTrue(navbar.verifySeeAlltopics(), "See all topics");
	}
	
	@Test(priority=9)
	public void Film_links() throws Exception{
		NavBar navbar=new NavBar(getDriver());
		Film film=navbar.clickOnFilim();
//		verify film
		Assert.assertTrue(film.verifyFilmHeader(),"film link");
		//verify film URL
		navbar.hoverFilm();
		navbar.clickOnOverlayFilm();
		String url=config.getProperty("Url")+"list-of/film";
		Assert.assertEquals(getDriver().getCurrentUrl(),url,"film URL");
		
		//verify Tags
		navbar.hoverFilm();
		if(navbar.clickonTag()){
			Assert.assertTrue(navbar.verifyURL("tags"),"Verify tags");
		}
		
		//verify Class
		navbar.hoverFilm();
		if(navbar.clickonClass()){
			Assert.assertTrue(navbar.verifyURL("list"),"Verify classes");
		}
		
		//verify Category
		navbar.hoverFilm();
		if(navbar.clickonCateory()){
			Assert.assertTrue(navbar.verifyURL("list-of"),"Verify categories");
		}
		
		// verify see all film
		navbar.hoverFilm();
		film.clickOnSeeAllFilms();
		Assert.assertEquals(getDriver().getCurrentUrl(),url,"See all films URL");
		
		// verify all Ranker topics
		navbar.hoverFilm();
		navbar.clickOnAllRankerToics();
		url=config.getProperty("Url")+"all-categories";
		Assert.assertEquals(getDriver().getCurrentUrl(),url,"All ranker topics");
	}
	
	@Test(priority=10)
	public void TV_links() throws Exception{
		NavBar navbar=new NavBar(getDriver());
		TV tv=navbar.clickOnTV();
//		verify Tv
		Assert.assertTrue(tv.verifyTvHeader(),"tv link");
		//verify Tv URL
		navbar.hoverTV();
		navbar.clickOnOverlayTv();
		String url=config.getProperty("Url")+"list-of/tv";
		Assert.assertEquals(getDriver().getCurrentUrl(),url,"Tv URL");
		
		//verify Tags
		navbar.hoverTV();
		if(navbar.clickonTag()){
			Assert.assertTrue(navbar.verifyURL("tags"),"Verify tags");
		}
		
		//verify Class
		navbar.hoverTV();
		if(navbar.clickonClass()){
			Assert.assertTrue(navbar.verifyURL("list"),"Verify classes");
		}
		
		//verify Category
		navbar.hoverTV();
		if(navbar.clickonCateory()){
			Assert.assertTrue(navbar.verifyURL("list-of"),"Verify categories");
		}
		
		// verify see all tv
		navbar.hoverTV();
		tv.clickOnSeeAllTv();
		Assert.assertEquals(getDriver().getCurrentUrl(),url,"See all tv URL");
		
		// verify all Ranker topics
		navbar.hoverTV();
		navbar.clickOnAllRankerToics();
		url=config.getProperty("Url")+"all-categories";
		Assert.assertEquals(getDriver().getCurrentUrl(),url,"All ranker topics");
	}
	
	@Test(priority=11)
	public void Music_links() throws Exception{
		NavBar navbar=new NavBar(getDriver());
		Music music=navbar.clickOnMusic();
//		verify Music
		Assert.assertTrue(music.verifyMusicHeader(),"Music link");
		//verify Music URL
		navbar.hoverMusic();
		navbar.clickOnOverlayMusic();
		String url=config.getProperty("Url")+"list-of/music";
		Assert.assertEquals(getDriver().getCurrentUrl(),url,"Music URL");
		
		//verify Tags
		navbar.hoverMusic();
		if(navbar.clickonTag()){
			Assert.assertTrue(navbar.verifyURL("tags"),"Verify tags");
		}
		
		//verify Class
		navbar.hoverMusic();
		if(navbar.clickonClass()){
			Assert.assertTrue(navbar.verifyURL("list"),"Verify classes");
		}
		
		//verify Category
		navbar.hoverMusic();
		if(navbar.clickonCateory()){
			Assert.assertTrue(navbar.verifyURL("list-of"),"Verify categories");
		}
		
		// verify see all music
		navbar.hoverMusic();
		music.clickOnSeeAllMusic();
		Assert.assertEquals(getDriver().getCurrentUrl(),url,"See all Music URL");
		
		// verify all Ranker topics
		navbar.hoverMusic();
		navbar.clickOnAllRankerToics();
		url=config.getProperty("Url")+"all-categories";
		Assert.assertEquals(getDriver().getCurrentUrl(),url,"All ranker topics");
	}
	
	@Test(priority=12)
	public void Sports_links() throws Exception{
		NavBar navbar=new NavBar(getDriver());
		Sports sports=navbar.clickOnSports();
//		verify Sports
		Assert.assertTrue(sports.verifySportsHeader(),"Sports link");
		//verify Sorts URL
		navbar.hoverSports();
		navbar.clickOnOverlaySports();
		String url=config.getProperty("Url")+"list-of/sports";
		Assert.assertEquals(getDriver().getCurrentUrl(),url,"Sports URL");
		
		//verify Tags
		navbar.hoverSports();
		if(navbar.clickonTag()){
			Assert.assertTrue(navbar.verifyURL("tags"),"Verify tags");
		}
		
		//verify Class
		navbar.hoverSports();
		if(navbar.clickonClass()){
			Assert.assertTrue(navbar.verifyURL("list"),"Verify classes");
		}
		
		//verify Category
		navbar.hoverSports();
		if(navbar.clickonCateory()){
			Assert.assertTrue(navbar.verifyURL("list-of"),"Verify categories");
		}
		
		// verify see all sports
		navbar.hoverSports();
		sports.clickOnSeeAllSports();
		Assert.assertEquals(getDriver().getCurrentUrl(),url,"See all Music URL");
		
		// verify all Ranker topics
		navbar.hoverSports();
		navbar.clickOnAllRankerToics();
		url=config.getProperty("Url")+"all-categories";
		Assert.assertEquals(getDriver().getCurrentUrl(),url,"All ranker topics");
	}
	
	@Test(priority=13)
	public void Video_hover() throws Exception{
		NavBar navbar=new NavBar(getDriver());
		navbar.hoverVideos();
		
		Assert.assertFalse(navbar.verifyoverlayblockActive(4),"Video");
		//verify Video
		Videos videos=navbar.clickOnVideos();
		Assert.assertEquals(videos.getCurrentURL(),config.getProperty("Url")+"videos");
	}
	
	@Test(priority=14)
	public void More_hover() {
		NavBar navbar=new NavBar(getDriver());
		navbar.hoverMore();
		Assert.assertEquals(navbar.cctlinksCount(), 28, "category/class/tag links");
		Assert.assertTrue(navbar.verifySeeAlltopics(),"see all topics");
		Assert.assertTrue(navbar.verifyFAQPresent(),"Frequently asked questions");
		Assert.assertTrue(navbar.verifyContactus(),"Contact us");
		Assert.assertTrue(navbar.verifyForms(),"Forms");
		Assert.assertTrue(navbar.verifyTopRankers(),"Top Rankers");
		Assert.assertTrue(navbar.verifylistopedia(), "listopedia");
		Assert.assertTrue(navbar.verifyembedList(), "Embed List");
		Assert.assertTrue(navbar.verifyMoreOverlay(), "more");
	} 
	
//	@Test(priority=15)
	public void More_link() {
		NavBar navbar=new NavBar(getDriver());
		navbar.hoverMore();
		Assert.assertTrue(navbar.verifyoverlayblockActive(14),"more");
		Assert.assertEquals(navbar.cctlinksCount(), 28, "category/class/tag links");
		
		
	}
	
//	@Test(priority=16)
	public void SearchBar_emptysearch(){
		NavBar navbar=new NavBar(getDriver());
		SearchRanker search=navbar.clickOnsearch();
	}
	
}