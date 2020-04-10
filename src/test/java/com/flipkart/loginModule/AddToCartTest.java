package com.flipkart.loginModule;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AddToCartTest {

	AddToCartPage page2 = new AddToCartPage();

	LoginPage page = new LoginPage();
	LogoutPage page1=new LogoutPage();
	

	@Test(priority = 1)
	public void verifyUrl() {

		page.enterurl();
		Assert.assertTrue(page.logindisplayed(), "url is entered and login page displayed");
	}

	@Test(priority = 2)
	@Parameters({ "validUn", "validPwd" })
	public void validlogin(String validUn, String validPwd) throws InterruptedException {

		page.enterun(validUn);
		page.enterpwd(validPwd);
		page.clickOnLogin();
		System.out.println("home page displayed");
		Assert.assertTrue(page.homePageDisplayed(), "Home page not displayed");
		System.out.println("validlogin  successfull");

	}

	@Test(priority = 3)
	public void verifyMyAccountDisplayed() {
		Assert.assertTrue(page2.myAccountDisplayed(), "My Account not displayed");
		System.out.println("My account option is displayed");
	}

	@Test(priority = 4)
	public void verifySearchBoxAvailability() {

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
	public void verifyProductSearch(String product) {
		page2.enterProductName(product);
		page2.clickOnSearchBtn();
		Assert.assertTrue(page2.productDisplayed(), "Product not displayed");

	}

	@Test(priority = 8)
	public void verifyProductDisplayed() {
		page2.togglingWindow();
		Assert.assertEquals("Test Automation using Selenium WebDriver with Java  (English, Paperback, Garg Navneesh)",
				page2.productTitle(), "Expected and Actual title did not matched");
		System.out.println("Title of the book verified");
		Assert.assertEquals("₹1,099", page2.productPrice(), "Expected and Actual price did not matched");
		System.out.println("Price of the book is verified");
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
	@Test(priority=12)
	public void verifyRemoveFromCart(){
		
		Assert.assertTrue(page2.removeDisplayed(), "Remove option not available");
		System.out.println("remove displayed clicked");
		page2.removeFromCart();
		Assert.assertEquals("Your cart is empty!", page2.cartMsg(),
				"Expected and Actual msg of empty cart did not matched");
		System.out.println("Product successfully removed from cart!");

		
	}
	 @Test(priority=13)
	public void verifylogout() {
		try {
			page1.logout();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertTrue(page1.loginbtn(), "Logout failed");
		System.out.println("Login and Logout Successful!!!");
	}

	
	 @Test(priority=14)
	public void verifyCloseBrowser() {
		page1.closeBrowser();
		System.out.println("Browser closed successfully!!!");
	}
	
	@Test(priority=15)
	public void quit(){
		page1.quitBrowser();
	}
	

}