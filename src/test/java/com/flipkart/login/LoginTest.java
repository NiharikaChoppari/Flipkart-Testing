package com.flipkart.login;

import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest

{
	static LoginPage page;

	public void verifyUrl(String url) {
		page.enterurl(url);
		Assert.assertTrue("url is entered and login page displayed", page.logindispplayed());

	}

	public void invalidUnandValidPwd(String un, String pwd) throws InterruptedException {

		page.enterun(un);
		page.enterpwd(pwd);
		page.clickOnLogin();
		Assert.assertTrue("Error message not displayed", page.errorMessageDisplayed());
		Assert.assertEquals("Expected and Actual message did not matched", "Please enter valid Email ID/Mobile number",
				page.errorMessageContent());
		page.refresh();
	}

	public void validUnandInvalidPwd(String un, String pwd) throws InterruptedException {

		page.enterun(un);
		page.enterpwd(pwd);
		page.clickOnLogin();
		Assert.assertTrue("Error message not displayed", page.errorMessageDisplayed());
		Assert.assertEquals("Expected and Actual message did not matched", "Your username or password is incorrect",
				page.errorMessageContent());
		page.refresh();
	}

	public void invalidUnandInvalidPwd(String un, String pwd) throws InterruptedException {

		page.enterun(un);
		page.enterpwd(pwd);
		page.clickOnLogin();
		Assert.assertTrue("Error message not displayed", page.errorMessageDisplayed());
		Assert.assertEquals("Expected and Actual message did not matched", "Your username or password is incorrect",
				page.errorMessageContent());
		page.refresh();
	}

	public void verifyLoginWithOnlyUn(String un) throws InterruptedException {

		page.enterun(un);
		page.clickOnLogin();
		Assert.assertTrue("Password Error message not displayed", page.enterPasswordMsg());
		Assert.assertEquals("Expected and Actual message did not matched", "Please enter Password",
				page.errorMessageContent());
		page.refresh();
	}

	public void verifyLoginWithOnlyPwd(String pwd) {

		page.enterpwd(pwd);
		page.clickOnLogin();
		Assert.assertTrue("Error message not displayed", page.errorMessageDisplayed());
		Assert.assertEquals("Expected and Actual message did not matched", "Please enter valid Email ID/Mobile number",
				page.errorMessageContent());
		page.refresh();
	}

	public void validlogin(String un, String pwd) throws InterruptedException {
		page.enterun(un);
		page.enterpwd(pwd);
		page.clickOnLogin();
		System.out.println("home page displayed");
		Assert.assertTrue("Home page not displayed", page.homePageDisplayed());
		System.out.println("Login successful!!!!");
		page.refresh();

	}

	public static void main(String[] args) throws InterruptedException {

		page = new LoginPage();
		LoginTest ob = new LoginTest();
		ob.verifyUrl("https://www.flipkart.com/");
		ob.invalidUnandValidPwd("986682599", "Cn012345678");
		ob.validUnandInvalidPwd("9866825999", "Cn01234567");
		ob.invalidUnandInvalidPwd("9866825999", "Cn01234567");
		ob.verifyLoginWithOnlyUn("9866825999");
		ob.verifyLoginWithOnlyPwd("Cn012345678");
		ob.validlogin("9866825999", "Cn012345678");
		page.logout();
		page.closeBrowser();

	}
}