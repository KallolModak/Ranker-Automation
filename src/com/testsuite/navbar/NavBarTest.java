package com.testsuite.navbar;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.base.BaseSetup;
import com.dataprovider.ConfigManager;
import com.paeobjects.navbar.NavBar;
import com.paeobjects.navbar.New;
import com.pageobject.login.AuthLoginPage;

public class NavBarTest extends BaseSetup{

	ConfigManager config=new ConfigManager();
	
	@BeforeClass
	public void classSetUp(){
		AuthLoginPage authlpg=new AuthLoginPage(getDriver());
		getDriver().get(new ConfigManager().getProperty("Url"));
		authlpg.enterCredentels("rankeRtesT", "r@nk3r!");
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
}