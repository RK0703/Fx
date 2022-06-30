package com.frontierX.SanityScripts;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.frontierX.BaseSettings.FxSettings;
import com.frontierX.PageLibRepo.HeartHealthPageLib;
import com.frontierX.PageLibRepo.HomePageLib;
import com.frontierX.PageLibRepo.LoginPageLib;
import com.frontierX.PageLibRepo.WorkoutDetailsPageLib;
import com.frontierX.Utilities.FxUtilities;

public class FxSanity_User extends FxSettings 
{	
	 WebDriver driver = null ;
	 LoginPageLib loginObj ;
	 HomePageLib homeObj ;
	 
	 String ClassName = this.getClass().getSimpleName().toString();
	 @Parameters({ "enivironment" })
	 @BeforeMethod
    private void Initialize(String env)
    {
	 this.driver = DecideEnvironment(env);
	 loginObj = new LoginPageLib(driver);
	 homeObj = loginObj.login("ravikiran@fourthfrontier.com",FxUtilities.DecryptPass("MTIzNDEyMzQ="));
    }

	 @AfterMethod
	 private void CloseDriverSession(ITestResult result) throws Exception
	 {
		 if (result.getStatus() == ITestResult.FAILURE) 
		 {
			 FxUtilities.createWorkFlowFolder(ClassName);
			 FxUtilities.CaptureEvidance(driver,result.getMethod().getMethodName(),result,ClassName);
			 System.out.println(result.getMethod().getMethodName()+" Test Failed Due to the reason\n"+result.getThrowable().getMessage());
		 }        
		 driver.quit();
	 }
	
	 
@BeforeClass
private void SetEvidenceDir()
{
	FxUtilities.createDateBasedDirectory();
	
}
	
	@Test (description = "Purpose of this test is to Verify that User can Sync his activity and it is being displayed")
	public void VerifyActivitySync() throws Exception
	{			
				
					homeObj.VerifyTodaysActivityIsDisplayed();
					
	}
	   
	@Test(description = "Purpose of this test is to Verify Training load on home page and Workout details page are same")
	public void VerifyTrainingLoad() throws Exception
	{	
		WorkoutDetailsPageLib wd = new WorkoutDetailsPageLib(driver);
		justSleepFor(3);
		int TLHomePage = homeObj.GetTrainingLoad_ActivityLevel();
		homeObj.clickOnGreenTick();
		wd.SwitchTab();
		justSleepFor(7);
		Assert.assertEquals(TLHomePage, wd.GetTrainingLoadValue()) ;
	}

	
	@Test (description = "Purpose of this test is to Verify that ECG has been synced and Green Tick mark is visble ")
	public void VerifyECGSyncIsSuccessfull() throws Exception
	{		
		WorkoutDetailsPageLib workoutObj = new WorkoutDetailsPageLib(this.driver);
				
			homeObj.VerifyTodaysECGIsSynced();
			homeObj.clickOnGreenTick();
			workoutObj.VerifyECGGraphIsDisplayed();
	 }
	    
	@Test (description = "Purpose of this test is to Verify that user can Download and verify Current Day's FIT File and verifies if its valid or not based on length of file")
	public void VerifyUserCanDownloadLatestFITFiles() throws Exception
	{
	    String ext = ".fit";
	
				FxUtilities.deleteFiles(ext);
				justSleepFor(6);
				
					homeObj.clickOnActivityButton();
					homeObj.clickOnDownloadFIT();
					System.out.println("FIT File option was clicked for user");
					justSleepFor(4);
					Assert.assertTrue(FxUtilities.isCurrentDaysFileDownloaded(ext),"Fit File downloaded");
				driver.close();	
	}
	
	@Test (description = "Purpose of this test is to Verify that User can Edit the Activity and save it")
	public void VerifyEditedActivity() throws Exception 
	{
			
			homeObj.clickOnActivityButton();
			justSleepFor(3);
			homeObj.editActivity();
			justSleepFor(3);
			homeObj.EnterText_EditActivity();
			justSleepFor(3);
			homeObj.VerifyEditedTextDisplayed();
			justSleepFor(3);
			homeObj.logout();
	}
	
	
	@Test (description = "Purpose of this test is to Verify if Insights are displayed or not ")
	public void VerifyInsightInfoAreDisplayed() throws Exception
	{		
		WorkoutDetailsPageLib wd = new WorkoutDetailsPageLib(driver);
				
					homeObj.VerifyTodaysActivityIsDisplayed();
					homeObj.clickOnGreenTick();
					justSleepFor(7);
					wd.AssertInsightInfo();
	}
	
	
	@Test (description = "Purpose of this test to verify Add Report button and Section is working as expected")
	public void VerifyAddReportSection() throws Exception
	{		
		Thread.sleep(3000);
		homeObj.ClickAddReportBtn();
		Thread.sleep(3000);
		homeObj.VerifyAddReportScreen();
	}
	

	@Test (description = "Purpose of this test is to Verify that Health Treand Web Page opens and displays related Charts ")
	public void VerifyHealthTreandPageDisplays() throws Exception
	{		
		HeartHealthPageLib heartHealthObj = new HeartHealthPageLib(driver);
					homeObj.ClickHealthTrendBtn();
					heartHealthObj.VerifyChartsAreDisplayed();
	}
}
