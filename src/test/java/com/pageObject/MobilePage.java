package com.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Utilities.LogEntry;

public class MobilePage {
	
	WebDriver driver;
	
	public MobilePage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(xpath = "//div[@class='sg-col-inner']/following::span[contains(text(),'Samsung Galaxy M04 Light Green')][2]")
	WebElement samsungMobile;
	
	@FindBy(xpath = "//input[@id='buy-now-button']")
	WebElement buyBtn;
	
	public void clickOnMobile() {
		samsungMobile.click();
		LogEntry.log("clicked on "+samsungMobile.getText());
	}
	
	public void clickOnBuyNowBtn() {
		buyBtn.click();
		LogEntry.log("clicked on Buy Now");
	}
}
