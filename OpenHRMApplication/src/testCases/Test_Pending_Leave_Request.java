package testCases;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import commonFunctions.CommonFunctions;
import pageObjects.Dashboard_Page_Objects;
import pageObjects.Login_Page_Objects;

public class Test_Pending_Leave_Request extends CommonFunctions {
	String actulaMessage=null;
	
	static Logger logger = Logger.getLogger(Test_Pending_Leave_Request.class);
	
	public void login() {
		logger.info("Logging in to the application");
		PageFactory.initElements(driver,Login_Page_Objects.class);
		Login_Page_Objects.userName.sendKeys(properties.getProperty("username"));
		Login_Page_Objects.password.sendKeys(properties.getProperty("password"));
		Login_Page_Objects.loginBtn.click();
		}
	
	public void getPendingLeaveRequest() {
		PageFactory.initElements(driver,Dashboard_Page_Objects.class);
		actulaMessage = Dashboard_Page_Objects.pendingLeaveRequest.getText();
		
	}
	
	@Test
	public void verifyPendingLeaveRequests() {
		login();
		logger.info("Getting the Pending Leave Request Details ");
		getPendingLeaveRequest();
		logger.info("Verification");
		Assert.assertEquals(actulaMessage,"No Employees are on Leave Today");
		logger.info("End of Test_Pending_Leave_Request Test Case");
		
		
		
	}

}
