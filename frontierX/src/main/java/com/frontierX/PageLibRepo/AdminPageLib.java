package com.frontierX.PageLibRepo;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.frontierX.PageObjectRepo.AdminPageObj;


public class AdminPageLib extends AdminPageObj
{

	public AdminPageLib(WebDriver driver) 
	{
		super(driver);
		// TODO Auto-generated constructor stub
	}
		
	/*
	 * Method to click on Add Coach button
	 */
	public void ClickOnAddCoachButton()
	{
		//AddCoachBtn.click();
	}
	
	/*
	 * Method to click on Add Coach button
	 
	public void VerifyAddCoachPopUp()
	{
		Assert.assertTrue(Coach_FirstName.isDisplayed());
		Assert.assertTrue(Coach_LastName.isDisplayed());
		Assert.assertTrue(Coach_email.isDisplayed());
		Assert.assertTrue(Coach_deviceLink.isDisplayed());
		
	}
	
	*/
	

	
	
}
