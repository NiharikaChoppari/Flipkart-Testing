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

	@FindBy(xpath = "//div[@class='_3oBhRa col col-2-5 _4H6HH5']")
	WebElement login;

	@FindBy(xpath = "//button[@class='_2KpZ6l _2U9uOA ihZ75k _3AWRsL']")
	WebElement buyNowBtn;

	@FindBy(xpath = "//div[@class='CXW8mj']/img[@class='_396cs4  _3exPp9']")
	WebElement product;

	@FindBy(xpath = "//span[@class='_2-ut7f _1WpvJ7']")
	WebElement price;

	@FindBy(xpath = "//a[@class='_3SkBxJ']")
	WebElement cartIcon;

	@FindBy(xpath = "//div[@class='_2Kn22P']")
	WebElement title;

	@FindBy(xpath = "//div[@class='_3dsJAO']")
	WebElement remove;

	@FindBy(xpath = "/html/body/div[1]/div/div[1]/div/div[3]/div/div[2]")
	WebElement removeConfirmation;

	@FindBy(xpath = "//div[@class='LYTQKl']")
	WebElement cartMessage;

	@FindBy(xpath = "//*[@id=\"container\"]/div/div[2]/div/div[2]/div/div/a[1]/img")
	WebElement flipkartLogo;

	@FindBy(xpath = "//div[@class='_1LCJ1U']")
	WebElement emptyCartMessage;

	public BuyNowPage() {

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

	public boolean removeProduct() {

		boolean removeProductmessage = cartMessage.isDisplayed();
		return removeProductmessage;

	}

	public void clickOnFlipkartLogo() {

		flipkartLogo.click();
	}

	public void removeProductFromCart() throws InterruptedException {
		Thread.sleep(1000);
		cartIcon.click();
		Thread.sleep(1000);
		remove.click();
	}

	public boolean emptyCartMessage() {

		boolean message = emptyCartMessage.isDisplayed();
		return message;
	}

}
