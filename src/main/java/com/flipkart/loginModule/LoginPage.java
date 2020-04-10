package com.flipkart.loginModule;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.Basepage.BasePage;

public class LoginPage extends BasePage {
	
	
	@FindBy(xpath="//span[text()='Login']")
	WebElement logindisplay;
	
	@FindBy(xpath="/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/input")
	WebElement username;
	
	@FindBy(xpath="//input[@type='password']")
	WebElement password;
	
	@FindBy(xpath="//button[@class='_2AkmmA _1LctnI _7UHT_c']")
	WebElement loginbutton;
	
	@FindBy(xpath="//span[@class='ZAtlA-']/span")
	WebElement errormsg;
	
	@FindBy(xpath="//div[@class='_2aUbKa']")
	WebElement homepage;
	
	public LoginPage(){
		PageFactory.initElements(d,this);
	}
	
	static Properties prop;

	public void enterurl() {
		
		
		prop = new Properties();

		try {
			FileInputStream ip = new FileInputStream(
					"./config/config.properties");
			prop.load(ip);
			String url=prop.getProperty("flipkartUrl");
			d.get(url);
			
		} catch (IOException e) {

			e.printStackTrace();
		}
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}


	public boolean logindisplayed() {
		
		boolean loginpageDisplay=logindisplay.isDisplayed();
		//boolean logindisplay = d.findElement(By.xpath("//span[text()='Login']")).isDisplayed();
		return loginpageDisplay;
		
	}

	public void enterun(String un) throws InterruptedException {
		
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		username.sendKeys(un);
		//d.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/input")).sendKeys(un);
	}

	public void enterpwd(String pwd) {

		//d.findElement(By.xpath("//input[@type='password']"))
		password.sendKeys(pwd);
	}

	public void clickOnLogin() {

		//d.findElement(By.xpath("//button[@class='_2AkmmA _1LctnI _7UHT_c']"))
		loginbutton.click();
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	public boolean errorMessageDisplayed() throws InterruptedException {

		Thread.sleep(2000);
		boolean msgValue =errormsg.isDisplayed();
				//d.findElement(By.xpath("//span[@class='ZAtlA-']/span")).isDisplayed();
		return msgValue;
	}

	public String errorMessageContent() throws InterruptedException {

		Thread.sleep(2000);
		String msgValueContenent = errormsg.getText();
				//d.findElement(By.xpath("//span[@class='ZAtlA-']/span")).getText();
		return msgValueContenent;
	}

	public boolean enterPasswordMsg() {

		boolean pwdmsg = errormsg.isDisplayed();
				//d.findElement(By.xpath("//span[@class='ZAtlA-']/span")).isDisplayed();
		return pwdmsg;
	}

	public boolean homePageDisplayed() {

		boolean homepageDisplay =homepage.isDisplayed();
				//d.findElement(By.xpath("//div[@class='_2aUbKa']")).isDisplayed();
		return homepageDisplay;
	}

	public void clear(String field) {

	//	WebElement username = d.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/input"));
		//WebElement password = d.findElement(By.xpath("//input[@type='password']"));

		if (field == "username") {
			username.sendKeys(Keys.CONTROL, "a");
			username.sendKeys(Keys.DELETE);
		}
		password.sendKeys(Keys.CONTROL, "a");
		password.sendKeys(Keys.DELETE);

	}

}


