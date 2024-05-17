package com.bdd.page_objects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.bdd.utilities.CommonUtils;

public class LoginPage {
	
	private static LoginPage loginInstance;
	private LoginPage() {
		
	}
	public static LoginPage getInstance() {
		
		if(loginInstance==null) {
			loginInstance=new LoginPage();
		}
		return loginInstance;
	}
	
	@FindBy(css = "[name='username']")
	private WebElement USERNAME;
	
	@FindBy(css = "[name='password']")
	private WebElement PASSWORD;
	
	@FindBy(xpath = "//button[.=' Login ']")
	private WebElement LOGIN_BUTTON;

//	public WebElement getUSERNAME() {
//		return USERNAME;
//	}
//
//	public WebElement getPASSWORD() {
//		return PASSWORD;
//	}
//
//	public WebElement getLOGIN_BUTTON() {
//		return LOGIN_BUTTON;
//	}
	
	public void enterUserName(String userName) {
		CommonUtils.getInstance().highlightElement(USERNAME);
		USERNAME.sendKeys(userName);
	}
	
	public void enterPassword(String password) {
		CommonUtils.getInstance().highlightElement(PASSWORD);
		PASSWORD.sendKeys(password);
	}
	
	public void clickLoginButton() {
		CommonUtils.getInstance().highlightElement(LOGIN_BUTTON);
		LOGIN_BUTTON.click();
	}
	
	
}
