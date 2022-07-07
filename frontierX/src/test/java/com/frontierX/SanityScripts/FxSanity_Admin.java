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

public class FxSanity_Admin extends FxSettings
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
	 homeObj = login.login("admin@fourthfrontier.com", FxUtilities.DecryptPass("YXV0b21hdGlvbjRm"));
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
	  
	//	@Test (description = "Purpose of this test is to Verify that admin can change the User Level and enable Arrhythmia and that change will remain intact")
		public void VerifyUserLevelChangesAreSaved()
		{
				ChangeUserSettings(homeObj);
				// Log out after changes and log in back
				homeObj.logout();
				homeObj = login.login("admin@fourthfrontier.com",FxUtilities.DecryptPass("YXV0b21hdGlvbjRm"));
				
				VerifyChangedUserSettingsAreStillIntact(homeObj);
			
				justSleepFor(3);
			// Revert the user back to non premium user for next run
				RevertChangesForNextRun(homeObj);
		}
		
		@Test (description = "Purpose of this test is to Verify admin can search any user in our system")
		public void VerifyAdminSearch()
		{			
					justSleepFor(3);
					homeObj.clickOnAdminMenu();
					justSleepFor(1);
					homeObj.clickOnAdminPanel();
					justSleepFor(4);
					homeObj.SearchUsers("ravikiran@fourthfrontier.com");
					justSleepFor(2);
					homeObj.VerifyIfSearchedUserAppeared("ravikiran@fourthfrontier.com");		
		 }
		
		@Test (description = "Purpose of this test is to Verify admin can search any user in our system")
		public void VerifyUserLevelsAvailable()
		{			
					justSleepFor(3);
					homeObj.clickOnAdminMenu();
					justSleepFor(1);
					homeObj.clickOnAdminPanel();
					justSleepFor(4);
					homeObj.SearchUsers("ravikiran@fourthfrontier.com");
					justSleepFor(2);
					homeObj.VerifyIfSearchedUserAppeared("ravikiran@fourthfrontier.com");
					
		 }
		
		@Test (description = "Purpose of this test is to Verify that current user's name is displayed when admin access any user's dashboard")
		public void VerifyUserNameDisplayedOnDashboard()
		{			
					String UserName = "Ravikiran";
					justSleepFor(3);
					homeObj.clickOnAdminMenu();
					justSleepFor(1);
					homeObj.clickOnAdminPanel();
					justSleepFor(4);
					homeObj.SearchUsers("ravikiran@fourthfrontier.com");
					justSleepFor(2);
					homeObj.VerifyIfSearchedUserAppeared("ravikiran@fourthfrontier.com");
					homeObj.SelectDisplyedUser();
					justSleepFor(6);
					homeObj.VerifyUserNameIsDisplayedForUser(UserName);			
		 }
		
		 @Test(description = "Purpose of this test is to Verify Levels of users in our system")
			public void VerifyUserLevelsDropDown() throws InterruptedException 
			{		
				justSleepFor(3);
				homeObj.clickOnAdminMenu();
				justSleepFor(1);
				homeObj.clickOnAdminPanel();
				justSleepFor(4);
				homeObj.SearchUsers("ravikiran@fourthfrontier.com");
				justSleepFor(2);
				homeObj.VerifyIfSearchedUserAppeared("ravikiran@fourthfrontier.com");
				homeObj.VerifyUserLevelOptions();
			}
	//	@Test (description = "Purpose of this test is to Verify that current user's name is displayed when admin access any user's dashboard")
		public void VerifyECGPDFPopUp()
		{			
					String UserName = "Ravikiran";
					justSleepFor(3);
					homeObj.clickOnAdminMenu();
					justSleepFor(1);
					homeObj.clickOnAdminPanel();
					justSleepFor(4);
					homeObj.SearchUsers("ravikiran@fourthfrontier.com");
					justSleepFor(2);
					homeObj.VerifyIfSearchedUserAppeared("ravikiran@fourthfrontier.com");
					homeObj.SelectDisplyedUser();
					justSleepFor(6);
					homeObj.VerifyUserNameIsDisplayedForUser(UserName);	
					homeObj.clickOnActivityButton();
					homeObj.ClickgenerateECGPDF();
					homeObj.VerifyECGPDFPopUp();
		 }
		
		@Test(description = "Purpose of this test is to Verify if Admin can login in")
		public void VerifyLoggedInUser_AdminUser() throws Exception
		{		
						justSleepFor(4);
						homeObj.VerifyLoggedInUserName(UserLevel.Admin.toString());
		}
		
		
		@Test (description = "Purpose of this test is to Verify that Health Treand Web Page opens and displays related Charts for Admin level ")
		public void VerifyHealthTreandPageDisplays_AdminLevel() throws Exception
		{		
			HeartHealthPageLib heartHealthObj = new HeartHealthPageLib(driver);
						homeObj.ClickHealthTrendBtn();
						heartHealthObj.VerifyChartsAreDisplayed();
		}
		
/*
 * 
 * 
 * Healper Methods
 */
	 public void ChangeUserSettings(HomePageLib hp)
		{
			
			justSleepFor(3);
			hp.clickOnAdminMenu();
			justSleepFor(1);
			hp.clickOnAdminPanel();
			justSleepFor(4);
			hp.SearchUsers("ravikiran@fourthfrontier.com");
			justSleepFor(2);
			hp.VerifyIfSearchedUserAppeared("ravikiran@fourthfrontier.com");
			justSleepFor(4);
			hp.SelectUserLevel(1);
			justSleepFor(3);
			hp.GetNotificationText();
			hp.VerifyUserInfoPopUp(expectedInfoTxt);
			hp.EnableArrhytmia();
			justSleepFor(3);
			Assert.assertTrue(hp.CheckIfArrhytmiaIsEnabled(), "Arrhytmia is Enabled");
		}
		public void VerifyChangedUserSettingsAreStillIntact(HomePageLib hp)
		{
			hp.clickOnAdminMenu();
			justSleepFor(1);
			hp.clickOnAdminPanel();
			justSleepFor(4);
			hp.SearchUsers("ravikiran@fourthfrontier.com");
			justSleepFor(2);
			//smartWait()
			hp.VerifyIfSearchedUserAppeared("ravikiran@fourthfrontier.com");
			hp.VerifyUserLevel("Premium User");
			Assert.assertTrue(hp.CheckIfArrhytmiaIsEnabled(), "Arrhytmia is Enabled");
		}
		public void RevertChangesForNextRun(HomePageLib hp)
		{
			justSleepFor(2);
			hp.SelectUserLevel(0);
			hp.VerifyUserInfoPopUp(expectedInfoTxt);
			hp.DisableArrhytmia();
			Assert.assertFalse(hp.CheckIfArrhytmiaIsEnabled(), "Arrhytmia is Disabled");
			justSleepFor(5);
		}
		
}
