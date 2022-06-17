package com.frontierX.PageObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.frontierX.BaseSettings.FxBasePage;

public class HeartHealthPageObj extends FxBasePage
{

	//	Creating WebElements
	@FindBy(id = "chartarr")
	protected WebElement OtherRhythmChart ;
	
	@FindBy(id = "charthr")
	protected WebElement AvgHRChart ;
	
	@FindBy(id = "chartst")
	protected WebElement AvgSTChart ;
	
	@FindBy(id = "charthrv")
	protected WebElement AvgHRVChart ;
	
	@FindBy(id = "chartbr")
	protected WebElement AvgBRChart ;
	
	
	
	//	Constructor
	public HeartHealthPageObj(WebDriver driver) 
	{
		//PageFactory.initElements(driver, this);
		super(driver);
	}
	
}
