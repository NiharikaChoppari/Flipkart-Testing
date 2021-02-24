package com.flipkart.pages;

import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.flipkart.Basepage.BasePage;
import com.flipkart.Basepage.DriverFactory;

public class AddToCartPage extends BasePage {

	public String productTitle = "A Practitioner's Guide to Test Automation Using SELENIUM  (English, Paperback, Garg Aditya)";
	public String productprice = "₹418";

	@FindBy(xpath = "//div[@class='exehdJ']")
	WebElement myAccount;

	@FindBy(xpath = "//a[@class='_3SkBxJ']")
	WebElement cartIcon;

	@FindBy(xpath = "//*[@id='container']/div/div[1]/div[1]/div[2]/div[2]/form/div/div/input")
	WebElement searchBox;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement searchButton;

	@FindBy(xpath = "//span[@class='ZAtlA-']/span")
	WebElement errormsg;

	@FindBy(xpath = "//div[@class='CXW8mj']/img[@class='_396cs4  _3exPp9']")
	WebElement product;

	@FindBy(xpath = "//span[@class='B_NuCI']")
	WebElement titleOfProduct;

	@FindBy(xpath = "//div[@class='_30jeq3 _16Jk6d']")
	WebElement priceOfProduct;

	@FindBy(xpath = "//*[@id=\"pincodeInputId\"]")
	WebElement pincodeField;

	@FindBy(xpath = "//span[@class='_2P_LDn']")
	WebElement checkButton;

	@FindBy(xpath = "//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")
	WebElement cartButton;

	@FindBy(xpath = "//button[@class='_2KpZ6l _2U9uOA ihZ75k _3AWRsL']")
	WebElement buyNow;

	@FindBy(xpath = "//div[@class='_10vWcL td-FUv WDiNrH']/div[2]")
	WebElement remove;

	@FindBy(xpath = "//*[@id=\"container\"]/div/div[1]/div/div[3]/div/div[2]")
	WebElement removeConfirmation;

	@FindBy(xpath = "//div[@class='_1LCJ1U']")
	WebElement cartMsg;

	@FindBy(xpath = "//ul[@class='pO9syL']/li[10]/a[@class='_2kxeIr']")
	WebElement logout;

	public AddToCartPage() {
		PageFactory.initElements(DriverFactory.getDriver(), this);
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

	public boolean productDisplayed() {

		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='container']/div/div[3]/div/div[2]/div[2]/div/div/div/a[1]/div[1]/div/div/img")));
		boolean productDisplay = product.isDisplayed();
		return productDisplay;
	}

	public void togglingWindow() {

		String homePageWindow = DriverFactory.getDriver().getWindowHandle();

		product = DriverFactory.getDriver()
				.findElement(By.xpath("//div[@class='CXW8mj']/img[@class='_396cs4  _3exPp9']"));
		product.click();
		Set<String> allWindows = DriverFactory.getDriver().getWindowHandles();
		for (String productWindow : allWindows) {
			if (!homePageWindow.equalsIgnoreCase(productWindow)) {
				DriverFactory.getDriver().switchTo().window(productWindow);
				DriverFactory.getDriver().manage().window().maximize();
			}
		}

	}

	public void checkProductAvailability(String pincode) {

		pincodeField.click();
		pincodeField.sendKeys(pincode);
		checkButton.click();

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

	public boolean removeDisplayed() {
		boolean removeBtnDisplayed = remove.isDisplayed();
		return removeBtnDisplayed;

	}

	public void removeFromCart() {

		remove.click();
		removeConfirmation.click();
	}

	public String cartMsg() throws InterruptedException {
		Thread.sleep(1000);
		String msg = cartMsg.getText();
		return msg;
	}

	public void logout() {

		Actions a = new Actions(DriverFactory.getDriver());
		a.moveToElement(myAccount).build().perform();
		logout.click();

	}

}
