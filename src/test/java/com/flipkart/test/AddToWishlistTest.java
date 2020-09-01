package com.flipkart.test;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.flipkart.pages.AddToCartPage;
import com.flipkart.pages.AddToWishlistPage;
import com.flipkart.pages.LoginPage;
import com.flipkart.pages.LogoutPage;

public class AddToWishlistTest {

	AddToWishlistPage page3;
	LoginPage page;
	LogoutPage page1;
	AddToCartPage page2;

	@BeforeClass
	void dependencies() {
		page3 = new AddToWishlistPage();
		page = new LoginPage();
		page1 = new LogoutPage();
		page2 = new AddToCartPage();

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
		Thread.sleep(1000);
		System.out.println("Home page displayed");
		Assert.assertTrue(page.homePageDisplayed(), "Home page not displayed");
		System.out.println("validlogin  successfull");

	}

	@Test(priority = 3)
	public void verifyMyAccountDisplayed() throws InterruptedException {
		Thread.sleep(1000);
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
	public void verifyWishlistBtnDisplay() {
		Assert.assertTrue(page3.wishlistBtnDisplayed(), "Wishlist btn not available");
		System.out.println("Wishlist btn is available for the product ");
	}

	@Test(priority = 9)
	public void verifyclickingWishlistButtotn() throws InterruptedException {
		page3.clickOnWishlistBtn();
		Thread.sleep(1000);
		System.out.println("Product added to wishlist succesfully");
		Assert.assertTrue(page3.wishistSelected(), "Wishlist btn is not selected");

	}

	@Test(priority = 10)
	public void verifyRemoveFromWishlist() throws InterruptedException {

		page3.clickOnwishlistOption();
		Thread.sleep(1000);
		Assert.assertTrue(page3.wishlistPageDisplayed(), "Wishlist page is not displayed");
		Assert.assertTrue(page3.removeButtonDisplayed(), "Remove button is not displayed");
		page3.removeFromWishlist();
	}

	@Test(priority = 11)
	public void verifyEmptyWishlist() throws InterruptedException {
		Thread.sleep(1000);
		Assert.assertTrue(page3.emptyWishlist(), "Search box not displayed");

	}

	@Test(priority = 12)

	public void verifylogout() throws InterruptedException {
		page1.logout();
		Thread.sleep(1000);
		Assert.assertTrue(page1.loginButtonDisplayed(), "Logout failed");
		System.out.println("Login and Logout Successful!!!");
	}

	@Test(priority = 13)
	public void verifyCloseBrowser() {
		page1.closeBrowser();
		System.out.println("Browser closed successfully!!!");
	}

}