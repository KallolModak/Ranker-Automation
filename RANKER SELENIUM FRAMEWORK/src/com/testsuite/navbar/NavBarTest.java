package com.testsuite.navbar;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.base.BaseSetup;
import com.dataprovider.ConfigManager;
import com.paeobjects.navbar.NavBar;
import com.paeobjects.navbar.New;
import com.paeobjects.navbar.People;
import com.pageobject.login.AuthLoginPage;

public class NavBarTest extends BaseSetup{

	ConfigManager config=new ConfigManager();
	
	@BeforeClass
	public void classSetUp(){
		
		AuthLoginPage authlpg=new AuthLoginPage(getDriver());
		getDriver().get(new ConfigManager().getProperty("Url"));
		authlpg.enterCredentels(config.getProperty("Authuname"), config.getProperty("Authpwd"));
		authlpg.clickSubmit();
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
		String url=config.getProperty("Url")+"/list-of/people";
		Assert.assertEquals(getDriver().getCurrentUrl(),url,"people URL");
		
		//verify Tags
		navbar.hoverPeople();
		if(people.clickonTag()){
			Assert.assertTrue(navbar.verifyURL("tags"),"Veify tags");
		}
		
		//verify Class
		navbar.hoverPeople();
		if(people.clickonClass()){
			Assert.assertTrue(navbar.verifyURL("list"),"Veify classes");
		}
		
		//verify Category
		navbar.hoverPeople();
		if(people.clickonCateory()){
			Assert.assertTrue(navbar.verifyURL("list-of"),"Veify categories");
		}
		
		// verify see all people
		navbar.hoverPeople();
		people.clickOnSeeAllPeople();
		Assert.assertEquals(getDriver().getCurrentUrl(),url,"See all people URL");
		
		// verify all Ranker topics
		navbar.hoverPeople();
		people.clickOnAllRankerToics();
		url=config.getProperty("Url")+"/all-categories";
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
	
}