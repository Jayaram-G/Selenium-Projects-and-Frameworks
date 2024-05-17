package com.bdd.page_objects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.bdd.utilities.CommonUtils;

public class DirectoryPage {
	
	private static DirectoryPage directoryPageInstance;
	private DirectoryPage() {
		
	}
	public static DirectoryPage getInstance() {
		
		if(directoryPageInstance==null) {
			directoryPageInstance=new DirectoryPage();
		}
		return directoryPageInstance;
	}
	
	@FindBy(xpath = "(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[1]")
	public static WebElement DROPDOWN;
	
	@FindBy(xpath = "//*[contains(text(),'Chief Financial')]")
	private WebElement JOB_TITLE;
	
	@FindBy(xpath = "//button[.=' Search ']")
	private WebElement SEARCH;
	
	@FindBy(xpath = "//p[.='Chief Financial Officer']/../child::p[1]")
	private WebElement NAME;

//	public static WebElement getDROPDOWN() {
//		return DROPDOWN;
//	}
//
//	public WebElement getJOB_TITLE() {
//		return JOB_TITLE;
//	}
//
//	public WebElement getSEARCH() {
//		return SEARCH;
//	}
//
//	public WebElement getNAME() {
//		return NAME;
//	}
	
	public void clickDropdown() {
		CommonUtils.getInstance().highlightElement(DROPDOWN);
		DROPDOWN.click();
	}
	
	public void selectJobTitle() {
		CommonUtils.getInstance().highlightElement(JOB_TITLE);
		JOB_TITLE.click();
	}
	
	public void clickSearchButton() {
		CommonUtils.getInstance().highlightElement(SEARCH);
		SEARCH.click();
	}
	
	public String getPersonName() {
		return NAME.getText();
	}
	
	

}
