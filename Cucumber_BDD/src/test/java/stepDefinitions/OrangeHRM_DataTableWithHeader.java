package stepDefinitions;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class OrangeHRM_DataTableWithHeader {
	
	WebDriver driver;
	
	@Given("Go to the login page")
	public void go_to_the_login_page() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	   
	
	@When("enter the below credentials")
	public void enter_the_below_credentials(DataTable dataTable) {
		
	    List<Map<String, String>> keyValuePair = dataTable.asMaps(String.class,String.class);
		String userName = keyValuePair.get(0).get("username");
		String passWord = keyValuePair.get(0).get("password");
		
		driver.findElement(By.cssSelector("[name='username']")).sendKeys(userName);
	    driver.findElement(By.cssSelector("[name='password']")).sendKeys(passWord);
	}
	@When("click login button")
	public void click_login_button() {
		 driver.findElement(By.xpath("//button[.=' Login ']")).click();
	}

}
