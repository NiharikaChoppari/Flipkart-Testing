package com.flipkart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.Basepage.BasePage;

public class AddToWishlistPage extends BasePage {

	@FindBy(xpath = "//div[@class='_3gDSOa _3iGnbq']/div")
	WebElement wishListBtn;

	@FindBy(xpath = "//div[@class='_3gDSOa _3iGnbq _2kA-_z']/div")
	WebElement wishListBtnSelected;

	@FindBy(xpath = "//div[@class='_2aUbKa']")
	WebElement myAccount;

	@FindBy(xpath = "//ul[@class='RlwYhr undefined']/li[5]")
	WebElement wishlistInDropdown;

	@FindBy(xpath = "//div[@class='_3oWply']")
	WebElement wishlistPage;

	@FindBy(xpath = "//img[@class='_27LgAY']")
	WebElement removeBtn;

	@FindBy(xpath = "//button[@class='_2AkmmA _1WPB7I']")
	WebElement removeLink;

	@FindBy(xpath = "//span[@class='_3Lk2d2']")
	WebElement emptyWishlist;

	public AddToWishlistPage() {
		PageFactory.initElements(d, this);
	}

	public boolean wishlistBtnDisplayed() {
		boolean wishlistDisplayed = wishListBtn.isDisplayed();
		return wishlistDisplayed;

	}

	public void clickOnWishlistBtn() {
		wishListBtn.click();
	}

	public boolean wishistSelected() {
		boolean wishlistSelected = wishListBtnSelected.isDisplayed();
		return wishlistSelected;
	}

	public void clickOnwishlistOption() {

		try {

			Actions action = new Actions(d);

			action.moveToElement(myAccount).build().perform();

			wishlistInDropdown.click();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public boolean wishlistPageDisplayed() {
		boolean wishlistPageDisplay = wishlistPage.isDisplayed();
		return wishlistPageDisplay;
	}

	public boolean removeButtonDisplayed() {
		boolean removeButtonDisplay = removeBtn.isDisplayed();
		return removeButtonDisplay;
	}

	public void removeFromWishlist() {
		removeBtn.click();
		removeLink.click();
	}

	public boolean emptyWishlist() {
		boolean wishlistEmpty = emptyWishlist.isDisplayed();
		return wishlistEmpty;

	}
}
