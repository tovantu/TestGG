package com.qa.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.util.TestUtil;

public class LoginPageTest extends TestBase {
	
	HomePage homepage;
	LoginPage loginPage;
//	TestUtil testUtil;
	
	public LoginPageTest(){
		super();
	}
	@BeforeMethod
	public void setup(){
		initialization();
//		testUtil = new TestUtil();
		homepage = new HomePage();
		loginPage = homepage.Login();
	}
	
	@Test(priority=1)
	public void verifyTitleTest(){
		String title = loginPage.verifyTitle();
		Assert.assertEquals(title, "Đăng nhập - Tài khoản Google", "Title page login not match");
	}
	@Test(priority=2)
	public void checkLinkNextTest(){
//		testUtil.switchToFrame();
		Assert.assertTrue(loginPage.checkbtnNext());;
	}
	
	@DataProvider
	public void getTestData(){
		
	}
	
	@AfterMethod
	public void after(){
		driver.quit();
	}
	
}
