package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page_Objects {
	public Login_Page_Objects(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css ="[name='username']")
	public static WebElement userName;
	
	@FindBy(css = "[name='password']")
	public static WebElement password;
	
	@FindBy(xpath = "//button[.=' Login ']")
	public static WebElement loginBtn;

}
