package stepDefinitions;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class OrangeHRM_DataTableWithExample {
	WebDriver driver;
	
	@Given("Proceed to login page")
	public void proceed_to_login_page() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	
	}
	@When("user enters {string} and {string}")
	public void user_enters_and(String userName, String password) {
		driver.findElement(By.cssSelector("[name='username']")).sendKeys(userName);
	    driver.findElement(By.cssSelector("[name='password']")).sendKeys(password);
		
	}
	@When("clicked button")
	public void clicked_button() {
		 driver.findElement(By.xpath("//button[.=' Login ']")).click();
	}
}
