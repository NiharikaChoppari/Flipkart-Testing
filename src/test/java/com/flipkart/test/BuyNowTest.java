package com.flipkart.test;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.flipkart.pages.AddToCartPage;
import com.flipkart.pages.BuyNowPage;
import com.flipkart.pages.LoginPage;
import com.flipkart.pages.LogoutPage;

public class BuyNowTest {

	BuyNowPage page4;
	LoginPage page;
	LogoutPage page1;
	AddToCartPage page2;

	@BeforeClass
	void dependencies() {
		page4 = new BuyNowPage();
		page = new LoginPage();
		page1 = new LogoutPage();
		page2 = new AddToCartPage();
	}

	@Test(priority = 1, enabled = false)
	public void verifyUrl() {

		page.enterurl();
		Assert.assertTrue(page.logindisplayed(), "url is entered and login page displayed");
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
	public void verifyMyAccountDiplayed() throws InterruptedException {
		Assert.assertTrue(page2.myAccountDisplayed(), "My Account not displayed");
		System.out.println("My account option is displayed");
	}

	@Test(priority = 4, enabled = false)
	public void verifySearchBoxAvailability() throws InterruptedException {
		Thread.sleep(1000);
		Assert.assertTrue(page2.searchBoxDisplayed(), "Search box not displayed");
		System.out.println("Search box is displayed ");
	}

	@Test(priority = 5, enabled = false)
	public void verifySearchBtnAvailability() throws InterruptedException {
		Thread.sleep(1000);
		Assert.assertTrue(page2.searchBtnDisplayed(), "Search box not displayed");
		System.out.println("Search button is displayed");
	}

	@Test(priority = 6, enabled = false)
	public void verifyCartButtonDisplayed() {
		Assert.assertTrue(page2.cartDisplayed(), "Search box not displayed");
		System.out.println("cart button is displayed");
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
	public void verifyProductDisplayed(String pincode) {
		page2.togglingWindow();
		Assert.assertEquals(page2.productTitle, page2.productTitle(), "Expected and Actual title did not matched");
		Assert.assertEquals(page2.productprice, page2.productPrice(), "Expected and Actual price did not matched");
		page2.checkProductAvailability(pincode);
	}

	@Test(priority = 9)
	public void verifyBuyNowBtnDisplay() throws InterruptedException {
		Thread.sleep(1000);
		Assert.assertTrue(page4.buyNowBtnDisplayed(), "Buy Now btn not displayed");
		page4.clickBuyNowBtn();
	}

	@Test(priority = 10)
	public void verifyProductDisplay() throws InterruptedException {
		Thread.sleep(2000);
		Assert.assertTrue(page4.productDisplayed(), "Product not displayed");
	}

	@Test(priority = 11)
	public void verifyProductprice() throws IOException {
		Assert.assertTrue(page4.priceDisplayed(), "Expected and Actual price did not matched");
	}

	@Test(priority = 12)
	public void removeProduct() {
		page4.clickOnRemove();
		Assert.assertTrue(page4.removeProduct(), "Expected and Actual price did not matched");
	}

	@Test(priority = 13)
	public void verifyRemoveFromCart() throws InterruptedException {

		page4.clickOnFlipkartLogo();
		page4.removeProductFromCart();
		Thread.sleep(1000);
		Assert.assertTrue(page4.emptyCartMessage(), "Expected and Actual price did not matched");
	}

	@Test(priority = 14)
	public void verifylogout() throws InterruptedException {
		page2.logout();
		Thread.sleep(1000);
		Assert.assertTrue(page1.loginButtonDisplayed(), "Logout failed");
	}

	@Test(priority = 15)
	public void verifyCloseBrowser() {
		page1.closeBrowser();
	}

	@Test(priority = 16)
	public void quit() {
		page1.quitBrowser();
	}
}