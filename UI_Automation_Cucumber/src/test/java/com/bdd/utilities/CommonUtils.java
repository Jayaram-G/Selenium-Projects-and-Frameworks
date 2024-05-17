package com.bdd.utilities;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.bdd.constants.Constants;
import com.bdd.page_objects.DirectoryPage;
import com.bdd.page_objects.HomePage;
import com.bdd.page_objects.LoginPage;
import com.bdd.step_definitions.Common_Step_Definition;
import com.bdd.webdriver_manager.DriverManager;

public class CommonUtils {
	
	private static final Logger LOGGER=LogManager.getLogger(CommonUtils.getInstance());
	
	private static CommonUtils commonUtilsInstance=null;
	
	private CommonUtils() {
		
	}
	public static CommonUtils getInstance() {
		if(commonUtilsInstance==null) {
			commonUtilsInstance=new CommonUtils();
		}return commonUtilsInstance;
		
	}
	public void loadProperties() throws FileNotFoundException {
		
		Properties properties = new Properties();
		
		try {
			properties.load(getClass().getResourceAsStream("/config.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	Constants.APP_URL=properties.getProperty("APP_URL");
	Constants.BROWSER=properties.getProperty("BROWSER");
	Constants.UserName=properties.getProperty("UserName");
	Constants.Password=properties.getProperty("Password");
	Constants.CHROME_DRIVER_LOCATION=properties.getProperty("CHROME_DRIVER_LOCATION");
	Constants.FIREFOX_DRIVER_LOCATION=properties.getProperty("FIREFOX_DRIVER_LOCATION");
	Constants.EDGE_DRIVER_LOCATION=properties.getProperty("EDGE_DRIVER_LOCATION");
		
	}
	
	public void initWebElements() {
		PageFactory.initElements(DriverManager.getDriver(), LoginPage.getInstance());
		PageFactory.initElements(DriverManager.getDriver(), HomePage.getInstance());
		PageFactory.initElements(DriverManager.getDriver(), DirectoryPage.getInstance());
		
	}
	
	public void takesScreenshot() {
		File screenshot=((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(screenshot,new File(Common_Step_Definition.getScenarioName()+".png"));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void highlightElement(WebElement element) {
		JavascriptExecutor js =(JavascriptExecutor) DriverManager.getDriver();
		js.executeScript("arguments[0].setAttribute('style','border: 3px solid blue');",element);
	}
	
	
	public void selectFromDropDown(WebElement dropDown,String howTo,String value) {
		
		Select select = new Select(dropDown);
		
		switch (howTo) {
		case "index":
			select.selectByIndex(Integer.parseInt(value));
			break;
		case "value":
			select.selectByValue(value);
			break;
		case "text":
			select.selectByVisibleText(value);
			break;
		default:
			LOGGER.info("Please provide a valid selections.Valid selections are :text,value,index");
			break;
		}
	}
	
	
	

}
