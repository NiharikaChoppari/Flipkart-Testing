package com.flipkart.loginModule;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import com.flipkart.Basepage.BasePage;

public class LogoutPage extends BasePage {
	
	public boolean loginbtn() {

		boolean loginbtn = d.findElement(By.xpath("//a[@class='_3Ep39l']")).isDisplayed();
		return loginbtn;
		
	}

	public void logout() throws InterruptedException {

		Thread.sleep(2000);
		Actions a = new Actions(d);
		WebElement myAccount = d
				.findElement(By.xpath("//div[@class='_2aUbKa']"));
		a.moveToElement(myAccount).perform();
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		d.findElement(By
				.xpath("/html/body/div/div/div[1]/div[1]/div[2]/div[3]/div/div/div[2]/div[2]/div/ul/li[10]/a/div"))
				.click();
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	public void closeBrowser() {
		d.close();

	}
	
	public void quitBrowser(){
		d.quit();
	}


}
