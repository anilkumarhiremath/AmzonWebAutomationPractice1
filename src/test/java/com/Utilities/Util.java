package com.Utilities;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.testCases.BaseTest;

public class Util extends BaseTest{
	
	public void verifyPageTitle(String actualTitle) {
		String expectingTitle = driver.getTitle();
//		System.out.println("expectingTitle : "+expectingTitle);
		Assert.assertEquals(expectingTitle, actualTitle);
	}
	
	public void scrollToElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeAsyncScript("arguments[0].scrollToView();", element);
	}
	
	public void waitInSeconds(int seconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}
	
	public void scrollToValue(int value) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,value)", "");
	}
}
