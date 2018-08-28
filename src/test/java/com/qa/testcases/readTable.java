package com.qa.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.qa.util.Xls_Reader;

public class readTable {

	public static void main(String[] args) {


		System.setProperty("webdriver.chrome.driver", "E:/Programs/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		
		//*[@id="customers"]/tbody/tr[2]/td[1]
		
		String beforeXpath1 ="//*[@id='customers']/tbody/tr[";
		String afterXpath1 ="]/td[1]";
		String beforeXpath2 ="//*[@id='customers']/tbody/tr[";
		String afterXpath2 ="]/td[2]";
		String beforeXpath3 ="//*[@id='customers']/tbody/tr[";
		String afterXpath3 ="]/td[3]";
		
		List<WebElement> list = driver.findElements(By.xpath("//table[@id='customers']//tr"));
		Xls_Reader reader = new Xls_Reader("C:/Users/TuTo/Downloads/Programs/TestGG/src/main/java/com/qa/testdata/UserName.xlsx");
		
		if(!reader.isSheetExist("Data")){
			reader.addSheet("Data");
			reader.addColumn("Data", "companyName");
			reader.addColumn("Data", "contact");
			reader.addColumn("Data", "country");
		}		
		for(int i = 2; i <= list.size() ; i++){
			String actualXpath1 = beforeXpath1 +i+ afterXpath1;
			reader.setCellData("Data", "companyName", i, driver.findElement(By.xpath(actualXpath1)).getText());
			
			String actualXpath2 = beforeXpath2 +i+ afterXpath2;
			reader.setCellData("Data", "contact", i, driver.findElement(By.xpath(actualXpath2)).getText());
			
			String actualXpath3 = beforeXpath3 +i+ afterXpath3;
			reader.setCellData("Data", "country", i, driver.findElement(By.xpath(actualXpath3)).getText());
		}
		
		driver.quit();

	}

}
