package com.flipkart.loginModule;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.Basepage.BasePage;

public class BuyNowPage extends BasePage {

	@FindBy(xpath = "//div[@class='_39M2dM JB4AMj']")
	WebElement login;

	@FindBy(xpath = "//button[@class='_2AkmmA _2Npkh4 _2kuvG8 _7UHT_c']")
	WebElement buyNowBtn;

	@FindBy(xpath = "//img[@class='_1Nyybr  _30XEf0']")
	WebElement product;

	@FindBy(xpath = "//div[@class='_3GoQc2']")
	WebElement price;

	@FindBy(xpath = "//img[@class='_1e_EAo']")
	WebElement title;

	@FindBy(xpath = "//div[@class='gdUKd9']")
	WebElement remove;

	@FindBy(linkText = "GO TO CART")
	WebElement goToCart;

	public BuyNowPage() {
		PageFactory.initElements(d, this);

	}

	public void login() {
		login.click();
	}

	public boolean buyNowBtnDisplayed() {
		boolean buyNowBtnDisplay = buyNowBtn.isDisplayed();
		return buyNowBtnDisplay;
	}

	public void clickBuyNowBtn() {
		buyNowBtn.click();
	}

	public boolean priceDisplayed() {
		boolean priceDisplay = price.isDisplayed();
		return priceDisplay;
	}

	public boolean productDisplayed() {

		boolean productDisplay = product.isDisplayed();
		return productDisplay;
	}

	public void clickOnFlipkartTitle() {
		title.click();

	}

	public void clickOnRemove() {
		remove.click();
	}

	public boolean goToCartDisplayed() {
		return goToCart.isDisplayed();
	}

	public void clickOnGoToCart() {
		goToCart.click();
	}
}
