package com.testCases;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.Utilities.LogEntry;
import com.Utilities.Util;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;
import com.pageObject.MobilePage;

public class MobileTest extends BaseTest{
	
	@Test
	public void mobilePageTest() {
		
		MobilePage mp = PageFactory.initElements(driver, MobilePage.class);
		
		Util ut = new Util();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		ut.verifyPageTitle("Amazon.in : Samsung Galaxy M04 Light Green");
		LogEntry.log("Verifying Page Title");
		ExtentTestManager.getTest().log(Status.PASS, "Verifying Page Title");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		ExtentTestManager.getTest().log(Status.PASS, "Page Loading");
		
		js.executeScript("window.scrollBy(0,250)", "");
		LogEntry.log("Scrolling down");
		ExtentTestManager.getTest().log(Status.PASS, "Scrolling down");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		ExtentTestManager.getTest().log(Status.PASS, "Page Loading");
		
		mp.clickOnMobile();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		ExtentTestManager.getTest().log(Status.PASS, "Page Loading");
		
		ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(newTb.get(1));
		LogEntry.log("switched to Tab(1)");
		ExtentTestManager.getTest().log(Status.PASS, "Switched to Tab(1)");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		ExtentTestManager.getTest().log(Status.PASS, "Page Loading");
		
		js.executeScript("window.scrollBy(0,250)", "");
		LogEntry.log("scrolling down");
		ExtentTestManager.getTest().log(Status.PASS, "Scrolling down");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		ExtentTestManager.getTest().log(Status.PASS, "Page Loading");
		
//		ut.scrollToValue(250);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		mp.clickOnBuyNowBtn();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		ExtentTestManager.getTest().log(Status.PASS, "Page Loading");
	}
}
