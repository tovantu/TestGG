package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class HomePage extends TestBase{

	@FindBy(id="lst-ib")
	WebElement inputSearch;
	
	@FindBy(xpath="//*[@id='gb_70']")
	WebElement signInBtn;
	
	//Initializing the page object
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	//Action
	public String validateHomePageTitle(){
		return driver.getTitle();
	}
	public boolean singIn(){
		return signInBtn.isDisplayed();
	}
	public LoginPage Login(){
		signInBtn.click();
		return new LoginPage();
	}
	
	
}
