package com.flipkart.loginModule;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.flipkart.Basepage.BasePage;

public class BuyNowPage extends BasePage {
	
	WebElement buyNowBtn;
	WebElement product;
	WebElement price;
	
	public boolean buyNowBtnDisplayed(){
		buyNowBtn=d.findElement(By.xpath("//button[@class='_2AkmmA _2Npkh4 _2kuvG8 _7UHT_c']"));
		boolean buyNowBtnDisplay=buyNowBtn.isDisplayed();
		return buyNowBtnDisplay;
	}
	
	public void clickBuyNowBtn(){
		buyNowBtn=d.findElement(By.xpath("//button[@class='_2AkmmA _2Npkh4 _2kuvG8 _7UHT_c']"));
		buyNowBtn.click();
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	public boolean priceDisplayed(){
		price=d.findElement(By.xpath("//div[@class='_3GoQc2']"));
		boolean priceDisplay=price.isDisplayed();
		return priceDisplay;
	}
	
	public boolean productDisplayed(){
		product=d.findElement(By.xpath("//img[@class='_1Nyybr  _30XEf0']"));
		boolean productDisplay=product.isDisplayed();
		return productDisplay;
	}
	public void clickOnFlipkartTitle(){
		d.findElement(By.xpath("//img[@class='_1e_EAo']")).click();
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
}
