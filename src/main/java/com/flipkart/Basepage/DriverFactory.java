package com.flipkart.Basepage;

import org.openqa.selenium.WebDriver;

public class DriverFactory {

	public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	public static WebDriver getDriver() {
		return driver.get();
	}

	public static void setDriver(WebDriver driverParam) {
		driver.set(driverParam);
	}

	public void removeDriver() {
		driver.remove();
	}

}
