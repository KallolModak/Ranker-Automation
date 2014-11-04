package com.TestLogin;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseSetup;
import com.dataprovider.ConfigManager;
import com.pageobject.login.AuthLoginPage;
import com.pageobject.login.HomePage;
import com.pageobject.login.SigninPage;

public class Signin extends BaseSetup{

	
	SigninPage signpg;
	
	@BeforeMethod
	public void msthodSetup(){
		AuthLoginPage authlpg=new AuthLoginPage(getDriver());
		getDriver().get(new ConfigManager().getProperty("Url"));
		authlpg.enterCredentels("rankeRtesT", "r@nk3r!");
		signpg=authlpg.clickSubmit();
	}
	@Test(priority=1,groups={"smoke"})
	public void logInITest() throws Exception{
//		signpg=new SigninPage(getDriver());
//		Assert.assertTrue(signpg.verifyLoginPage(),"verify homepage");
		signpg.clickSignin();
		signpg.enterCredentels("rankeRtesT","r@nk3r!");
		HomePage hmpge=signpg.clickSubmit();
		//verify login
		}
}