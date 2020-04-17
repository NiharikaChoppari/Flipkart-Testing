package com.flipkart.Basepage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


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

}
