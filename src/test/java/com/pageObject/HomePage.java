package com.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Utilities.LogEntry;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;


public class HomePage {
	
	WebDriver driver;
	
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(xpath = "//input[@id='twotabsearchtextbox']")
	WebElement homeSearchBar;
	
	@FindBy(xpath = "//input[@id='nav-search-submit-button' and @type='submit']")
	WebElement homeSearchIcon;
	
	public void searchItem(String item) {
		LogEntry.log("Enter " +"\""+item +"\""+" in the seach feild");
		ExtentTestManager.getTest().log(Status.PASS, "Enter " +"\""+item +"\""+" in the seach feild");
		homeSearchBar.sendKeys(item);
	}
	
	public void clickOnHomeSearchIcon() {
		homeSearchIcon.click();
		LogEntry.log("clicked on seach icon");
		ExtentTestManager.getTest().log(Status.PASS, "clicked on seach icon");
	}
	
}
