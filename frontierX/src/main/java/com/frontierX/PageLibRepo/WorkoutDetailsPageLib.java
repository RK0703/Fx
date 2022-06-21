package com.frontierX.PageLibRepo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.testng.Assert;

import com.frontierX.PageObjectRepo.WorkoutDetailsPageObj;

public class WorkoutDetailsPageLib extends WorkoutDetailsPageObj
{

	List<String> browserTabs = new ArrayList<String> (driver.getWindowHandles());
	
	//private String insightText = null;
	
	////div[@class='insights-notes']
	//	Constructor
	public WorkoutDetailsPageLib(WebDriver driver) 
	{
		super(driver);
	}
	
	
	public void clickAddNotes() throws InterruptedException
	{
		Thread.sleep(8000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", AddNotes);
		
		AddNotes.click();
		Thread.sleep(2000);
	}
	
	
	public void EnterNote(String Note)
	{
		NoteTextArea.sendKeys(Note);
		
	}
	
	public void clickSaveButton()
	{
		SaveButton.click();
	}
	
	public void VerifyECGGraphIsDisplayed() throws InterruptedException
	{
		Thread.sleep(7000);
		//get window handlers as list
		List<String> browserTabs = new ArrayList<String> (driver.getWindowHandles());
		//switch to new tab
		driver.switchTo().window(browserTabs .get(1));
		Assert.assertTrue(ECGBlock1.isDisplayed(),"ECG Block 1 is displayed");
		Assert.assertTrue(ECGBlock2.isDisplayed(),"ECG BLock 2 is diaplayed");
		driver.close();
		driver.switchTo().window(browserTabs.get(0));
		
	}

	
	public void ClickOnInfoButtons() throws InterruptedException
	{
		Thread.sleep(5000);
		System.out.println("There are---------------------------------------> "+ECGInfoButtons.size());
		ECGInfoButtons.get(1).click();
		
	}
	
	
	
	public void VerifyECGGraphIsDisplayed_Admin() throws InterruptedException
	{
		Thread.sleep(7000);
		//get window handlers as list
		List<String> browserTabs = new ArrayList<String> (driver.getWindowHandles());
		//switch to new tab
		driver.switchTo().window(browserTabs .get(2));
		Assert.assertTrue(ECGBlock1.isDisplayed(),"ECG Block 1 is displayed");
		Assert.assertTrue(ECGBlock2.isDisplayed(),"ECG BLock 2 is diaplayed");
		driver.close();
		driver.switchTo().window(browserTabs.get(0));
		
	}
	
	public void ClickOnHeartRateGraph() throws InterruptedException
	{
		
		Thread.sleep(3000);
		Thread.sleep(7000);
		//get window handlers as list
		List<String> browserTabs = new ArrayList<String> (driver.getWindowHandles());
		//switch to new tab
		driver.switchTo().window(browserTabs .get(2));
		ScrollTillElement(ECGBlock2);
		HeartRateGraph.click();
	}
	
	public void SelectAnnotation(String annotation)
	{
		switch(annotation)
		{
		case "Normal" :
			AnnotationWindow.findElement(By.id("radCreateMode")).click();
			break;
			
		case "AFib" :
			AnnotationWindow.findElement(By.id("radCreateMode1")).click();
			break;
		
		case "NSVT" :
		AnnotationWindow.findElement(By.id("radCreateMode4")).click();
		break;
			
		default:
			System.out.println("Invalid Annotation");
		
		
		}
	}
	

	
	public void VerifyHeartRateBlockIsDisplayed() throws InterruptedException
	{
		Thread.sleep(7000);
		//get window handlers as list
		List<String> browserTabs = new ArrayList<String> (driver.getWindowHandles());
		//switch to new tab
		driver.switchTo().window(browserTabs .get(1));
		Assert.assertTrue(HeartRateBlock.isDisplayed(),"Heart Rate Block is displayed");
		
		driver.close();
		driver.switchTo().window(browserTabs.get(0));
	}
	

	public void VerifyBreathingRateIsDisplayed() throws InterruptedException
	{
		Thread.sleep(7000);
		//get window handlers as list
		List<String> browserTabs = new ArrayList<String> (driver.getWindowHandles());
		//switch to new tab
		driver.switchTo().window(browserTabs .get(1));
		Assert.assertTrue(HeartRateBlock.isDisplayed(),"Heart Rate Block is displayed");
		
		driver.close();
		driver.switchTo().window(browserTabs.get(0));
	}
	
	public void VerifyBodyShockBlockIsDisplayed() throws InterruptedException
	{
		Thread.sleep(7000);
		ScrollTillElement(HRVBlock);
		//get window handlers as list
		List<String> browserTabs = new ArrayList<String> (driver.getWindowHandles());
		//switch to new tab
		driver.switchTo().window(browserTabs .get(1));
		Assert.assertTrue(BodyShock.isDisplayed(),"Body Shock section is displayed");
		
		driver.close();
		driver.switchTo().window(browserTabs.get(0));
	}
	
	public void VerifyStepCadenceBlockIsDisplayed() throws InterruptedException
	{
		Thread.sleep(7000);
		ScrollTillElement(HRVBlock);
		//get window handlers as list
		List<String> browserTabs = new ArrayList<String> (driver.getWindowHandles());
		//switch to new tab
		driver.switchTo().window(browserTabs .get(1));
		Assert.assertTrue(StepCadence.isDisplayed(),"Step Cadence section is displayed");
		
		driver.close();
		driver.switchTo().window(browserTabs.get(0));
	}
	
	
	
	public void VerifyCardiacStrainBlockIsDisplayed() throws InterruptedException
	{
		Thread.sleep(1000);
		ScrollTillElement(CardiacStrain);
		//get window handlers as list
		List<String> browserTabs = new ArrayList<String> (driver.getWindowHandles());
		//switch to new tab
		driver.switchTo().window(browserTabs .get(1));
		Assert.assertTrue(CardiacStrain.isDisplayed(),"Cardiac block is displayed");
		
		driver.close();
		driver.switchTo().window(browserTabs.get(0));
	}
	
	public void VerifyHRVBlockIsDisplayed() throws InterruptedException
	{
		Thread.sleep(7000);
		ScrollTillElement(HRVBlock);
		//get window handlers as list
		List<String> browserTabs = new ArrayList<String> (driver.getWindowHandles());
		//switch to new tab
		driver.switchTo().window(browserTabs .get(1));
		Assert.assertTrue(HRVBlock.isDisplayed(),"HRV Block is displayed");
		
		driver.close();
		driver.switchTo().window(browserTabs.get(0));
	}
	
	
	public int GetTrainingLoadValue()
	{
		SwitchTab();
		List<WebElement> allChildElements = TrainingLoadCard.findElements(By.xpath("*"));
		// Extracting just number from the string that contains training load and parsing it to int for further assertions
		return Integer.parseInt(allChildElements.get(1).getText().replaceAll("[^0-9]", ""));
	}
	
	
	public boolean VerifyAddNotePopUpDisplays() throws InterruptedException
	{
		Thread.sleep(4000);
		ScrollTillElement(AddNotePopUp);
		Thread.sleep(4000);
		return AddNotePopUp.isDisplayed();
	}
	

	
	public void SwitchTab()
	{
		List<String> browserTabs = new ArrayList<String> (driver.getWindowHandles());
		//switch to new tab
		driver.switchTo().window(browserTabs .get(1));
		//Thread.sleep(7000);
	}
	
	private void CloseTab(WebDriver driver,List<String> tabs)
	{
		driver.switchTo().window(tabs.get(1)).close();;
	}
	
	
	public String  GetDuriation()
	{
		SwitchTab();
		//Thread.sleep(7000);
		List<WebElement> DuriantionCard = duriation.findElements(By.xpath("./child::*"));
		String durationVal =  DuriantionCard.get(1).getText();
		
		CloseTab(driver,browserTabs);
		return durationVal;
	}
	
	
	public String GetWorkOutDetails11()
	{
		SwitchTab();
		List<WebElement> DuriantionCard = duriation.findElements(By.xpath("./child::*"));
		String durationVal =  DuriantionCard.get(1).getText();
		 
		
		return durationVal;
		
	}
	/*
	 * 
	 * this is RnD method.. 
	 */
	
	public void printsChilds()
	{
		Hashtable<String, String> workoutDetails = new Hashtable<String, String>();
		int j=0;
		int child = 0;
		SwitchTab();
		
		
		List<WebElement> TLCard = TrainingInofs.get(2).findElements(By.xpath("./child::*"));
		System.out.println("God knows whats here\n"+TLCard.get(0).getText());
		System.out.println("God knows whats here\n"+TLCard.get(1).getText());
		System.out.println("God knows whats here\n"+TLCard.get(2).getText());
		//TrainingInofs.get(1).getText();
		
		
		
		
		
		System.out.println("Training info class found "+TrainingInofs.size()+" times");
		for (WebElement cards : TrainingInofs)
		{
			;
			System.out.println("******At Position :"+j+"****");
			
			List<WebElement> kids = cards.findElements(By.xpath("./child::*"));
			
			for(WebElement kid : kids)
			{
			//	int j = 0;
				System.out.println(child +" : child "+kid.getText());
				child++;
				
				//workoutDetails.put(kid.getText(), null)
				
			}
			
			System.out.println("********End*********");
			j++;
		}
	}
		
		public Hashtable<String, String> GetWorkOutDetails() 
		
		{
			  
			Hashtable<String, String> workoutDetails = new Hashtable<String, String>();
		 //   List<WebElement> Cards = TrainingInofs.findElements(By.xpath("./child::*"));
		   
		    
		    
		 //   String durationVal =  DuriantionCard.get(1).getText();
		    String HRValue ;
		    
		    
		    
		  //  workoutDetails.put("Duriation Value", durationVal);
		    workoutDetails.put("HRValue ","" );
		  
		    return workoutDetails;
		}
		
		
	/*	List<WebElement> kids = DerivedParameters.findElements(By.xpath("./child::*"));
		
		for(WebElement c : kids)
		{
			int j = 0;
			System.out.println(j+": position"+c.getTagName());
			j++;
		}
		*/

	
	public void ScrollTillElement(WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		
		
	}
	
	public void AssertInsightInfo() throws InterruptedException
	{
		SwitchTab();
		ScrollTillElement(InsightNotes);
		Thread.sleep(2000);
		
		//System.out.print("Insight Text is "+GetInsightText());
		Assert.assertTrue(InsightNotes.getText().contains(GetDateAsPerInsightTitle()), "Insights are displayed for today's workout");
	
		// Asserts Insight Body
		//Assert.assertTrue(InsightNotes.getText().contains("Activity intensity:"),"Contains Activity intensity");
		//Assert.assertTrue(InsightNotes.getText().contains("Average strain:"),"Contains Avg strain");
		//Assert.assertTrue(InsightNotes.getText().contains("Training load:"),"Contains Info About Training Load");
		
		//CloseTab(driver,browserTabs);
	}
	
	
	public String GetDateAsPerInsightTitle()
	{
		String dayOfWeek = new SimpleDateFormat("EEEE").format(new Date());
		String CurrentDate= new SimpleDateFormat("dd").format(new Date());
		String CurrentMonth= new SimpleDateFormat("MMMM").format(new Date());
		String CurrentYear= new SimpleDateFormat("YYYY").format(new Date());
		
		return "Summary for workout on "+dayOfWeek+","+" "+CurrentDate+" "+CurrentMonth+" "+CurrentYear+" at";
	
	}
	
	
}
