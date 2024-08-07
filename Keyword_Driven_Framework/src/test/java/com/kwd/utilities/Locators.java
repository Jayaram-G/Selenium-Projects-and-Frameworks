package com.kwd.utilities;

import org.openqa.selenium.By;

public class Locators {
	
	public static By getId(String locatorValue) {
		
		return By.id(locatorValue);
	}
	
	public static By getName(String locatorValue) {
		
		return By.name(locatorValue);
	}
	
	public static By getClassName(String locatorValue) {
	
		return By.className(locatorValue);
	}
	
	public static  By getTagName(String locatorValue) {
		
		return By.tagName(locatorValue);
	}
	
	public static By getcssSelector(String locatorValue) {
		
		return By.cssSelector(locatorValue);
	}
	
	public static By getXPath(String locatorValue) {
		
		return By.xpath(locatorValue);
	}
	
	public static By getLinkText(String locatorValue) {
		
		return By.linkText(locatorValue);
	}
	
	public static By getPartialLinkText(String locatorValue) {
		
		return By.partialLinkText(locatorValue);
	}

}
