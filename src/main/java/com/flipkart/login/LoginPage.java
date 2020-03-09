package com.flipkart.login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.flipkart.basepage.BasePage;

public class LoginPage extends BasePage {
	
	public void enterurl(String url) {
		d.get(url);
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public boolean logindispplayed() {

		boolean logindisplay = d.findElement(By.xpath("//span[text()='Login']")).isDisplayed();
		return logindisplay;
	}

	public void enterun(String un) throws InterruptedException {

		d.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/input")).sendKeys(un);
	}

	public void enterpwd(String pwd) {

		d.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[2]/input")).sendKeys(pwd);
	}

	public void clickOnLogin() {

		d.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[3]/button/span")).click();

	}

	public boolean errorMessageDisplayed() {

		boolean msgValue = d.findElement(By.xpath("//span[@class='ZAtlA-']")).isDisplayed();
		return msgValue;
	}

	public String errorMessageContent() {

		String msgValueContenent = d.findElement(By.xpath("//span[@class='ZAtlA-']")).getText();
		return msgValueContenent;
	}

	public boolean enterPasswordMsg() {

		boolean pwdmsg = d.findElement(By.xpath("//span[@class='ZAtlA-']")).isDisplayed();
		return pwdmsg;
	}

	public boolean homePageDisplayed() {

		boolean homepage = d.findElement(By.name("q")).isDisplayed();
		return homepage;
	}

	public void refresh() {
		d.navigate().refresh();
	}

	public void logout() throws InterruptedException {

		Thread.sleep(2000);
		Actions a = new Actions(d);
		WebElement myAccount = d.findElement(By.xpath("/html/body/div/div/div[1]/div[1]/div[2]/div[3]/div/div/div[1]/div"));
		a.moveToElement(myAccount).perform();
		Thread.sleep(2000);
		d.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[3]/div/div/div[2]/div[2]/div/ul/li[10]/a/div"))
				.click();

	}

	public void closeBrowser() {
		d.close();
	}

}
