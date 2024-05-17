package com.bdd.page_objects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.bdd.utilities.CommonUtils;

public class TimeSheetPage {
	
	private static TimeSheetPage timeSheetInstance;
	private TimeSheetPage() {
		
	}
	public static TimeSheetPage getInstance() {
		if(timeSheetInstance==null) {
			timeSheetInstance=new TimeSheetPage();
		}
		return timeSheetInstance;
	}
	
	@FindBy(css = "(//input)[2]")
	private WebElement EMPLOYEE_NAME;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement VIEW;
	
	@FindBy(xpath = "(//p)[3]")
	private WebElement MESSAGE;
	
	public void enterEmployeeName(String name) {
		CommonUtils.getInstance().highlightElement(EMPLOYEE_NAME);
		EMPLOYEE_NAME.sendKeys(name);
	}
	
	public void clickView() {
		CommonUtils.getInstance().highlightElement(VIEW);
		VIEW.click();
	}
	
	public String getMessage() {
		return MESSAGE.getText();
	}
	
	
	
}
