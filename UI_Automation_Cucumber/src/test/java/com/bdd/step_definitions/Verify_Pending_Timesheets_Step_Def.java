package com.bdd.step_definitions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

import com.bdd.constants.Constants;
import com.bdd.page_objects.HomePage;
import com.bdd.page_objects.LoginPage;
import com.bdd.page_objects.TimeSheetPage;
import com.bdd.utilities.CommonUtils;
import com.bdd.webdriver_manager.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Verify_Pending_Timesheets_Step_Def {

	private static final Logger LOGGER=LogManager.getLogger();

	@Given("the user is on the homepage")
	public void the_user_is_on_the_homepage() {
		try { 
			
			String url=DriverManager.getDriver().getCurrentUrl();
			if(url.contains("dashboard")) {
				LOGGER.info("The user is on Homepage");
			}
		}
		catch(Exception e) {
			LOGGER.error(e);
			
		}
	}

	@And("the user clicks on the time option")
	public void the_user_clicks_on_the_time_option() {
		try {	
			HomePage.getInstance().clickTime();
			LOGGER.info("the user clicks on the time option");
		}
		catch(Exception e) {
			LOGGER.error(e);
			
		}
	}

	@And("the user enter the name as {string}")
	public void the_user_enter_the_name_as(String personName) {
		try {	
			TimeSheetPage.getInstance().enterEmployeeName(personName);
		}
		catch(Exception e) {
			LOGGER.error(e);
			
		}
	}

	@And("clicks the view button")
	public void clicks_the_view_button() {
		try {
			TimeSheetPage.getInstance().clickView();
			LOGGER.info("clicks the view button");
		}catch(Exception e) {
			LOGGER.error(e);
			
		}
	}

	@Then("the user should see the message as {string}")
	public void the_user_should_see_the_message_as(String expectedMessage) {
		try {	
			String actualMessage=TimeSheetPage.getInstance().getMessage();
			if(expectedMessage.equalsIgnoreCase(actualMessage)) {
				LOGGER.info("Expected message is seen");
			}
		}
		catch(Exception e) {
			LOGGER.error(e);
			
			Assert.fail(e.getMessage());
		}
	}

}


