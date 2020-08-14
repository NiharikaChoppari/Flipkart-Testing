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

	@Test(priority = 1)
	public void verifyUrl() {

		page.enterurl();
		Assert.assertTrue(page.logindisplayed(), "url is entered and login page displayed");
	}

	@Test(priority = 2)
	@Parameters({ "validUn", "validPwd" })
	public void validlogin(String validUn, String validPwd) throws InterruptedException {
		Thread.sleep(1000);
		page.enterun(validUn);
		page.enterpwd(validPwd);
		page.clickOnLogin();
		System.out.println("home page displayed");
		Thread.sleep(1000);
		Assert.assertTrue(page.homePageDisplayed(), "Home page not displayed");
		System.out.println("validlogin  successfull");

	}

	@Test(priority = 3)
	public void verifyMyAccountDisplayed() throws InterruptedException {
		Assert.assertTrue(page2.myAccountDisplayed(), "My Account not displayed");
		System.out.println("My account option is displayed");
	}

	@Test(priority = 4)
	public void verifySearchBoxAvailability() throws InterruptedException {
		Thread.sleep(1000);
		Assert.assertTrue(page2.searchBoxDisplayed(), "Search box not displayed");
		System.out.println("Search box is displayed ");
	}

	@Test(priority = 5)
	public void verifySearchBtnAvailability() {
		Assert.assertTrue(page2.searchBtnDisplayed(), "Search box not displayed");
		System.out.println("Search button is displayed");
	}

	@Test(priority = 6)
	public void verifyCartButtonDisplayed() {
		Assert.assertTrue(page2.cartDisplayed(), "Search box not displayed");
		System.out.println("cart button is displayed");
	}

	@Test(priority = 7)
	@Parameters({ "product" })
	public void verifyProductSearch(String product) throws InterruptedException {
		page2.enterProductName(product);
		System.out.println("Product name entered");
		page2.clickOnSearchBtn();
		Thread.sleep(2000);
		System.out.println(page2.productDisplayed());
		Assert.assertTrue(page2.productDisplayed(), "Product not displayed");
		System.out.println("Product displayed");

	}

	@Test(priority = 8)
	public void verifyProductDisplayed() {
		page2.togglingWindow();
		Assert.assertEquals(page2.productTitle, page2.productTitle(), "Expected and Actual title did not matched");
		System.out.println("Title of the product verified");
		Assert.assertEquals(page2.productprice, page2.productPrice(), "Expected and Actual price did not matched");
		System.out.println("Price of the product is verified");
	}

	@Test(priority = 9)
	public void verifyAddToCartBtnDisplayed() {
		Assert.assertTrue(page2.addToCartDisplayed(), "Add to cart button not displayed in the product page");
		System.out.println("Add to cart btn available");
	}

	@Test(priority = 10)
	public void verifyBuyNowBtnDisplayed() {
		Assert.assertTrue(page2.buyNowBtnDisplayed(), "Buy Now button not displayed in the product page");
		System.out.println("Buy Now btn available");
	}

	@Test(priority = 11)
	public void verifyAddToCart() {

		page2.clickAddToCart();

	}

	@Test(priority = 12)
	public void verifyRemoveFromCart() throws InterruptedException {
		Thread.sleep(1000);
		Assert.assertTrue(page2.removeDisplayed(), "Remove option not available");
		System.out.println("remove displayed clicked");
		page2.removeFromCart();
		Assert.assertEquals("Your cart is empty!", page2.cartMsg(),
				"Expected and Actual msg of empty cart did not matched");
		System.out.println("Product successfully removed from cart!");

	}

	@Test(priority = 13)
	public void verifylogout() throws InterruptedException {
		page2.logout();
		Thread.sleep(1000);
		Assert.assertTrue(page1.loginButtonDisplayed(), "Logout failed");
		System.out.println("Login and Logout Successful!!!");
	}

	@Test(priority = 14,enabled=false)
	public void verifyCloseBrowser() {
		page1.closeBrowser();
		System.out.println("Browser closed successfully!!!");
	}

	@Test(priority = 15,enabled=false)
	public void quit() {
		page1.quitBrowser();
	}

}