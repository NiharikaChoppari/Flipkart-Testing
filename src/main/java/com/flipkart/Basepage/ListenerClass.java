package com.flipkart.Basepage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerClass extends BasePage implements ITestListener,Runnable {

	public void onTestStart(ITestResult result) {

	}

	public void onTestSuccess(ITestResult result) {
		
		 
	}

	public void onTestFailure(ITestResult result) {

		/* String failedTestName = result.getName().toString();
		System.out.println(failedTestName + "FAILED");
		try {
			screenshot(failedTestName);
		} catch (IOException e) {
			e.printStackTrace();
		} */
	}

	public void onTestSkipped(ITestResult result) {

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}
	
	
	public void onStart(ITestContext context) {

		System.out.println("Inside onStart method");
		String browserName = context.getCurrentXmlTest().getParameter("browser");
		System.out.println(browserName);
		System.out.println("Executing "+browserName+" browser in "+Thread.currentThread().getId());
		WebDriver d = BasePage.getDriver(browserName);
		DriverFactory.setDriver(d);
		d=DriverFactory.getDriver();
		d.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
		d.manage().window().maximize();
		System.out.println("Initiating " + browserName + " browser");

	}

	public void onFinish(ITestContext context) {
		
		d=null;
	}

}
