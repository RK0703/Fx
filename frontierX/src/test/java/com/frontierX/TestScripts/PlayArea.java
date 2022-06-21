package com.frontierX.TestScripts;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
import com.frontierX.PageLibRepo.WorkoutDetailsPageLib;
import com.frontierX.Utilities.FxUtilities;

public class PlayArea extends FxSettings
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
	 homeObj = login.login("ravikiran@fourthfrontier.com",FxUtilities.DecryptPass("MTIzNDEyMzQ="));
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
		
	
		
	
		
@Test(description = "Purpose of this test is to Verify if Admin can login in")
public void PrintTL() throws Exception
{		
	WorkoutDetailsPageLib wd = new WorkoutDetailsPageLib(driver);
	justSleepFor(3);
	int TLHomPage = homeObj.GetTrainingLoad_ActivityLevel();
	//System.out.println("Training load is "+homeObj.GetTrainingLoad_ActivityLevel());
	homeObj.clickOnGreenTick();
	wd.SwitchTab();
	justSleepFor(7);
	Assert.assertEquals(TLHomPage, wd.GetTrainingLoadValue()) ;
	/*
	String path = "//body/div[@id='app']/div/div[@class='wrapper row-offcanvas']/aside[@class='right-aside']/section[@class='content']/div/div[@class='header-information']/div[@class='training-statistics']/div[@class='my-col-1 my-md-col-2 my-sm-col-3']/div[1]";
	WebElement a = driver.findElement(By.xpath(path));
	
	List<WebElement> allChildElements = a.findElements(By.xpath("*"));
	
	//System.out.println("Parent has these many childs "+allChildElements.size());
	
		System.out.println("2nd element has this text"+allChildElements.get(1).getText());
		
		

	//	System.out.println("2nd element has this text"+Integer.parseInt(digits));
		//System.out.println(digits);
		
		Assert.assertEquals(TLHomPage, Integer.parseInt(digits),"Training load are not equal");
		
	//}
	//System.out.println("Training load in runner page "+homeObj.GetTrainingLoad_RunPage());
	//homeObj.VerifyFCPName();
	*/
}
/*
 * 
 * 
 * Healper Methods
 */
	
		
	
}
