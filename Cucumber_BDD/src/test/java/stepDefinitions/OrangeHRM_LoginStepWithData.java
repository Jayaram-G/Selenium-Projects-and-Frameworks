package stepDefinitions;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class OrangeHRM_LoginStepWithData {
	WebDriver driver;
	
	
	@Given("^user is on the login page$")
	public void user_is_on_the_login_page() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	 }
	
	@When("^the user enters the valid credentials \"(.*?)\" and \"(.*?)\"$")
	public void the_user_enters_the_valid_credentials_and(String username, String password) {
		driver.findElement(By.cssSelector("[name='username']")).sendKeys(username);
	    driver.findElement(By.cssSelector("[name='password']")).sendKeys(password);
	}
	
	@When("^click the login button$")
	public void click_the_login_button() {
		 driver.findElement(By.xpath("//button[.=' Login ']")).click();
	}
	
	@Then("^the user should see the home page$")
	public void the_user_should_see_the_home_page() {
		boolean status = driver.findElement(By.xpath("//h6")).isDisplayed();
		Assert.assertTrue(status);
	}



	

}
