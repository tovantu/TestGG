package com.qa.testcases;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class ScreenShotFullPage {
	@Test
	public void test() throws InterruptedException, IOException{
	System.setProperty("webdriver.chrome.driver", "E:/Programs/chromedriver_win32/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	
	 
    driver.get("http://xem.vn");
    Thread.sleep(2000);

    Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
    ImageIO.write(screenshot.getImage(),"PNG",new File(System.getProperty("user.dir") +"/FullPageScreenshot.png"));

    
	}
}
