package com.flipkart.loginModule;

import org.testng.Assert;

import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.flipkart.Basepage.ListenerClass;
import com.flipkart.loginModule.LoginPage;
import com.flipkart.loginModule.LogoutPage;
@Listeners(ListenerClass.class)

public class LoginTest

{

	LoginPage page = new LoginPage();
	LogoutPage page1 = new LogoutPage();

	@Test(priority = 1)
	public void verifyUrl() {

		page.enterurl();
		Assert.assertTrue(page.logindisplayed(), "url is entered and login page displayed");

	}

	@Test(priority = 2)
	@Parameters({ "validUn" })
	public void verifyLoginWithOnlyUn(String validUn){

		page.enterun(validUn);
		page.clickOnLogin();
		Assert.assertTrue(page.enterPasswordMsg(), "Password Error message not displayed");
		Assert.assertEquals("Please enter Password", page.errorMessageContent(),
				"Expected and Actual message did not matched");
		page.clear("username");
		System.out.println("verifyLoginWithOnlyUn execution successfull");

	}

	@Test(priority = 3)
	@Parameters({ "validPwd" })
	public void verifyLoginWithOnlyPwd(String validPwd) {

		page.enterpwd(validPwd);
		page.clickOnLogin();
		Assert.assertTrue(page.errorMessageDisplayed(), "Error message not displayed");
		Assert.assertEquals("Please enter valid Email ID/Mobile number", page.errorMessageContent(),
				"Expected and Actual message did not matched");
		page.clear("password");
		System.out.println("verifyLoginWithOnlyPwd execution successfull");
	}

	@Test(priority = 4)
	@Parameters({ "invalidUn", "validPwd" })
	public void invalidUnandValidPwd(String invalidUn, String validPwd){

		page.enterun(invalidUn);
		page.enterpwd(validPwd);
		page.clickOnLogin();
		Assert.assertTrue(page.errorMessageDisplayed(), "Error message not displayed");
		Assert.assertEquals("Please enter valid Email ID/Mobile number", page.errorMessageContent(),
				"Expected and Actual message did not matched");
		page.clear("username");
		page.clear("password");
		System.out.println("invalidUnandValidPwd execution successfull");

	}

	@Test(priority = 5)
	@Parameters({ "validUn", "invalidPwd" })
	public void validUnandInvalidPwd(String validUn, String invalidPwd) throws InterruptedException{

		page.enterun(validUn);
		page.enterpwd(invalidPwd);
		page.clickOnLogin();
		Thread.sleep(1000);
		Assert.assertTrue(page.errorMessageDisplayed(), "Error message not displayed");
		Assert.assertEquals("Your username or password is incorrect", page.errorMessageContent(),
				"Expected and Actual message did not matched");
		page.clear("username");
		page.clear("password");
		System.out.println("validUnandInvalidPwd execution successfull");

	}

	@Test(priority = 6)
	@Parameters({ "invalidUn", "invalidPwd" })
	public void invalidUnandInvalidPwd(String invalidUn, String invalidPwd){

		page.enterun(invalidUn);
		page.enterpwd(invalidPwd);
		page.clickOnLogin();
		Assert.assertTrue(page.errorMessageDisplayed(), "Error message not displayed");
		Assert.assertEquals("Please enter valid Email ID/Mobile number", page.errorMessageContent(),
				"Expected and Actual message did not matched");
		page.clear("username");
		page.clear("password");
		System.out.println("invalidUnandInvalidPwd execution successfull");

	}

	@Test(priority = 7)
	@Parameters({ "validUn", "validPwd" })
	public void validlogin(String validUn, String validPwd) {

		page.enterun(validUn);
		page.enterpwd(validPwd);
		page.clickOnLogin();
		System.out.println("home page displayed");
		Assert.assertTrue(page.homePageDisplayed(), "Home page not displayed");
		System.out.println("validlogin execution successfull");

	}

	@Test(priority = 8)
	public void verifylogout() throws InterruptedException {
		page1.logout();
		Thread.sleep(1000);
		Assert.assertTrue(page1.loginButtonDisplayed(), "Logout failed");
		System.out.println("Login and Logout Successful!!!");
	}

	@Test(priority = 9)
	public void verifyCloseBrowser() {
		page1.closeBrowser();
		System.out.println("Browser closed successfully!!!");
	}

}