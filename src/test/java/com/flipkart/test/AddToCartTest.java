package com.flipkart.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.flipkart.pages.AddToCartPage;
import com.flipkart.pages.LoginPage;
import com.flipkart.pages.LogoutPage;

public class AddToCartTest {

	AddToCartPage page2;
	LoginPage page;
	LogoutPage page1;

	@BeforeClass
	void depedencies() {
		page2 = new AddToCartPage();
		page = new LoginPage();
		page1 = new LogoutPage();

	}

	@Test(priority = 1, enabled = false)
	public void verifyUrl() {

		page.enterurl();
		Assert.assertTrue(page.logindisplayed(), "url is entered and login page displayed");
	}

	@Test(priority = 2, enabled = false)
	@Parameters({ "validUn", "validPwd" })
	public void validlogin(String validUn, String validPwd) throws InterruptedException {
		page.enterun(validUn);
		page.enterpwd(validPwd);
		page.clickOnLogin();
		Thread.sleep(1000);
		Assert.assertTrue(page.homePageDisplayed(), "Home page not displayed");

	}

	@Test(priority = 3)
	public void verifyMyAccountDisplayed() throws InterruptedException {
		Assert.assertTrue(page2.myAccountDisplayed(), "My Account not displayed");
	}

	@Test(priority = 4)
	public void verifySearchBoxAvailability() throws InterruptedException {
		Thread.sleep(1000);
		Assert.assertTrue(page2.searchBoxDisplayed(), "Search box not displayed");
	}

	@Test(priority = 5)
	public void verifySearchBtnAvailability() {
		Assert.assertTrue(page2.searchBtnDisplayed(), "Search box not displayed");
	}

	@Test(priority = 6)
	public void verifyCartButtonDisplayed() {
		Assert.assertTrue(page2.cartDisplayed(), "Search box not displayed");
	}

	@Test(priority = 7)
	@Parameters({ "product" })
	public void verifyProductSearch(String product) throws InterruptedException {
		page2.enterProductName(product);
		page2.clickOnSearchBtn();
		Thread.sleep(2000);
		Assert.assertTrue(page2.productDisplayed(), "Product not displayed");

	}

	@Test(priority = 8)
	@Parameters({ "pincode" })
	public void verifyProductDisplayed(String pincode) throws InterruptedException {
		page2.togglingWindow();
		Thread.sleep(1000);
		Assert.assertEquals(page2.productTitle, page2.productTitle(), "Expected and Actual title did not matched");
		Assert.assertEquals(page2.productprice, page2.productPrice(), "Expected and Actual price did not matched");
		page2.checkProductAvailability(pincode);
	}

	@Test(priority = 9)
	public void verifyAddToCartBtnDisplayed() {
		Assert.assertTrue(page2.addToCartDisplayed(), "Add to cart button not displayed in the product page");

	}

	@Test(priority = 10)
	public void verifyBuyNowBtnDisplayed() {
		Assert.assertTrue(page2.buyNowBtnDisplayed(), "Buy Now button not displayed in the product page");

	}

	@Test(priority = 11)
	public void verifyAddToCart() {

		page2.clickAddToCart();

	}

	@Test(priority = 12)
	public void verifyRemoveFromCart() throws InterruptedException {
		Thread.sleep(2000);
		Assert.assertTrue(page2.removeDisplayed(), "Remove option not available");
		Thread.sleep(2000);
		page2.removeFromCart();
		Assert.assertEquals("Your cart is empty!", page2.cartMsg(),
				"Expected and Actual msg of empty cart did not matched");
	}

	@Test(priority = 13)
	public void verifylogout() throws InterruptedException {
		page2.logout();
		Thread.sleep(1000);
		Assert.assertTrue(page1.loginButtonDisplayed(), "Logout failed");
	}

	@Test(priority = 14)
	public void verifyCloseBrowser() {
		page1.closeBrowser();
	}

	@Test(priority = 15)
	public void quit() {
		page1.quitBrowser();
	}

}