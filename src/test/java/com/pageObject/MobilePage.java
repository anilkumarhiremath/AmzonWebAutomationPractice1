package com.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Utilities.LogEntry;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class MobilePage {
	
	WebDriver driver;
	
	public MobilePage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(xpath = "//div[@class='sg-col-inner']/following::span[contains(text(),'Samsung Galaxy M04 Light Green')][4]")
	WebElement samsungMobile;
	
	@FindBy(xpath = "//input[@id='buy-now-button']")
	WebElement buyBtn;
	
	public void clickOnMobile() {
		samsungMobile.click();
		LogEntry.log("clicked on "+samsungMobile.getText());
		ExtentTestManager.getTest().log(Status.PASS, "clicked on Samsung mobile");
	}
	
	public void clickOnBuyNowBtn() {
		buyBtn.click();
		LogEntry.log("clicked on Buy Now");
		ExtentTestManager.getTest().log(Status.PASS, "Clicked on Buy Now");
	}
}
