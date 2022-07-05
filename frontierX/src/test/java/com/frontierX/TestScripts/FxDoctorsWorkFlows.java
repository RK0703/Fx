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
import com.frontierX.PageLibRepo.HeartHealthPageLib;
import com.frontierX.PageLibRepo.HomePageLib;
import com.frontierX.PageLibRepo.LoginPageLib;
import com.frontierX.Utilities.FxUtilities;

public class FxDoctorsWorkFlows extends FxSettings
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
	 @Test (description = "Purpose of this test is to Verify that Doctor can Login to FX WebApp")
		public void VerifyDoctorsCanLoginToFxWebApp() throws Exception
		{
		
			    String expectedText= "User Logged In Successfully";
					
			    homeObj.VerifyUserInfoPopUp(expectedText);	
		}
		
	
		@Test (description = "Purpose of this test is to Verify Doctors can search any user in our system")
		
		public void VerifyDoctrsCanSearchPatients()
		{			
					justSleepFor(3);
					homeObj.clickOnAdminMenu();
					justSleepFor(1);
					homeObj.clickOnAdminPanel();
					justSleepFor(4);
					homeObj.SearchUsers("premium@fourthfrontier.com");
					justSleepFor(2);
					homeObj.VerifyIfSearchedUserAppeared("premium@fourthfrontier.com");
		 }
		
		 
		@Test (description = "Purpose of this test is to Verify that Health Treand Web Page opens and displays related Charts for Doctor level ")
			public void VerifyHealthTreandPageDisplays_DoctorLevel() throws Exception
			{		
				HeartHealthPageLib heartHealthObj = new HeartHealthPageLib(driver);
							homeObj.ClickHealthTrendBtn();
							heartHealthObj.VerifyChartsAreDisplayed();
			}
		
		
		
		
		
		@Test (description = "Purpose of this test is to Verify that current user's name is displayed when Doctors access any user's dashboard")
		public void VerifyUserNameDisplayedOnDashboard_Doctors()
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
		
		
	//	@Test (description = "Purpose of this test is to Verify that current user's name is displayed when doctors access any user's dashboard")
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
		
		@Test(description = "Purpose of this test is to Verify Doctors can log in ")
		public void VerifyLoggedInUser_DoctorUser() throws Exception
		{		
						justSleepFor(4);
						homeObj.VerifyLoggedInUserName(UserLevel.Doctor.toString());
		}
/*
 * 
 * Healper Methods
 */
	 
		
		
		
		
}
