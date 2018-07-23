package com.qa.testcase;

import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.util.DataDriven;



public class DataDrivenTest {
	String sheetName = "account";
	
	@DataProvider
	public Iterator<Object[]>getData(){
		ArrayList<Object[]> data = DataDriven.getDataFromExcel();
		return data.iterator();
	}
	@Test(dataProvider="getData")
	public void testData(String username, String password) throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "E:/Programs/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		  driver.get("https://www.w3schools.com/howto/howto_css_login_form.asp");
		  driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
		  
		  driver.findElement(By.xpath("//input[@class='w3-input w3-border w3-margin-bottom']")).sendKeys(username);
		  driver.findElement(By.xpath("//input[@class='w3-input w3-border']")).sendKeys(password);
		  driver.findElement(By.xpath("//button[@class='w3-button w3-block w3-green w3-section w3-padding']")).click();
		  driver.quit();
	}
	
}
