package com.bdd.webdriver_manager;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.bdd.constants.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
	
	private static final Logger LOGGER=LogManager.getLogger(DriverManager.class);
	
	private static WebDriver driver = null;
	
	public static void launchBrowser() {
		try {
			
			switch (Constants.BROWSER) {
			case "chrome":
				WebDriverManager.chromedriver().setup();
				LOGGER.info("Launching "+Constants.BROWSER);
				driver=new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
				break;
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				LOGGER.info("Launching "+Constants.BROWSER);
				driver=new FirefoxDriver();
				driver.manage().window().maximize();
				break;
			case "edge":
				WebDriverManager.edgedriver().setup();
				LOGGER.info("Launching "+Constants.BROWSER);
				driver=new EdgeDriver();
				driver.manage().window().maximize();
			default:
				WebDriverManager.chromedriver().setup();
				LOGGER.info("Launching "+Constants.BROWSER);
				driver=new ChromeDriver();
				driver.manage().window().maximize();
				break;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			}
	}

	public static WebDriver getDriver() {
		return driver;
	}
		
}
