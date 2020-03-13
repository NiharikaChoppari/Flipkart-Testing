package com.flipkart.loginModule;

import org.testng.Assert;
import org.testng.annotations.Test;
public class LoginTest

{
	
	LoginPage page = new LoginPage();
	
	@Test(priority=1)
	public void verifyUrl() {
		
		page.enterurl("https://www.flipkart.com/");
		Assert.assertTrue(page.logindispplayed(),"url is entered and login page displayed");

	}
	
	@Test(priority=2)
	public void verifyLoginWithOnlyUn() throws InterruptedException {

		page.enterun("7799179650");
		page.clickOnLogin();
		Assert.assertTrue(page.enterPasswordMsg(), "Password Error message not displayed");
		Assert.assertEquals( "Please enter Password",
				page.errorMessageContent(),"Expected and Actual message did not matched");
		page.clear("username");
		page.deleteCookies();
		Thread.sleep(1000);
		page.enterpwd("Cn012345678");
		System.out.println("verifyLoginWithOnlyUn execution successfull");
		
	}


	@Test(priority=3)
	public void verifyLoginWithOnlyPwd() throws InterruptedException {
		
		page.enterpwd("Cn012345678");
		page.clickOnLogin();
		Assert.assertTrue(page.errorMessageDisplayed(), "Error message not displayed");
		Assert.assertEquals( "Please enter valid Email ID/Mobile number",
				page.errorMessageContent(),"Expected and Actual message did not matched");
		page.clear("Cn012345678");
		page.deleteCookies();
		Thread.sleep(1000);
		System.out.println("verifyLoginWithOnlyPwd execution successfull");
	}

	
	@Test(priority=4)
	public void invalidUnandValidPwd() throws InterruptedException {

		
		page.enterun("779917965");
		page.enterpwd("Cn012345678");
		page.clickOnLogin();
		Assert.assertTrue(page.errorMessageDisplayed(), "Error message not displayed");
		Assert.assertEquals("Please enter valid Email ID/Mobile number", page.errorMessageContent(),"Expected and Actual message did not matched");
		page.clear("username");
		page.clear("Cn012345678");
		page.deleteCookies();
		System.out.println("invalidUnandValidPwd execution successfull");
		
	}


	@Test(priority=5)
	public void validUnandInvalidPwd() throws InterruptedException {

		page.enterun("7799179650");
		page.enterpwd("Cn01234567");
		page.clickOnLogin();
		Assert.assertTrue(page.errorMessageDisplayed(), "Error message not displayed");
		Assert.assertEquals( "Your username or password is incorrect",
				page.errorMessageContent(),"Expected and Actual message did not matched");
		page.clear("username");
		page.clear("Cn01234567");
		page.deleteCookies();
		System.out.println("validUnandInvalidPwd execution successfull");
		
		
	
}
	
	@Test(priority=6)
	public void invalidUnandInvalidPwd() throws InterruptedException {

		

		page.enterun("779917965");
		page.enterpwd("Cn01234567");
		page.clickOnLogin();
		Assert.assertTrue(page.errorMessageDisplayed(), "Error message not displayed");
		Assert.assertEquals( "Please enter valid Email ID/Mobile number",
				page.errorMessageContent(),"Expected and Actual message did not matched");
		page.clear("username");
		page.clear("Cn01234567");
		page.deleteCookies();
		System.out.println("invalidUnandInvalidPwd execution successfull");
		
	}
	
	@Test(priority=7)
	public void validlogin() throws InterruptedException {
		
		page.enterun("7799179650");
		page.enterpwd("Cn012345678");
		page.clickOnLogin();
		System.out.println("home page displayed");
		Assert.assertTrue(page.homePageDisplayed(), "Home page not displayed");
		System.out.println("validlogin execution successfull");
		
	}	
	@Test(priority=8)
	public void verifylogout()
	{
		Assert.assertTrue(page.homePageDisplayed(), "Logout failed");
		System.out.println("Login and Logout Successful!!!");
	}

	@Test(priority=9)
	public void verifyCloseBrowser()
	{
		page.closeBrowser();
		System.out.println("Browser closed successfully!!!");
	}
	

	}