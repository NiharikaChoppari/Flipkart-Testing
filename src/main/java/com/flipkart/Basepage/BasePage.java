package com.flipkart.Basepage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class BasePage {
	
	public static WebDriver d;
		
		public BasePage() {
			
			if(d == null) {
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				d = new ChromeDriver();
				d.manage().window().maximize();
				System.out.println("Initiating Chrome Driver");
				d.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				d.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
			} 
			/*else {
				System.out.println("Chrome driver already initiated.");
			} */
		}
	

	public void screenshot() throws IOException{
		
		TakesScreenshot sc=(TakesScreenshot)d;
		File f1=sc.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(f1, new File("./Screenshots/ResultScreenshot2.jpg"));
	}
	
}
	
	

