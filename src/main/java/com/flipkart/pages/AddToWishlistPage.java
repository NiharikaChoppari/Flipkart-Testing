package com.flipkart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.Basepage.BasePage;
import com.flipkart.Basepage.DriverFactory;

public class AddToWishlistPage extends BasePage {

	@FindBy(xpath = "//div[@class='_2hVSre _1eAP-x']/div")
	WebElement wishListBtn;

	@FindBy(xpath = "//div[@class='_2hVSre _1eAP-x _21GqcY']/div")
	WebElement wishListBtnSelected;

	@FindBy(xpath = "//div[@class='exehdJ']")
	WebElement myAccount;

	@FindBy(xpath = "//ul[@class='pO9syL undefined']/li[5]")
	WebElement wishlistInDropdown;

	@FindBy(xpath = "//div[@class='_3FVYY1']")
	WebElement wishlistPage;

	@FindBy(xpath = "//img[@class='_2Nq6Qc']")
	WebElement removeBtn;

	@FindBy(xpath = "//button[@class='_2KpZ6l _3S58wp']")
	WebElement removeLink;

	@FindBy(xpath = "//span[@class='_3Juh7R']")
	WebElement emptyWishlist;

	public AddToWishlistPage() {
		PageFactory.initElements(DriverFactory.getDriver(), this);
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

			Actions action = new Actions(DriverFactory.getDriver());

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
