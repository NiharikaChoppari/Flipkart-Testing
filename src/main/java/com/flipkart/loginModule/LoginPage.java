package com.flipkart.loginModule;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.Basepage.BasePage;

public class LoginPage extends BasePage {

	@FindBy(xpath = "//span[text()='Login']")
	WebElement logindisplay;

	@FindBy(xpath = "/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/input")
	WebElement username;

	@FindBy(xpath = "//input[@type='password']")
	WebElement password;

	@FindBy(xpath = "//button[@class='_2AkmmA _1LctnI _7UHT_c']")
	WebElement loginbutton;

	@FindBy(xpath = "//span[@class='ZAtlA-']/span")
	WebElement errormsg;

	@FindBy(xpath = "//div[@class='_2aUbKa']")
	WebElement homepage;

	public LoginPage() {
		PageFactory.initElements(d, this);
	}

	static Properties prop;

	public void enterurl() {

		prop = new Properties();

		try {
			FileInputStream ip = new FileInputStream("./config/config.properties");
			prop.load(ip);
			String url = prop.getProperty("flipkartUrl");
			d.get(url);

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public boolean logindisplayed() {

		boolean loginpageDisplay = logindisplay.isDisplayed();
		return loginpageDisplay;

	}

	public void enterun(String un) {

		username.sendKeys(un);
	}

	public void enterpwd(String pwd) {

		password.sendKeys(pwd);
	}

	public void clickOnLogin() {

		loginbutton.click();
	}

	public boolean errorMessageDisplayed() {

		boolean msgValue = errormsg.isDisplayed();
		return msgValue;
	}

	public String errorMessageContent() {

		String msgValueContenent = errormsg.getText();
		return msgValueContenent;
	}

	public boolean enterPasswordMsg() {

		boolean pwdmsg = errormsg.isDisplayed();
		return pwdmsg;
	}

	public boolean homePageDisplayed() {

		boolean homepageDisplay = homepage.isDisplayed();
		return homepageDisplay;
	}

	public void clear(String field) {

		if (field == "username") {
			username.sendKeys(Keys.CONTROL, "a");
			username.sendKeys(Keys.DELETE);
		}
		password.sendKeys(Keys.CONTROL, "a");
		password.sendKeys(Keys.DELETE);

	}

}
