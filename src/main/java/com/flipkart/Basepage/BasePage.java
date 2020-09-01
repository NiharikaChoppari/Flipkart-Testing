package com.flipkart.Basepage;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage extends Thread{

	public static WebDriver d;

	public static WebDriver getDriver(String browser) {
		if(d==null){
		if (browser.equalsIgnoreCase("Chrome")) {

			System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
			  d = new ChromeDriver();
			
		} else if (browser.equalsIgnoreCase("IE")) {

			System.setProperty("webdriver.ie.driver", "./Driver/IEDriverServer.exe");
			  d = new InternetExplorerDriver();
		} else if (browser.equalsIgnoreCase("Edge")) {

			System.setProperty("webdriver.edge.driver", "./Driver/msedgedriver.exe");
				d = new EdgeDriver();
		}
		}
		return d;
	}
	

	public void screenshot(String FailedTestName) throws IOException {

		TakesScreenshot sc = (TakesScreenshot) d;
		File f1 = sc.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(f1, new File("./Screenshots/" + FailedTestName + ".jpg"));
	}

}
