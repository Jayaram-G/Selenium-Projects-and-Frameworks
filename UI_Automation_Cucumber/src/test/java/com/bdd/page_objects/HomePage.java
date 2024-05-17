package com.bdd.page_objects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.bdd.utilities.CommonUtils;

public class HomePage {
	
	private static HomePage homePageInstance;
	private HomePage() {
		
	}
	public static HomePage getInstance() {
		
		if(homePageInstance==null) {
			homePageInstance=new HomePage();
		}
		return homePageInstance;
	}
	
	
	@FindBy(linkText = "Directory")
	private WebElement DIRECTORY;
	
	@FindBy(linkText = "Time")
	private WebElement TIME;

//	public WebElement getDIRECTORY() {
//		return DIRECTORY;
//	}
	
	public void clickDirectory() {
		CommonUtils.getInstance().highlightElement(DIRECTORY);
		DIRECTORY.click();
	}
	
	public void clickTime() {
		CommonUtils.getInstance().highlightElement(TIME);
		TIME.click();
	}

}
