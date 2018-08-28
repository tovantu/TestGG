package com.qa.testcases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.util.TestUtil;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

public class LoginPageTest extends TestBase {
	
	HomePage homepage;
	LoginPage loginPage;
//	TestUtil testUtil;
	
	public LoginPageTest(){
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
	public void setup(){
		initialization();
//		testUtil = new TestUtil();
		homepage = new HomePage();
		loginPage = homepage.Login();
		
		
	}
	
	@Test(priority=1, groups ="LoginPage")
	public void verifyTitleTest(){
		extentTest = extent.startTest("verifyTitleTest");
		String title = loginPage.verifyTitle();
		Assert.assertEquals(title, "Đăng nhập - Tài khoản Googlea", "Title page login not match");
	}
	@Test(priority=2, groups ="LoginPage")
	public void checkLinkNextTest(){
		extentTest = extent.startTest("checkLinkNextTest");
//		testUtil.switchToFrame();
		Assert.assertTrue(loginPage.checkbtnNext());;
		
	}
	
//	@DataProvider
//	public void getTestData(){
//		
//	}
	

	@AfterMethod
	public void AfterMethod(ITestResult result) throws IOException{
		tearDown(result);
		driver.quit();
	}
	
}
