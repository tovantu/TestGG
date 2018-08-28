package com.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class multipeBrowser {
	WebDriver driver;
	@BeforeTest
	@Parameters("browser")
	public void beforeTest(String browser){
	
	
	if(browser.equals("chrome")){
		System.setProperty("webdriver.chrome.driver", "E:/Programs/chromedriver_win32/chromedriver.exe");
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("window-size=1400,800");
//		options.addArguments("headless");
		driver = new ChromeDriver();
	}else if(browser.equals("firefox")){
		System.setProperty("webdriver.gecko.driver", "E:/Programs/Selenium-java/geckodriver-v0.20.1-win64/geckodriver.exe");
		driver = new FirefoxDriver();
	}
	}
	@Test(priority=2)
	public void test(){
		driver.get("http://google.com");
		driver.quit();
	}
		
}
