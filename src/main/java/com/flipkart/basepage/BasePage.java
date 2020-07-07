package com.flipkart.Basepage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class BasePage {
	
	public static WebDriver d;
	
	public BasePage() {

		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		d = new ChromeDriver();
		d.manage().window().maximize();
	}
}
