package stepDefinitions;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class OrangeHRM_DataTableWithoutHeaderDef {
	WebDriver driver;
	
	@Given("^You are went to login page$")
	public void you_are_on_the_login_page() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	
	@When("^You enter the below credentials$")
	public void you_enter_the_below_credentials(DataTable dataTable) {
		
		String username = dataTable.cell(0,0);
		String password = dataTable.cell(0,1);
		
		driver.findElement(By.cssSelector("[name='username']")).sendKeys(username);
	    driver.findElement(By.cssSelector("[name='password']")).sendKeys(password);
	}
	
	@And("^clicks the login button$")
	public void click_the_login_button() {
		 driver.findElement(By.xpath("//button[.=' Login ']")).click();
	}
	
}
