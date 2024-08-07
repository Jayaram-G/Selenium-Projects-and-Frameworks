package com.kwd.executionCore;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.openqa.selenium.By;

import com.kwd.actionKeywords.ActionKeywords;
import com.kwd.constants.Constants;
import com.kwd.utilities.ExcelUtilities;
import com.kwd.utilities.Locators;

public class Engine {

	ActionKeywords actionKeywords;
	Method[] methods;
	
	public static By locator;
	public Engine() {

		actionKeywords= new ActionKeywords();
		methods=actionKeywords.getClass().getMethods();
	}


	public void executeKeywords() throws Exception {

		for(int i=0;i<methods.length;i++) {
			if(methods[i].getName().equalsIgnoreCase(ExcelUtilities.keywordColumnValue)) {
				methods[i].invoke(actionKeywords);
				break;
			}
		}
	}


	public void findWebElementsToBeUsed() {

		switch (ExcelUtilities.locatorName) {
		case Constants.ID:
			locator=Locators.getId(ExcelUtilities.locatorValue);
			break;
		case Constants.NAME:
			locator=Locators.getName(ExcelUtilities.locatorValue);
			break;
		case Constants.CLASS_NAME:
			locator=Locators.getClassName(ExcelUtilities.locatorValue);
			break;
		case Constants.TAG_NAME:
			locator=Locators.getTagName(ExcelUtilities.locatorValue);
			break;
		case Constants.CSS_SELECTOR:
			locator=Locators.getcssSelector(ExcelUtilities.locatorValue);
			break;
		case Constants.XPATH:
			locator=Locators.getXPath(ExcelUtilities.locatorValue);
			break;
		case Constants.LINK_TEXT:
			locator=Locators.getLinkText(ExcelUtilities.locatorValue);
			break;
		case Constants.PARTIAL_LINK_TEXT:
			locator=Locators.getPartialLinkText(ExcelUtilities.locatorValue);
			break;
		default:
			break;
		}

	}

	public static void main(String[] args) throws Exception {

		ExcelUtilities utilities = new ExcelUtilities();

		utilities.readExcelFile(Constants.EXCEL_LOCATION);

		Engine engine = new Engine();

		

		for(int row=1;row<=ExcelUtilities.totalRows;row++) {

			utilities.getLocatorsKeywordsAndData(row,Constants.LOCATOR_COLUMN,Constants.KEYWORD_COLUMN,Constants.DATA_COLUMN);

			engine.findWebElementsToBeUsed();

			engine.executeKeywords();

		}

	}

}
