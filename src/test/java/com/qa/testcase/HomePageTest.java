package com.qa.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

public class HomePageTest extends TestBase {
	HomePage homePage;
	LoginPage loginPage;
	public HomePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		homePage = new HomePage();
	}
	@Test(priority=1)
	public void pageTitleTest(){
		String title = homePage.validateHomePageTitle();
		Assert.assertEquals(title, "Google");
	}
	@Test(priority=2)
	public void buttonLonginTest(){
		boolean button = homePage.singIn();
		Assert.assertTrue(button);
	}
	@Test(priority=3)
	public void lonin(){
		loginPage = homePage.Login();
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
