package com.frontierX.TestScripts;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.frontierX.BaseSettings.FxSettings;
import com.frontierX.PageLibRepo.HomePageLib;
import com.frontierX.PageLibRepo.LoginPageLib;
import com.frontierX.Utilities.FxUtilities;

public class FxCoachWorkFlows extends FxSettings
{	
	 WebDriver driver = null ;
	 LoginPageLib login ;
	 HomePageLib homeObj ;
	 String expectedInfoTxt = "User's information updated successfully." ;
	 String ClassName = this.getClass().getSimpleName().toString();
	 @Parameters({ "enivironment" })
	 @BeforeMethod
    private void Initialize(String env)
    {
	 this.driver = DecideEnvironment(env);
	 login = new LoginPageLib(driver);
	 homeObj = login.login("doctor@fourthfrontier.com",FxUtilities.DecryptPass("YXV0b21hdGlvbjRm"));
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
	 @Test (description = "Purpose of this test is to Verify that Fx Coach can Login to FX WebApp")
		public void VerifyTrainersCanLoginToFxWebApp() throws Exception
		{
		
			    String expectedText= "User Logged In Successfully";
					
			    homeObj.VerifyUserInfoPopUp(expectedText);	
		}
		
	
		
	 @Test(description = "Purpose of this test is to Verify Fx Coach platform name is displayed ")
		public void VerifyFCPName() throws Exception
		{		
			justSleepFor(3);
			homeObj.clickOnAdminMenu();
			justSleepFor(1);
			homeObj.VerifyFCPName();
			
		}
		
/*
 * 
 * Healper Methods
 */
	 
		
		
		
		
}
