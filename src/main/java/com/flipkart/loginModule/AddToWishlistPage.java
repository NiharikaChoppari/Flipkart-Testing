package com.flipkart.loginModule;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.Basepage.BasePage;

public class AddToWishlistPage extends BasePage {
	

	@FindBy(xpath="//div[@class='_3gDSOa _3iGnbq']/div")
	WebElement wishListBtn;
	
	@FindBy(xpath="//div[@class='_3gDSOa _3iGnbq _2kA-_z']/div")
	WebElement wishListBtnSelected;
	
	@FindBy(name="//div[@class='_2aUbKa']")
	WebElement myAccount;
	
	@FindBy(xpath="//ul[@class='RlwYhr undefined']/li[5]")
	WebElement wishlistInDropdown;
	
	@FindBy(xpath="//img[@class='_27LgAY']")
	WebElement removeBtn;
	
	@FindBy(xpath="//button[@class='_2AkmmA _1WPB7I']")
	WebElement removeLink;
	
	@FindBy(xpath="//span[@class='_3Lk2d2']")
	WebElement emptyWishlist;
	
	public AddToWishlistPage(){
		PageFactory.initElements(d,this);
	}
	
	
	public boolean wishlistBtnDisplayed() {
		//wishListBtn = d.findElement(By.xpath("//div[@class='_3gDSOa _3iGnbq']/div"));
		boolean wishlistDisplayed = wishListBtn.isDisplayed();
		return wishlistDisplayed;

	}

	public void clickOnWishlistBtn() {
		//wishListBtn = d.findElement(By.xpath("//div[@class='_3gDSOa _3iGnbq']/div"));
		wishListBtn.click();
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public boolean wishistSelected() {
		//wishListBtnSelected = d.findElement(By.xpath("//div[@class='_3gDSOa _3iGnbq _2kA-_z']/div"));
		boolean wishlistSelected = wishListBtnSelected.isDisplayed();
		return wishlistSelected;
	}

	public void clickOnwishlistOption() {
		
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Actions a = new Actions(d);
		//WebElement myAccount = d.findElement(By.xpath("//div[@class='_2aUbKa']"));
		a.moveToElement(myAccount).perform();
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//d.findElement(By.xpath("//ul[@class='RlwYhr undefined']/li[5]")).click();
		wishlistInDropdown.click();
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	public void removeFromWishlist() {
		//d.findElement(By.xpath("//img[@class='_27LgAY']")).click();
		removeBtn.click();
		d.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//d.findElement(By.xpath("//button[@class='_2AkmmA _1WPB7I']")).click();
		removeLink.click();
	}

	public boolean emptyWishlist() {
		//emptyWishlist = d.findElement(By.xpath("//span[@class='_3Lk2d2']"));
		d.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		boolean wishlistEmpty = emptyWishlist.isDisplayed();
		return wishlistEmpty;

	}
}
