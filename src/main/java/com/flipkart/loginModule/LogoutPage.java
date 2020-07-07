package com.flipkart.loginModule;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.Basepage.BasePage;

public class LogoutPage extends BasePage {

	@FindBy(xpath = "//a[@class='_3Ep39l']")
	WebElement loginBtn;

	@FindBy(xpath = "//div[@class='_2aUbKa']")
	WebElement myAccount;

	@FindBy(xpath = "//ul[@class='RlwYhr undefined']/li[10]")
	WebElement logout;

	public LogoutPage() {
		PageFactory.initElements(d, this);
	}

	public boolean loginButtonDisplayed() {

		boolean loginbtn = loginBtn.isDisplayed();
		return loginbtn;
	}

	public void logout() throws InterruptedException {

		Thread.sleep(1000);
		Actions a = new Actions(d);

		a.moveToElement(myAccount).build().perform();

		logout.click();

	}

	public void closeBrowser() {
		d.close();

	}

	public void quitBrowser() {
		d.quit();
	}

}
