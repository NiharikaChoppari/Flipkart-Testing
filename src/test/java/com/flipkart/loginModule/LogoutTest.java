package com.flipkart.loginModule;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.flipkart.loginModule.LogoutPage;

public class LogoutTest {

	LogoutPage page1 = new LogoutPage();

	@Test(priority = 1)
	public void verifylogout() {
		try {
			page1.logout();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertTrue(page1.loginButtonDisplayed(), "Logout failed");
		System.out.println("Login and Logout Successful!!!");
	}

	@Test(priority = 2)
	public void verifyCloseBrowser() {
		page1.closeBrowser();
		System.out.println("Browser closed successfully!!!");
	}

	@Test(priority = 3)
	public void quit() {
		page1.quitBrowser();
	}
}
