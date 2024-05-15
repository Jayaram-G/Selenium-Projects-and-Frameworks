package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class User_Role_Page_Objects {
	public User_Role_Page_Objects(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//span[.='Admin']")
	public static WebElement adminLink;
	
	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[1]/span")
	public static WebElement userManagementLink;
	
	@FindBy(linkText = "Users")
	public static WebElement usersLink;
	
	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input")
	public static WebElement userNameTextField;
	
	@FindBy(xpath = "//div[.='Enabled']/div")
	public static WebElement userStatus;
	
	@FindBy(xpath = "//button[.=' Search ']")
	public static WebElement searchBtn;
	
	
}
