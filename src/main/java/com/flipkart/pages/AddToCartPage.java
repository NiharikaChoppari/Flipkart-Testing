package com.flipkart.pages;

import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.flipkart.Basepage.BasePage;

public class AddToCartPage extends BasePage {

	 String productTitle = "Experiences of Test Automation  (English, Paperback, Graham Dorothy)";
	 String productprice = "₹591";

	@FindBy(xpath = "//div[@class='_2aUbKa']")
	WebElement myAccount;

	@FindBy(xpath = "//a[@class='_3ko_Ud']")
	WebElement cartIcon;

	@FindBy(name = "q")
	WebElement searchBox;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement searchButton;

	@FindBy(xpath = "//span[@class='ZAtlA-']/span")
	WebElement errormsg;

	@FindBy(xpath = "//div[@class='_3BTv9X']/img[@class='_1Nyybr  _30XEf0']")
	WebElement product;

	@FindBy(xpath = "//span[@class='_35KyD6']")
	WebElement titleOfProduct;

	@FindBy(xpath = "//div[@class='_1vC4OE _3qQ9m1']")
	WebElement priceOfProduct;

	@FindBy(xpath = "//button[@class='_2AkmmA _2Npkh4 _2MWPVK']")
	WebElement cartButton;

	@FindBy(xpath = "//button[@class='_2AkmmA _2Npkh4 _2kuvG8 _7UHT_c']")
	WebElement buyNow;

	@FindBy(xpath = "//div[@class='_3IO2ev _2K02N8 _2x63a8']/div[2]")
	WebElement remove;

	@FindBy(xpath = "//div[@class='gdUKd9 _3Z4XMp _2nQDKB']")
	WebElement removeConfirmation;

	@FindBy(xpath = "//div[@class='hJKWmk']")
	WebElement cartMsg;

	@FindBy(xpath = "//ul[@class='RlwYhr']/li[10]")
	WebElement logout;

	public AddToCartPage() {
		PageFactory.initElements(d, this);
	}

	public boolean myAccountDisplayed() {
		boolean myAcountDisplay = myAccount.isDisplayed();
		return myAcountDisplay;
	}

	public boolean cartDisplayed() {
		boolean cartDisplayed = cartIcon.isDisplayed();
		return cartDisplayed;
	}

	public boolean searchBoxDisplayed() {
		boolean searchBoxDisplay = searchBox.isDisplayed();
		return searchBoxDisplay;
	}

	public boolean searchBtnDisplayed() {
		boolean searchBtnDisplay = searchButton.isDisplayed();
		return searchBtnDisplay;
	}

	public void enterProductName(String productname) {
		searchBox.sendKeys(productname);
	}

	public void clickOnSearchBtn() {
		searchButton.click();
	}

	public boolean productDisplayed() throws InterruptedException {
		Thread.sleep(1000);
		boolean productDisplay = product.isDisplayed();
		return productDisplay;
	}

	public void togglingWindow() {

		String homePageWindow = d.getWindowHandle();

		product = d.findElement(By.xpath("//div[@class='_3BTv9X']/img[@class='_1Nyybr  _30XEf0']"));
		product.click();
		Set<String> allWindows = d.getWindowHandles();
		for (String productWindow : allWindows) {
			if (!homePageWindow.equalsIgnoreCase(productWindow)) {
				d.switchTo().window(productWindow);
				d.manage().window().maximize();
			}
		}

	}

	public String productTitle() {
		String productTitle = titleOfProduct.getText();
		return productTitle;

	}

	public String productPrice() {

		String productPrice = priceOfProduct.getText();
		return productPrice;
	}

	public boolean addToCartDisplayed() {
		boolean addToCartDisplayed = cartButton.isDisplayed();
		return addToCartDisplayed;
	}

	public boolean buyNowBtnDisplayed() {
		boolean buyNowBtnDisplay = buyNow.isDisplayed();
		return buyNowBtnDisplay;
	}

	public void clickAddToCart() {
		cartButton.click();
	}

	public boolean removeDisplayed() throws InterruptedException {
		Thread.sleep(1000);
		boolean removeBtnDisplayed = remove.isDisplayed();
		return removeBtnDisplayed;

	}

	public void removeFromCart() throws InterruptedException {

		Thread.sleep(1000);
		remove.click();
		removeConfirmation.click();
	}

	public String cartMsg() throws InterruptedException {
		Thread.sleep(1000);
		String msg = cartMsg.getText();
		return msg;
	}

	public void logout() throws InterruptedException {

		Actions a = new Actions(d);
		a.moveToElement(myAccount).build().perform();
		logout.click();

	}

}
