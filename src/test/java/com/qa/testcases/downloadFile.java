package com.qa.testcases;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class downloadFile {
	
	WebDriver driver;
	File folder;
	
	@BeforeMethod
	//SetUp
	public void setUp(){
		folder = new File(UUID.randomUUID().toString());
		folder.mkdir();
		
		//Firefox
		
//		System.setProperty("webdriver.gecko.driver", "E:/Programs/Selenium-java/geckodriver-v0.20.1-win64/geckodriver.exe");
//		
//		FirefoxProfile profile = new FirefoxProfile();
//		profile.setPreference("browser.download.dir",folder.getAbsolutePath());
//		profile.setPreference("browser.download.folderList", 2);
//		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "image/jpeg,application/pdf,application/octet-stream");
//		profile.setPreference("pdfjs.disabled", true);
//		
//		driver = new FirefoxDriver();
		
		
		//Chrome
		
		System.setProperty("webdriver.chrome.driver", "E:/Programs/chromedriver_win32/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_settings.popups", 0);
		prefs.put("download.default_directory", folder.getAbsolutePath());
		
		options.setExperimentalOption("prefs", prefs);
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setCapability(ChromeOptions.CAPABILITY, options);
		
		driver = new ChromeDriver(cap);
	}
	//DownLoad
	@Test
	public void downloadTest() throws InterruptedException{
		driver.get("http://the-internet.herokuapp.com/download");
		driver.findElement(By.xpath("//div[@class='example']//a[contains(text(),'Picture')]")).click();
		Thread.sleep(3000);
		File listOfFiles[] = folder.listFiles();
		Assert.assertTrue(listOfFiles.length>0);
		
		for(File file : listOfFiles){
			Assert.assertTrue(file.length()>0);
			
		}
		
	}
	//end
	@AfterMethod
	public void tearDown(){
		driver.quit();
		for(File file : folder.listFiles()){
			file.delete();
		}
		folder.delete();
	}
}
