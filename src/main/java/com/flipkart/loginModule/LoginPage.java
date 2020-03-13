package com.flipkart.loginModule;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import com.flipkart.Basepage.BasePage;

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

	public boolean errorMessageDisplayed() throws InterruptedException {
		
		Thread.sleep(2000);
		boolean msgValue = d.findElement(By.xpath("//span[@class='ZAtlA-']/span")).isDisplayed();
		return msgValue;
	}

	public String errorMessageContent() throws InterruptedException {
		
		Thread.sleep(2000);
		String msgValueContenent = d.findElement(By.xpath("//span[@class='ZAtlA-']/span")).getText();
		return msgValueContenent;
	}

	public boolean enterPasswordMsg() {

		boolean pwdmsg = d.findElement(By.xpath("//span[@class='ZAtlA-']/span")).isDisplayed();
		return pwdmsg;
	}

	public boolean homePageDisplayed() {

		boolean homepage = d.findElement(By.name("q")).isDisplayed();
		return homepage;
	}

	public void clear(String field){
		
		WebElement username=d.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/input"));
		WebElement password=d.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[2]/input"));
		
		
		if(field=="username")
		{
			username.sendKeys(Keys.CONTROL,"a");
			username.sendKeys(Keys.DELETE);	
		}
		password.sendKeys(Keys.CONTROL,"a");
		password.sendKeys(Keys.DELETE);	
		
			
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
	
	public void deleteCookies(){
		d.manage().deleteAllCookies();
	}

}
