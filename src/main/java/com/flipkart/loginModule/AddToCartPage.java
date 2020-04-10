package com.flipkart.loginModule;

import java.util.Set;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.flipkart.Basepage.BasePage;

public class AddToCartPage extends BasePage {

	@FindBy(xpath="//div[@class='_2aUbKa']")
	WebElement myAccount;
	
	@FindBy(xpath="//a[@class='_3ko_Ud']")
	WebElement cartIcon;
	
	@FindBy(name="q")
	WebElement searchBox;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement searchButton;
	
	@FindBy(xpath="//span[@class='ZAtlA-']/span")
	WebElement errormsg;
	
	@FindBy(xpath="//img[@class='_1Nyybr  _30XEf0']")
	WebElement product;
	
	@FindBy(xpath="//span[@class='_35KyD6']")
	WebElement titleOfProduct;
	
	@FindBy(xpath="//div[@class='_1vC4OE _3qQ9m1']")
	WebElement priceOfProduct;
	
	@FindBy(xpath="//button[@class='_2AkmmA _2Npkh4 _2MWPVK']")
	WebElement cartButton;
	
	@FindBy(xpath="//button[@class='_2AkmmA _2Npkh4 _2kuvG8 _7UHT_c']")
	WebElement buyNow;
	
	
	@FindBy(xpath="//div[@class='_3IO2ev _2K02N8 _2x63a8']/div[2]")
	WebElement remove;
	
	@FindBy(xpath="//div[@class='gdUKd9 _3Z4XMp _2nQDKB']")
	WebElement removeConfirmation;
	
	@FindBy(xpath="//div[@class='hJKWmk']")
	WebElement cartMsg;
	
	public AddToCartPage(){
		PageFactory.initElements(d,this);
	}
	
	public boolean myAccountDisplayed() {

		WebDriverWait wait = new WebDriverWait(d, 20);
		WebElement element = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='_2aUbKa']")));
		boolean myAcountDisplay = element.isDisplayed();
				//d.findElement(By.xpath("//div[@class='_2aUbKa']")).isDisplayed();
		return myAcountDisplay;
	}

	public boolean cartDisplayed() {
		//cart = d.findElement(By.className("_3ko_Ud"));
		boolean cartDisplayed = cartIcon.isDisplayed();
		return cartDisplayed;
	}

	public boolean searchBoxDisplayed() {
		//searchbox = d.findElement(By.name("q"));
		boolean searchBoxDisplay = searchBox.isDisplayed();
		return searchBoxDisplay;
	}

	public boolean searchBtnDisplayed() {
		//searchBtn = d.findElement(By.xpath("//button[@type='submit']"));
		boolean searchBtnDisplay = searchButton.isDisplayed();
		return searchBtnDisplay;
	}

	public void enterProductName(String productname) {
		//searchbox = d.findElement(By.name("q"));
		searchBox.sendKeys(productname);
	}

	public void clickOnSearchBtn() {
		//searchBtn = d.findElement(By.xpath("//button[@type='submit']"));
		searchButton.click();
	}

	public boolean productDisplayed() {

		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//product = d.findElement(By.xpath("//img[@class='_1Nyybr  _30XEf0']"));
		boolean productDisplay = product.isDisplayed();
		return productDisplay;
	}

	public void togglingWindow() {

		String homePageWindow = d.getWindowHandle();

		product = d.findElement(By.xpath("//img[@class='_1Nyybr  _30XEf0']"));
		product.click();
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		Set<String> allWindows = d.getWindowHandles();
		for (String productWindow : allWindows) {
			if (!homePageWindow.equalsIgnoreCase(productWindow)) {
				d.switchTo().window(productWindow);
			}
		}
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public String productTitle() {
		//product = d.findElement(By.xpath("//span[@class='_35KyD6']"));
		String productTitle = titleOfProduct.getText();
		return productTitle;

	}

	public String productPrice() {

		String productPrice = priceOfProduct.getText();
		//d.findElement(By.xpath("//div[@class='_1vC4OE _3qQ9m1']")).getText();
		return productPrice;
	}

	public boolean addToCartDisplayed() {
		//addToCartBtn = d.findElement(By.xpath("//button[@class='_2AkmmA _2Npkh4 _2MWPVK']"));
		 boolean addToCartDisplayed = cartButton.isDisplayed();
		return addToCartDisplayed;
	}
	
	public boolean 	buyNowBtnDisplayed(){
		//buyNowBtn = d.findElement(By.xpath("//button[@class='_2AkmmA _2Npkh4 _2kuvG8 _7UHT_c']"));
		boolean buyNowBtnDisplay = buyNow.isDisplayed();
		return buyNowBtnDisplay;
	}

	public void clickAddToCart() {
		
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//addToCartBtn = d.findElement(By.xpath("//button[@class='_2AkmmA _2Npkh4 _2MWPVK']"));
		cartButton.click();
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public boolean removeDisplayed() {
		//remove = d.findElement(By.xpath("//div[@class='_3IO2ev _2K02N8 _2x63a8']/div[2]"));
		boolean removeBtnDisplayed = remove.isDisplayed();
		return removeBtnDisplayed;
		
	}

	public void removeFromCart() {
		
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//remove = d.findElement(By.xpath("//div[@class='_3IO2ev _2K02N8 _2x63a8']/div[2]"));
		remove.click();
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//d.findElement(By.xpath("//div[@class='gdUKd9 _3Z4XMp _2nQDKB']")).click();
		removeConfirmation.click();
	}

	public String cartMsg() {
		String msg= cartMsg.getText();
				//d.findElement(By.xpath("//div[@class='hJKWmk']")).getText();
		return msg;
	}
	
	
		
	}

