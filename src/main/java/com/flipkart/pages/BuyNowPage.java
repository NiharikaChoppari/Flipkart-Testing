package com.flipkart.pages;
import java.io.File;



import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;

import com.flipkart.Basepage.BasePage;
import com.flipkart.Basepage.DriverFactory;

public class BuyNowPage extends BasePage {

	@FindBy(xpath = "//div[@class='_39M2dM JB4AMj']")
	WebElement login;

	@FindBy(xpath = "//button[@class='_2AkmmA _2Npkh4 _2kuvG8 _7UHT_c']")
	WebElement buyNowBtn;

	@FindBy(xpath = "//div[@class='_3BTv9X']/img[@class='_1Nyybr  _30XEf0']")
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
		//super();
		PageFactory.initElements(DriverFactory.getDriver(), this);

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

	public boolean productDisplayed() throws InterruptedException {
		Thread.sleep(1000);
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
