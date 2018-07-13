package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class LoginPage extends TestBase {
	@FindBy(xpath="//*[@id='identifierNext']")
	WebElement btnNext;
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	public String verifyTitle(){
		return  driver.getTitle();
	}
	public boolean checkbtnNext(){
		return btnNext.isDisplayed();
	}
	
	
}
