package com.kwd.actionKeywords;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.kwd.constants.Constants;
import com.kwd.executionCore.Engine;
import com.kwd.utilities.ExcelUtilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionKeywords {
	static WebDriver driver;
	//openBrowser()
	public static void openBrowser() {
		
		switch (ExcelUtilities.dataColumnValue) {
		case Constants.CHROME:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case Constants.FIREFOX:
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case Constants.EDGE:
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		default:
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;
		}
	}
	//goToUrl()
	public static void goToURL() {
		driver.get(ExcelUtilities.dataColumnValue);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	//enterUserName()
	public static void enterUserName() {
		WebElement userName = driver.findElement(Engine.locator);
		userName.sendKeys(ExcelUtilities.dataColumnValue);
	}
	//enterPassword()
	public static void enterPassword() {
		WebElement password = driver.findElement(Engine.locator);
		password.sendKeys(ExcelUtilities.dataColumnValue);
	}
	//clickLogin()
	public static void click() {
		WebElement button = driver.findElement(Engine.locator);
		button.click();
	}
	
	public static void selectJobTitleDropdown() {
		WebElement dropDown=driver.findElement(Engine.locator);
		dropDown.click();
	}
	
	public static void selectQALead() {
		WebElement selectQALead = driver.findElement(Engine.locator);
		selectQALead.click();
	}
	
	
}
