package com.testCases;

import java.time.Duration;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.pageObject.HomePage;

public class HomeTest extends BaseTest{
	
	@Test
	public void homePageTest() {
		
		HomePage hp = PageFactory.initElements(driver, HomePage.class);
		hp.searchItem("Samsung Galaxy M04 Light Green");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		hp.clickOnHomeSearchIcon();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
	}
}
