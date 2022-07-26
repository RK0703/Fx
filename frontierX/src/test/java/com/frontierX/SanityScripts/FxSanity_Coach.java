package com.frontierX.SanityScripts;
import org.openqa.selenium.WebDriver;
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
import com.frontierX.Utilities.FxUtilities;

public class FxSanity_Coach extends FxSettings
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
	 homeObj = login.login("trainer@fourthfrontier.com",FxUtilities.DecryptPass("MTIzNDEyMzQ="));
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
		public void VerifyCoachCanLoginToFxWebApp() throws Exception
		{
		
			    String expectedText= "User Logged In Successfully";
					
			    homeObj.VerifyUserInfoPopUp(expectedText);	
		}
		
	
		
	 @Test(description = "Purpose of this test is to Verify Fx Coach platform name is displayed ")
		public void VerifyFCPNameOnAdminPanel() throws Exception
		{		
			justSleepFor(3);
			homeObj.clickOnAdminMenu();
			justSleepFor(1);
			homeObj.VerifyFCPName();
		}
	 
	 @Test (description = "Purpose of this test is to Verify that Health Treand Web Page opens and displays related Charts for Trainer level ")
		public void VerifyHealthTreandPageDisplays_TrainerLevel() throws Exception
		{		
			HeartHealthPageLib heartHealthObj = new HeartHealthPageLib(driver);
						homeObj.ClickHealthTrendBtn();
						heartHealthObj.VerifyChartsAreDisplayed();
		} 
	 
	 
	 @Test(description = "Purpose of this test is to Verify Elements in Web App for FCP User")
		public void VerifyHomePageElements_FCPUser() throws Exception
		{		
						justSleepFor(4);
						homeObj.VerifyHomePageElements();
		}
	 
		
/*
 * 
 * Healper Methods
 */
	 
		
		
		
		
}
