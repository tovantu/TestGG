package com.qa.testcases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

public class HomePageTest extends TestBase {
	HomePage homePage;
	LoginPage loginPage;
	
	public HomePageTest(){
		super();
	}
	
	@BeforeTest
	public void beforeTest(){
		setExtent();
	}
	@AfterTest
	public void AfterTest(){
		endReport();
	}

	@BeforeMethod
	
	public void setUp(){
		initialization();
		homePage = new HomePage();
	}
	@AfterMethod
	public void AfterMethod(ITestResult result) throws IOException{
		tearDown(result);
	}
	
	
	
	
	@Test(priority=1, groups="Homepage")
	public void pageTitleTest(){
		extentTest = extent.startTest("pageTitleTest");
		String title = homePage.validateHomePageTitle();
		Assert.assertEquals(title, "Googlea");
	}
//	@Test(priority=2, groups="Homepage")
//	public void buttonLonginTest(){
//		extentTest = extent.startTest("buttonLonginTest");
//		boolean button = homePage.singIn();
//		Assert.assertTrue(button);
//	}
//	@Test(priority=3, groups="Homepage")
//	public void lonin(){
//		extentTest = extent.startTest("lonin");
//		loginPage = homePage.Login();
//	}
	
	
	
}
