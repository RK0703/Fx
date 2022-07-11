package com.frontierX.TestScripts;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.frontierX.BaseSettings.FxSettings;
import com.frontierX.PageLibRepo.AdminPageLib;
import com.frontierX.PageLibRepo.HomePageLib;
import com.frontierX.PageLibRepo.LoginPageLib;
import com.frontierX.Utilities.FxUtilities;

public class PlayArea extends FxSettings
{	
	 WebDriver driver = null ;
	 LoginPageLib login ;
	 HomePageLib homeObj ;
	 AdminPageLib adminLib;
	 String expectedInfoTxt = "User's information updated successfully." ;
	 
	 String ClassName = this.getClass().getSimpleName().toString();
	 
	 @Parameters({ "enivironment" })
	 @BeforeMethod
    private void Initialize(String env)
    {
	 this.driver = DecideEnvironment(env);
	 login = new LoginPageLib(driver);
	 adminLib = new AdminPageLib(driver);
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

@Test (description = "Purpose of this test is to Verify that User Can Add Health Tag and Verifies if its displayed on Web App and Delete the same")
	public void VerifyHealthEntryAddedAndDeleted() throws Exception
	
	{	
				String DeleteTagNotificationText = "Health Entry Deleted: 1";
				String ExpectedVal = "SpO2 - 98 %";
				Thread.sleep(6000);
					homeObj.ClickOnAddHealtEntry();
					homeObj.SelectVitals();
					homeObj.ClickOnsPO2Tag();
					homeObj.EnterHealthTagDetails("98","Test");
					Thread.sleep(4000);
					homeObj.VerifyHealthTagIsDisplayed(ExpectedVal);
					
					// Delete the tag and verify the same
					Thread.sleep(3000);
					homeObj.clickOnActivityButton();
					homeObj.ClickOnDeleteTag();
					Thread.sleep(2000);
					//homeObj.VerifyDeletePopUpText();
					Thread.sleep(3000);
					//homeObj.ClickOnDeleteBtn_Tag();
					Assert.assertEquals(homeObj.GetNotificationText(),DeleteTagNotificationText);
	}

/*
 * 
 * 
 * Healper Methods
 */
	
		
	
}
