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
import com.frontierX.Utilities.FxUtilities;

public class FxSanity_PremiumUser extends FxSettings
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
	 homeObj = login.login("premium@fourthfrontier.com",FxUtilities.DecryptPass("YXV0b21hdGlvbjRm"));
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
	
	 @Test (description = "Purpose of this test is to Verify that premium user can Login to FX WebApp")
		public void VerifyPremiumUsersCanLoginToFxWebApp() throws Exception
		{
		
			    String expectedText= "User Logged In Successfully";
					
			    homeObj.VerifyUserInfoPopUp(expectedText);	
			    justSleepFor(4);
				homeObj.VerifyLoggedInUserName(UserLevel.Premium.toString());
		}
	 
		
	 @Test (description = "Purpose of this test is to Verify that Premium user can Download FIT File and verifies if its valid or not based on length of file")
		public void VerifyPremiumUserCanDownloadFITFiles() throws Exception
		{
		 
						justSleepFor(4);			
						homeObj.enterWorkout("Fit_Sanity");
					//	justSleepFor(6);
						homeObj.clickOnActivityButton();
						homeObj.clickOnDownloadFIT();
						justSleepFor(3);
						Assert.assertTrue(FxUtilities.isFxFileDownloaded("346070.fit")," Fit File is downloaded");	
		}
		

		@Test (description = "Purpose of this test is to Verify that Health Treand Web Page opens and displays related Charts for Premium User level ")
			public void VerifyHealthTreandPageDisplays_PremiumUserLevel() throws Exception
			{		
				HeartHealthPageLib heartHealthObj = new HeartHealthPageLib(driver);
							homeObj.ClickHealthTrendBtn();
							heartHealthObj.VerifyChartsAreDisplayed();
			}
		
		
		@Test(description = "Purpose of this test is to Verify Elements in Web App for Premium User")
		public void VerifyHomePageElements_PremiumUser() throws Exception
		{		
						justSleepFor(4);
						homeObj.VerifyHomePageElements();
		}
			
/*
 * 
 * Healper Methods
 */
	 
		
		
		
		
}
