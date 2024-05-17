package com.bdd.step_definitions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.bdd.constants.Constants;
import com.bdd.page_objects.LoginPage;
import com.bdd.utilities.CommonUtils;
import com.bdd.webdriver_manager.DriverManager;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Common_Step_Definition {
	
	private static String scenarioName=null;
	
	public static String getScenarioName() {
		return scenarioName;
	}

	
	
	private static final Logger LOGGER=LogManager.getLogger(Common_Step_Definition.class);
	
	@Before
	public void beforeScenario(Scenario scenario) {
		LOGGER.info("Execution Started");
		
		try {
			scenarioName = scenario.getName();
			
			LOGGER.info("Instantiating the CommonUtils");
			
			LOGGER.info("Loading the properties file");
			CommonUtils.getInstance().loadProperties();
			LOGGER.info("Checking the driver is Null or Not");
			if(DriverManager.getDriver()==null) {
			LOGGER.info("Driver is NULL.Instantiating it!");
			DriverManager.launchBrowser();
			CommonUtils.getInstance().initWebElements();
			login();
			}
		} 
		catch (Exception e) {
			LOGGER.error(e);
			CommonUtils.getInstance().takesScreenshot();
			}
		}

	private void login() {
		DriverManager.getDriver().get(Constants.APP_URL);

		LoginPage.getInstance().enterUserName(Constants.UserName);

		LoginPage.getInstance().enterPassword(Constants.Password);

		LoginPage.getInstance().clickLoginButton();
		
	}
	
	@AfterStep
	public void attachScreenshot(Scenario scenario) {
		if(scenario.isFailed()) {
			byte[] screenshotTaken=((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
			
			scenario.attach(screenshotTaken, "image/png", "error screen");
		}
		
	}

}
