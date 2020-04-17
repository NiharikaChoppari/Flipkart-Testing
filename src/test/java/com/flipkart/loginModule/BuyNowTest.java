package com.flipkart.loginModule;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BuyNowTest {
	BuyNowPage page4 = new BuyNowPage();

	LoginPage page = new LoginPage();
	LogoutPage page1 = new LogoutPage();
	AddToCartPage page2 = new AddToCartPage();

	@Test(priority = 1, enabled = false)
	public void verifyUrl() {

		page.enterurl();
		Assert.assertTrue(page.logindisplayed(), "url is entered and login page displayed");
	}

	@Test(priority = 3)
	public void verifyMyAccountDiplayed() throws InterruptedException {
		Assert.assertTrue(page2.myAccountDisplayed(), "My Account not displayed");
		System.out.println("My account option is displayed");
	}

	@Test(priority = 2)
	@Parameters({ "validUn", "validPwd" })
	public void validlogin(String validUn, String validPwd) throws InterruptedException {
		page4.login();
		page.enterun(validUn);
		page.enterpwd(validPwd);
		page.clickOnLogin();
		Thread.sleep(1000);
		System.out.println("home page displayed");
		Assert.assertTrue(page.homePageDisplayed(), "Home page not displayed");
		System.out.println("validlogin  successfull");

	}

	@Test(priority = 3, enabled = false)
	public void verifySearchBoxAvailability() {

		Assert.assertTrue(page2.searchBoxDisplayed(), "Search box not displayed");
		System.out.println("Search box is displayed ");
	}

	@Test(priority = 4, enabled = false)
	public void verifySearchBtnAvailability() {
		Assert.assertTrue(page2.searchBtnDisplayed(), "Search box not displayed");
		System.out.println("Search button is displayed");
	}

	@Test(priority = 5, enabled = false)
	public void verifyCartButtonDisplayed() {
		Assert.assertTrue(page2.cartDisplayed(), "Search box not displayed");
		System.out.println("cart button is displayed");
	}

	@Test(priority = 6)
	@Parameters({ "product" })
	public void verifyProductSearch(String product) {
		page2.enterProductName(product);
		page2.clickOnSearchBtn();
		Assert.assertTrue(page2.productDisplayed(), "Product not displayed");

	}

	@Test(priority = 7)
	public void verifyProductDisplayed() {
		page2.togglingWindow();
		Assert.assertEquals(page2.productTitle, page2.productTitle(), "Expected and Actual title did not matched");
		System.out.println("Title of the book verified");
		Assert.assertEquals(page2.productprice, page2.productPrice(), "Expected and Actual price did not matched");
		System.out.println("Price is verified");
	}

	@Test(priority = 8)
	public void verifyBuyNowBtnDisplay() {
		Assert.assertTrue(page4.buyNowBtnDisplayed(), "Buy Now btn not displayed");
		System.out.println("Buy now btn displayed");
		page4.clickBuyNowBtn();
	}

	@Test(priority = 9)
	public void verifyProductDisplay() {
		Assert.assertTrue(page4.productDisplayed(), "Product not displayed");
		System.out.println("Product displayed");
	}

	@Test(priority = 10)
	public void verifyProductprice() {
		Assert.assertTrue(page4.priceDisplayed(), "Expected and Actual price did not matched");
		System.out.println("Product price displayed");
	}

	@Test(priority = 11)
	public void removeProduct() {
		page4.clickOnRemove();
		Assert.assertTrue(page4.goToCartDisplayed(), "Expected and Actual price did not matched");
		page4.clickOnGoToCart();
	}

	@Test(priority = 12)
	public void verifyRemoveFromCart() throws InterruptedException {

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
		Assert.assertTrue(page1.loginButtonDisplayed(), "Logout failed");
		System.out.println("Login and Logout Successful!!!");
	}

	@Test(priority = 14)
	public void verifyCloseBrowser() {
		page1.closeBrowser();
		System.out.println("Browser closed successfully!!!");
	}

	@Test(priority = 15)
	public void quit() {
		page1.quitBrowser();
	}
}