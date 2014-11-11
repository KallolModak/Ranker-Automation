package com.paeobjects.navbar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.selenium.SafeActions;

public class Film extends SafeActions{
	private WebDriver driver;
	
	private By filmHeader(){
		return By.xpath("//h1[text()=' Film']");
	}
	
	private By seeAllFilms(){
		return By.xpath("//a[text()='see all  Film ']");
	}

	public Film(WebDriver driver){
		super(driver);
		this.driver=driver;
		try{Thread.sleep(3000);}catch (Exception e){}
	}	
	
	public boolean verifyFilmHeader(){
		return isElementPresent(filmHeader());
	}
	
	public void clickOnSeeAllFilms(){
		safeClick(seeAllFilms());
	}
}
