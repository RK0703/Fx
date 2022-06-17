package com.frontierX.BaseSettings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;

public class FxBasePage 

{
	
	protected WebDriver driver ;

	public FxBasePage(WebDriver driver)
	{
		this.driver = driver ;
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean verifyPageTitle(String title)
	{
		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver, 20);
		return wait.until(ExpectedConditions.titleIs(title));
	}


@AfterTest
public void EndAutomation()
{
	System.out.print("After Suite : Quitting Driver");
	driver.quit();
}


}

