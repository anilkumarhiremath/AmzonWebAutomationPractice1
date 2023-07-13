package com.extentReports;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.testCases.BaseTest;

public class ExtentManager {
	public static final ExtentReports extentReports = new ExtentReports();
	static Properties properties = new Properties();
	static FileInputStream fis;
	static BaseTest baseTest = new BaseTest();
    public synchronized static ExtentReports createExtentReports() {

    	try {
			fis = new FileInputStream("./Configuration/config.properties");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	try {
			properties.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	String Url = properties.getProperty("url");
    	WebDriver driver = baseTest.getDriver();
    	Capabilities capabilities = ((RemoteWebDriver)driver).getCapabilities();
    	
        ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html");
        reporter.config().setReportName("Amazon Test Report");
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Browser", capabilities.getBrowserName()+" "+capabilities.getBrowserVersion());
        extentReports.setSystemInfo("OS", System.getProperty("os.name"));
        extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));
        extentReports.setSystemInfo("URL", Url);
        extentReports.setSystemInfo("Author", "Anilkumar");
        return extentReports;
    }
}
