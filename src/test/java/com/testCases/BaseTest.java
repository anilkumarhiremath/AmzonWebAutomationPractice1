package com.testCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.Utilities.LogEntry;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public static WebDriver driver;
	public Properties prop;
	
	public WebDriver getDriver() {
        return driver;
    }
	
	@BeforeSuite
	public void setUp() throws IOException {
		
//		WebDriverManager.chromedriver().setup();
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\102612\\Softwares\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		
		LogEntry.log("Opening the browser");
//		ExtentTestManager.getTest().log(Status.PASS, "Opening the browser");
		
		
		prop = new Properties();
		FileInputStream src = new FileInputStream("./Configuration/config.properties");
		prop.load(src);
		String Url = prop.getProperty("url");
		
		driver.navigate().to(Url);
		LogEntry.log("Navigating to the url : " + Url);
//		ExtentTestManager.getTest().log(Status.PASS, "Navigating to the url : " + Url);
		
	}
	
	@AfterSuite
	public void tearDown() {
		
		driver.quit();
		LogEntry.log("Browser closed");
		ExtentTestManager.getTest().log(Status.PASS, "Browser closed");
//		try {
//			Desktop.getDesktop().browse(new File("C:\\Users\\102612\\eclipse-workspace\\Amazon\\extent-reports\\extent-report.html").toURI());
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
}
