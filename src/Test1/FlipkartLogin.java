package Test1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.junit.Assert;  

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlipkartLogin {
	
	ChromeDriver d=new ChromeDriver();
	
	public void url(String url)
	{
		
			d.get(url);
			d.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			Assert.assertTrue(d.findElement(By.className("fk-modal-visible")).isDisplayed());
			System.out.println("url is entered and login page displayed");	
	}
	public void verifyInvalidUnandValidPwd(String un,String pwd)
	{ 
		
			d.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/input")).sendKeys(un);
			d.findElement(By.xpath("//input[@type='password']")).sendKeys(pwd);
			d.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[3]/button")).click();
			Assert.assertTrue(d.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/span[3]/span")).isDisplayed());
			System.out.println("Invalid username or password message displayed");
			d.navigate().refresh();
		
		
	}
	
	public void verifyValidUnandInvalidPwd(String un,String pwd)
	{ 
		
			d.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/input")).sendKeys(un);
			d.findElement(By.xpath("//input[@type='password']")).sendKeys(pwd);
			d.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[3]/button")).click();
			Assert.assertTrue(d.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/span[3]/span")).isDisplayed());
			System.out.println("Invalid username or password message displayed");
			d.navigate().refresh();
	
			
		
	}
	
	public void verifyInvalidCredentials(String un,String pwd)
	{ 
		
			d.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/input")).sendKeys(un);
			d.findElement(By.xpath("//input[@type='password']")).sendKeys(pwd);
			d.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[3]/button")).click();
			Assert.assertTrue(d.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/span[3]/span")).isDisplayed());
			System.out.println("Invalid username or password message displayed");
			d.navigate().refresh();
	
			
		
	}
	
	public void verifyLoginUsingOnlyUn(String un)
	{ 
		
			d.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/input")).sendKeys(un);
			d.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[3]/button")).click();
			WebDriverWait wait = new WebDriverWait(d,30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/span[3]/span")));
			d.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			Assert.assertTrue(d.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/span[3]/span")).isDisplayed());
			System.out.println("Invalid username or password message displayed");
			d.navigate().refresh();
			
			
		
	}
	
	public void verifyLoginWithOnlyPwd(String pwd) 
	{
		
			d.findElement(By.xpath("//input[@type='password']")).sendKeys(pwd);
			d.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[3]/button")).click();
			d.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			Assert.assertTrue(d.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/span[3]/span")).isDisplayed());
			System.out.println("Invalid username or password message displayed");
			d.navigate().refresh();
				
	}
	
	public void ForgotPassword(String un) 
	{
		
			d.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/input")).sendKeys(un);
			d.findElement(By.xpath("//span[text()='Your username or password is incorrect']")).click();
			d.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			Assert.assertTrue(d.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[2]/span")).isDisplayed());
			System.out.println("Login page with OTP field is displayed");
			d.navigate().refresh();
			
	}
	
	public void verifyValidCredentials(String un,String pwd)
	{
	
			d.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/input")).sendKeys(un);
			d.findElement(By.xpath("//input[@type='password']")).sendKeys(pwd);
			d.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[3]/button")).click();
			Assert.assertTrue(d.findElement(By.className("LM6RPg")).isDisplayed());
			System.out.println("Successfull login");	
	}

	public static void main(String[] args) {
		
			System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
		
			FlipkartLogin ob=new FlipkartLogin();
			ob.url("https://www.flipkart.com/");
			ob.verifyInvalidUnandValidPwd("949330174","Cn012345678");
			ob.verifyValidUnandInvalidPwd("9493301749","Cn01234567");
			ob.verifyInvalidCredentials("949330174","Cn01234567");
			ob.verifyLoginUsingOnlyUn("9493301749");
			ob.verifyLoginWithOnlyPwd("Cn012345678");
		
		
			ob.verifyValidCredentials("9493301749","Cn012345678");
				 
		 
		
	}

}