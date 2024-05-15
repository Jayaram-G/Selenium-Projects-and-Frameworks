package testCases;
import org.apache.log4j.Logger;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import commonFunctions.CommonFunctions;
import pageObjects.User_Role_Page_Objects;

public class Test_User_Role extends CommonFunctions{
	
	Logger logger =Logger.getLogger(Test_User_Role.class);
	public void moveToUsersPage() {
		Actions actions = new Actions(driver);
		actions.moveToElement(User_Role_Page_Objects.adminLink).click().build().perform();
		actions.moveToElement(User_Role_Page_Objects.userManagementLink).click().build().perform();
		actions.moveToElement(User_Role_Page_Objects.usersLink).click().build().perform();
		}
	
	public void selectUserName() {
		User_Role_Page_Objects.userNameTextField.sendKeys("Admin");
		User_Role_Page_Objects.searchBtn.click();
	}
	
	@Test
	public void checkUserRoleStatus() {
		logger.info("Navigating to Users Page ");
		PageFactory.initElements(driver,User_Role_Page_Objects.class);
		moveToUsersPage();
		logger.info("Entering the user name");
		selectUserName();
		logger.info("Verifying the user status");
		String actualStatus = User_Role_Page_Objects.userStatus.getText();
		Assert.assertEquals(actualStatus,"Enabled");
		logger.info("End of Test_User_Role test case");
		
		}

}
