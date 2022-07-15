package com.frontierX.PageLibRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.frontierX.PageObjectRepo.HomePageObj;
import com.frontierX.PageObjectRepo.LoginPageObj;

public class LoginPageLib extends LoginPageObj
{
	
//	@FindBy(id = "keepLoggedInCheckBox")
//	private WebElement rememberCheckbox ;
//	
//	@FindBy(linkText = "Forgot your password?")
//	private WebElement forgotPasswordLink ;
	
	
	//	Constructor
	public LoginPageLib(WebDriver driver) 
	{
		//PageFactory.initElements(driver, this);
		super(driver);
	}
	
	//	Creating Action Methods
	public HomePageLib login(String usernameValue, String passwordValue) 
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
		username.sendKeys(usernameValue);
		password.sendKeys(passwordValue);
		loginButton.click();
		return new HomePageLib(driver);
	}
	
	
	public void TryLogin(String usernameValue, String passwordValue) 
	{
		username.sendKeys(usernameValue);
		password.sendKeys(passwordValue);
		loginButton.click();
	}
	
	
	
	public void VerifyUserInfoPopUp(String expectedInfoTxt)
	{
		Assert.assertEquals(NotificationInfoPopUp.getText(), expectedInfoTxt,"Found Expected text is "+expectedInfoTxt);
	}
	
	
	
}
