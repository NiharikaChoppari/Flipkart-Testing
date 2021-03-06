package com.flipkart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.Basepage.BasePage;
import com.flipkart.Basepage.DriverFactory;

public class LogoutPage extends BasePage {

	@FindBy(xpath = "//a[@class='_1_3w1N']")
	WebElement loginBtn;

	@FindBy(xpath = "//div[@class='exehdJ']")
	WebElement myAccount;

	@FindBy(xpath = "//ul[@class='pO9syL undefined']/li[10]/a[@class='_2kxeIr']")
	WebElement logout;

	public LogoutPage() {
		PageFactory.initElements(DriverFactory.getDriver(), this);
	}

	public boolean loginButtonDisplayed() {

		boolean loginbtn = loginBtn.isDisplayed();
		return loginbtn;
	}

	public void logout() throws InterruptedException {

		Thread.sleep(1000);
		Actions a = new Actions(DriverFactory.getDriver());

		a.moveToElement(myAccount).build().perform();

		logout.click();

	}

	public void closeBrowser() {
		DriverFactory.getDriver().close();

	}

	public void quitBrowser() {
		DriverFactory.getDriver().quit();
	}

}
