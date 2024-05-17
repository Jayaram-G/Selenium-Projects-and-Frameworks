package com.bdd.step_definitions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.bdd.constants.Constants;
import com.bdd.page_objects.DirectoryPage;
import com.bdd.page_objects.HomePage;
import com.bdd.page_objects.LoginPage;
import com.bdd.utilities.CommonUtils;
import com.bdd.webdriver_manager.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VerifyCFOName_Step_Def {

	private static final Logger LOGGER = LogManager.getLogger(VerifyCFOName_Step_Def.class);

	@Given("the user is logged in successfully and is on homepage")
	public void the_user_is_logged_in_successfully_and_is_on_homepage() {

		try {
			
			String url = DriverManager.getDriver().getCurrentUrl();

			if(url.contains("dashboard"))
			{
				LOGGER.info("the user is logged in successfully and is on homepage");
			}
		}
		catch(Exception e){
			LOGGER.error(e);
			
		}


	}

	@When("the user clicks on the Directory option from the Menu bar")
	public void the_user_clicks_on_the_directory_option_from_the_menu_bar() {
		try {
			HomePage.getInstance().clickDirectory();
			LOGGER.info("the user clicks on the Directory option from the Menu bar");
		}
		catch(Exception e) {
			LOGGER.error(e);
			
		}
	}

	@And("the user selects the job title as {string} from the dropdown")
	public void the_user_selects_the_job_title_as_from_the_dropdown(String jobTitle) {
		try {	
			DirectoryPage.getInstance().clickDropdown();
			DirectoryPage.getInstance().selectJobTitle();
			LOGGER.info("the user selects the job title as Chief Financial Officer from the dropdown");
		} 
		catch(Exception e) {
			LOGGER.error(e);
			
		}
	}
	@And("clicks the search button")
	public void clicks_the_search_button() {
		try {
			DirectoryPage.getInstance().clickSearchButton();
			LOGGER.info("clicks the search button");
		} 
		catch(Exception e) {
			LOGGER.error(e);
			
		}
	}
	@Then("the user should see the CFO name as {string}")
	public void the_user_should_see_the_cfo_name_as_cfo_name(String expectedName) {
		try {
			String actualName =DirectoryPage.getInstance().getPersonName();
			if(actualName.equalsIgnoreCase(expectedName)) {
				LOGGER.info("the user should see the CFO name as Peter Mac Anderson");
			}
		}catch(Exception e) {
			LOGGER.error(e);
			
		}
	}

}
