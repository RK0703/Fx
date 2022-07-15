package com.frontierX.PageObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.frontierX.BaseSettings.FxBasePage;

public class LoginPageObj extends FxBasePage
{

	//	Creating WebElements
	@FindBy(xpath = "//input[@id='email']") ////input[@id='email']
	protected WebElement username ;
	
	@FindBy(id = "password")
	protected WebElement password ;
	
	@FindBy(xpath = "//input[@value='Login']")
	protected WebElement loginButton ;
	
	
	@FindBy (className = "mini-toastr-notification__message")//"mini-toastr-notification__title")
	protected WebElement NotificationInfoPopUp;
	
//	@FindBy(id = "keepLoggedInCheckBox")
//	private WebElement rememberCheckbox ;
//	
//	@FindBy(linkText = "Forgot your password?")
//	private WebElement forgotPasswordLink ;
	
	
	//	Constructor
	public LoginPageObj(WebDriver driver) 
	{
		//PageFactory.initElements(driver, this);
		super(driver);
	}
	
	//	Creating Action Methods
	public HomePageObj login(String usernameValue, String passwordValue) {
		username.sendKeys(usernameValue);
		password.sendKeys(passwordValue);
		loginButton.click();
		return new HomePageObj(driver);
	}
	
//	public void clickRememberCheckBox() {
//		rememberCheckbox.click();
//	}
//	
//	public void forgotPasswordLink() {
//		forgotPasswordLink.click();
//	}
	
	
}
