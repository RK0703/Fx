package com.frontierX.PageLibRepo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.frontierX.BaseSettings.FxSettings;
import com.frontierX.BaseSettings.FxSettings.UserLevel;
import com.frontierX.PageObjectRepo.HomePageObj;
import com.frontierX.Utilities.FxUtilities;


public class HomePageLib extends HomePageObj
{

	public HomePageLib(WebDriver driver) 
	{
		super(driver);
		// TODO Auto-generated constructor stub
	}

		private Date date = new Date();  
		private SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");  
	  
		String strDate = formatter.format(date);
		String SmokeTestString = "Regression test on "+strDate;
	
		String a = "C:\\Users\\user\\eclipse-workspace\\frontierX\\target\\surefire-reports\\testng-results.xml";
	
		String DeleteTagText = "This tag will no longer be accessible in both your app and web-app.";
		private	String HealthEntryInfoMsg = "Health entry added";
		
		private List<String> ExpectedUserList = Arrays.asList("User", "FCP User", "Premium User","FHP Premium User","Doctor","Coach","FCP Sales","FHP Doctor","Admin");
	
		private List<String> ReportsOptions = Arrays.asList("12 Lead ECG", "Angiogram", "Blood Test","Ct Scan","Discharge Summary","Echocardiogram","Holter ","MRI Scan","Nuclear Scan","Procedure Summary","Stress Test","Other");
	
		
		//ExpectedUserList.
	
	//	Action Methods
	public void clickOnActivityButton()
	{
		activityButton.click();
	}
	
	public void EnterText_EditActivity()
	{
		  
		EditTextBox.clear();
		
		EditTextBox.sendKeys(SmokeTestString);
		try 
		{
			Thread.sleep(1000);
		} catch (InterruptedException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		saveButtonEdit.click();
		
	}
	
	
	public void EnableArrhytmia()
	{
		if(CheckIfArrhytmiaIsEnabled() == false)
		{
			ArrhythmiaDisabled.click();
			System.out.print("Enabled Arrhythmia");
		}
		
	}
	
	public void DisableArrhytmia()
	{
		if(CheckIfArrhytmiaIsEnabled() == true)
		{
			ArrhythmiaEnabled.click();
			System.out.print("Disabled Arrhythmia");
		}
		
	}
	
	public boolean CheckIfArrhytmiaIsEnabled()
	{
		
		if(Arrhythmia.getAttribute("style").contains("green"))
		{
		
			return true ;
			
		}
		else
		{
			return false ;
		}
	}
	
	/*
	 * Method To click on OK button on ECG PDF pop up
	 */
	
	public void ClickOnOkButton_ECGPopUp()
	{
		ECGPDFPopUp_OKBtn.click();
	}
	
	/*
	 * Method To Get text from Notification toaster
	 */
	public String GetNotificationText()
	{
		return NotificationInfoPopUp.getText();
	}
	
	/*
	 * Method To click on Health trend button on Home page
	 */
	public void ClickHealthTrendBtn()
	{
		HelthTreandBtn.click();
	}
	
	/*
	 * Method To Verify User Info Pop
	 */
	public void VerifyUserInfoPopUp(String expectedInfoTxt)
	{
		Assert.assertEquals(NotificationInfoPopUp.getText(), expectedInfoTxt,"Found Expected text is "+expectedInfoTxt);
	}
	
	/*
	 * Method To verify edited text is displayed for activity
	 */
	public void VerifyEditedTextDisplayed()
	{
		
	   Assert.assertTrue(GetActivityInfo().contains(SmokeTestString),"Edited Text is saved");
		
	}
	
	
	/*
	 * Method To return training load as Integer
	 */
	
	public int GetTrainingLoad_ActivityLevel()
	{
		return Integer.parseInt(trainingLoad_ActivitySection.getText());
	}
	
	/*
	 * Method To return training load from Runner Page as Integer
	 */
	
	public int GetTrainingLoad_RunPage()
	{
		return Integer.parseInt(trainingLoad_RunPage.getText());
		
	}
	
	/*
	 * Method To Click on Activity
	 */
	
	
	public void ClickOnActivity(int activityCount)
	{
		ActivityRows.get(activityCount).click();
	}
	
	
	/*
	 * Method To Print number of activity 
	 */
	
	public void PrintActivityRows()
	{
		System.out.println(" Fishy "+ActivityRows.size());
	}
	
	/*
	 * Method To return ECG Tick mark color
	 * Green if synced 
	 * Red if not synced
	 */
	public String GetECGMarker()
	{
		
		return ECGSyncMarker.getAttribute("style");
	}
	
	/*
	 * Method To return Map Tick mark color
	 * Green if synced 
	 * Red if not synced
	 */
	
	public String GetMapMarker()
	{
		return MapMarker.getAttribute("style");
	}
	
	/*
	 * Method To return ECG Tick mark color
	 * Green if synced 
	 * Red if not synced
	 */
	public String GetActivityInfo()
	{
		return FirstRecord.getText();
	}
	
	/*
	 * Method to search for workout
	 */
	public void enterWorkout(String workout)
	{
		try
		{
			searchTextField.clear();
			searchTextField.sendKeys(workout);
			clickOnSearchWorkout();
			Thread.sleep(7000);
		}
		catch (Exception e)
		{
			System.out.print(e.getMessage());
		}
	}
		
		
	
	/*
	 * 
	 * Wait till till element is displayed
	 */
	
	public void WaitTillElementIsDisplayed(WebElement ele)
	{	
		
		try
		{
			@SuppressWarnings("deprecation")
			WebDriverWait wait = new WebDriverWait(driver,20);
			wait.until(ExpectedConditions.visibilityOf(ele)); 
		} catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		
	}
	
	/*
	 * 
	 * Clicks on Search workout button
	 */
	
	public void clickOnSearchWorkout() 
	{
		searchButton.click();
	}
	
	/*
	 * 
	 * Returns Training load value
	 */
	
	public String trainingLoad()
	{
		return trainingLoad.getText();
	}
	/*
	 * Return Training load %
	 */
	
	public String trainingLoadPercent()
	{
		return trainingLoadPercent.getText();
	}
	
	/*
	 * Click on down arrow button in Training load area
	 */
	public void clickOnTrainingLoadDownArrow() 
	{
		trainingLoadDownArrow.click();
	}
	
	/*
	 * Click on Admin Menu
	 */
	public void clickOnAdminMenu()
	{
		AdminMenu.click();
	}
	/*
	 * Click on Admin panel
	 */
	public void clickOnAdminPanel()
	{
		AdminPanel.click();
	}
	/*
	 * Verify FCP name in Admin Panel
	 */
	public void VerifyFCPName()
	{
		Assert.assertEquals(FCP.getText(), "Frontier Coach Platform");
	}
	
	/*
	 * Method to click on Add Coach button
	 */
	public void ClickOnAddCoachButton()
	{
		//AddCoachBtn.click();
	}
	
	/*
	 * Method to click on Add Coach button
	 */
	public void VerifyAddCoachPopUp()
	{
		//Assert.assertTrue(Coach_FirstName.isDisplayed());
		//Assert.assertTrue(Coach_LastName.isDisplayed());
		//Assert.assertTrue(Coach_email.isDisplayed());
		//Assert.assertTrue(Coach_deviceLink.isDisplayed());
		
	}
	
	
	/*
	 * Method to search users in Admin panel
	 */
    
	public void SearchUsers(String username)
	{
		SearchUserTextBox.click();
		SearchUserTextBox.sendKeys(username);
		searchButton_Admin.click();
	}
	
	/*
	 * Method to click on green tick mark
	 */
	public void clickOnGreenTick()
	{
		ECGMarker.click();
	}
	
	
	public void clickOnGreenTickAdmin() throws InterruptedException
	{
		Thread.sleep(7000);
		//get window handlers as list
		List<String> browserTabs = new ArrayList<String> (driver.getWindowHandles());
		//switch to new tab
		driver.switchTo().window(browserTabs .get(1));
		ECGMarker.click();
	}
	
	/*
	 * Method to Verify if search user displayed
	 */
	public void VerifyIfSearchedUserAppeared(String email)
	{
		
		Assert.assertEquals(UserRecord_Email.getText(), email,"User Found");
		
	}
	
	
	/*
	 * Method to select searched user
	 */
	public void SelectDisplyedUser()
	{
		UserRecord_Email.click();
	}
	
	/*
	 * Method to verify if user name is displayed on dashboard if admin/doc/FCP is searchinh
	 */
	public void VerifyUserNameIsDisplayedForUser(String UserName)
	{
		
			List<String> browserTabs = new ArrayList<String> (driver.getWindowHandles());
//switch to new tab
			driver.switchTo().window(browserTabs .get(1));
			System.out.println("<----"+CurrentUserName.getText()+"---->");
			Assert.assertTrue(CurrentUserName.getText().contains(UserName));
			driver.close();
			driver.switchTo().window(browserTabs.get(0));
	}
	
	
	/*
	 * Method to Verify ECG PDF POP up
	 */
	 public void VerifyECGPDFPopUp()
	 {
		 Assert.assertEquals(ECGPDFPopUpTitle.getText(), "Generate & Email ECG PDF ");
		 Assert.assertTrue(TimeIntervelInstrunction.getText().contains("SELECT TIME INTERVAL FOR ECG PDF (max 3 hours)"));
		// Assert.assertTrue(GenerateEmailBtn.isDisplayed());
	 }
	
	 /*
	  * Method to select any user level
	  */	
	public void SelectUserLevel(int userlevel)
	{
		Select UserLevelDropDown = new Select(driver.findElement(By.id("userLevel")));
		UserLevelDropDown.selectByIndex(userlevel);
	}
	
	/*
	 * Method to Verify User Level which is selected on the drop down
	 */
	public void VerifyUserLevel(String ExpectedUserLvl)
	{
		Select UserLevelDropDown = new Select(driver.findElement(By.className("user-role-select")));
		
		Assert.assertEquals(UserLevelDropDown.getFirstSelectedOption().getText(),ExpectedUserLvl,"Expected Result is matched");
	}
	
	/*
	 * Method to Verify User Level drop down list
	 */
	
	public void VerifyUserLevelOptions() throws InterruptedException
	{
		Select UserLevelDropDown = new Select(driver.findElement(By.className("user-role-select")));
		
		
		List<String> ConvertedList = new ArrayList<String>();
		
		
		List<WebElement> ActualLevelsList=UserLevelDropDown.getOptions();
		Thread.sleep(2000);
			
		for(int i = 0 ;i<ActualLevelsList.size();i++)
		{
			// Just print this for Debug purpose
			System.out.println("Debug : -> Item "+i+" : "+ActualLevelsList.get(i).getText());
		//	System.out.println("Debug : -> Expected List Item "+i+" : "+ExpectedUserList.get(i));
			ConvertedList.add(ActualLevelsList.get(i).getText());
			
		//Assert.assertTrue(ConvertedList.get(i).equals(ExpectedUserList.get(i)),"Expected is "+ExpectedUserList.get(i)+" Actual is "+ConvertedList.get(i));

		}
		
		//Assert.assertTrue(ConvertedList.equals(ExpectedUserList),"Not Equal");
	
		for(int j = 0 ;j<ActualLevelsList.size();j++)
		{
			Assert.assertTrue(ConvertedList.get(j).equals(ExpectedUserList.get(j)),"Expected is "+ExpectedUserList.get(j)+" Actual is "+ConvertedList.get(j));
		}	
	}
	
	
	/*
	 * Method to Click on Add Report Button
	 */
	public void ClickAddReportBtn()
	{
		AddReportBtn.click();
	}
	
	/*
	 * Method to Verify elements on Add Report pop up
	 */
	
	public void VerifyAddReportScreen()
	{
		
		Assert.assertTrue(!UploadBtn.isEnabled()); // Upload Button is disabled
		
		Assert.assertTrue(CancelBtn_AR.isEnabled());
		
		Assert.assertTrue(FileChooseArea.isDisplayed());
	}
	
	/*
	 * Method to select Vitals Tags
	 */
	
	public void SelectVitals() throws InterruptedException
	{
		HealthTags.get(0).click();
		Thread.sleep(3);
	}
	
	
	public void VerifyHealthTags(List<String> HTags)
	{
		int i = 0;
		for(String tag : HTags)
		{
			
			Assert.assertEquals(HealthTags.get(i).getText(), tag);
			i++;
		}
		
		
	}
	
	
	
	public void EnterHealthTagDetails(String val,String Notes) throws InterruptedException
	{
		sPO2Value.sendKeys(val);
		Thread.sleep(5);
		HealthEntrySaveBtn.click();
		Thread.sleep(2000);	
		Assert.assertEquals(GetNotificationText(), HealthEntryInfoMsg);
	
	}
	
	public void VerifyHealthTagIsDisplayed(String TagVal)
	{
		
		Assert.assertTrue(FirstHealthTag.getText().contains(TagVal), "Health Tag is Added ");
		
	}
	
	
	public void ClickOnAddHealtEntry()
	{
		AddHealthEntryBtn.click();
	}
	
	public void ClickHealthEntryInfoBtn()
	{
		HealthEntryInfoBtn.click();
	}
	
	
	
	public void ClickOnsPO2Tag()
	{
		sPOxygen.click();
	}
	
	public void clickOnTrainingLoadUpArrow() 
	{
		trainingLoadUpArrow.click();
	}
	
	public void clickOnDownloadCSV() 
	{
		downloadCSVFile.click();
	}
	
	public void clickOnDownloadZIP()
	{
		downloadZIPFile.click();
	}
	
	public void shareActivityLink()
	{
		shareActivityLink.click();
	}
	
	public void cancelShareActivityLink() {
		cancelShareActivity.click();
	}
	
	public void ClickgenerateECGPDF()
	{
		ecgPDF.click();
	}
	
	public void clickOnDownloadFIT()
	{
		downloadFITFile.click();
	}
	public String GetECGPDFTitle()
	{
		return ECGPDF_Title.getText();
	}
	
	public void VerifyECGPDFPop()
	{
		Assert.assertTrue(slider.isDisplayed());
		Assert.assertEquals(ECGPDF_Title.getText(), "Generate & Email ECG PDF");
		Assert.assertTrue(ECGPDFTextSection.getText().contains("SELECT TIME INTERVAL FOR ECG PDF (max 3 hours)"));
	}
	
	public void VerifyHomePageElements()
	{
		//Verifies the Title of the Page
		Assert.assertEquals(ActivityHistoryHeader.getText(), "Activity History");
		Assert.assertTrue(searchTextField.isDisplayed());
		Assert.assertTrue(searchTextField.isEnabled());
	// Verifies Search button 
		Assert.assertTrue(searchButton.isDisplayed());
		Assert.assertTrue(searchButton.isEnabled());
		
	// Verifies calander Icon 
		Assert.assertTrue(CalanderIcon.isDisplayed());
		Assert.assertTrue(CalanderIcon.isEnabled());
		
		// Verifies Add Health Event Tag button 
		Assert.assertTrue(AddHealthEntryBtn.isDisplayed());
		Assert.assertTrue(AddHealthEntryBtn.isEnabled());
		
		// Verifies Recomendation section 
		Assert.assertTrue(RecoSection.isDisplayed());
		
		
	}
	
	public void VerifyLoggedInUserName(String UserLvl)
	{
		Assert.assertEquals(UserNameSection.getText(),UserLvl);
	}
	
	
	public void ClickOnDeleteTag()
	{
		DeletTag.click();
	}
	
	public void clickOnLiveECG() 
	{
		liveECG.click();
	}
	
	/*
	 * 
	 * This method will click on Searched user to open his/her dashboard
	 */
	public void clickOnUser()
	{
		
	}
	
	
	
	public void VerifyDeletePopUpText()
	{
		System.out.println("Text = "+DeletePopUpText.getText());
		Assert.assertTrue(DeletePopUpText.getText().contains(DeleteTagText),"Text Matches" );
	}
	
	
	public void VerifyLiveECGBtn_Displayed()
	{	
			Assert.assertTrue(liveECG.isDisplayed());
			Assert.assertTrue(liveECG.isEnabled());
	}
	
	public void clickOnLiveUserDashboard()
	{
		liveUserDashboard.click();
	}
	
	public void editActivity() 
	{
		editActivity.click();
	}
	
	public void deleteActivity() 
	{
		deleteActivity.click();
	}
	
	public void ClickkeepButton()
	{
		keepButton.click();
	}
	
	public void ClickOnDeleteBtn_Tag()
	{
	//	DeleteTagBtn.click();
	}
	
	public void cancelButtonEdit() 
	{
		cancelButtonEdit.click();
	}
	
	public void saveButtonEdit() 
	{
		saveButtonEdit.click();
	}
	
	public void logout() 
	{
		logoutButton.click();
	}
	
	public void refresh() 
	{
		refreshButton.click();
	}
	
	public void VerifyECGPDFGeneratedPopUpDisplayed()
	{
			FxSettings.justSleepFor(10);
			Assert.assertTrue(ECGPDFPopUp.isDisplayed(),"ECG Generated Pop Up should display");
		
	}
	
	public void VerifyTodaysActivityIsDisplayed()
	{
		Calendar cal = Calendar.getInstance();
		System.out.println("Text in 1st record :"+FirstRecord.getText()+"\n");
		System.out.println("Current date in specfic formate"+FxUtilities.getCurrentDateInSpecificFormat(cal)+"\n");
		Assert.assertTrue(FirstRecord.getText().contains(FxUtilities.getCurrentDateInSpecificFormat(cal)),"Today's Activity is Synced");
	}
	
	public void VerifyTodaysECGIsSynced()
	{
		VerifyTodaysActivityIsDisplayed();
		Assert.assertTrue(GetECGMarker().contains("green"),"ECG is Synced with Green Tick Mark");
	}
	
	
	public void VerifyReportDropDownOptions() throws InterruptedException
	{
		Select ReportUploadDropDown = new Select(driver.findElement(By.className("user-role-select")));
		
		List<String> ConvertedList = new ArrayList<String>();
		
		
		List<WebElement> ActualReportsList=ReportUploadDropDown.getOptions();
		Thread.sleep(2000);
			
		for(int i = 1 ;i<=ActualReportsList.size()-1;i++)
		{
			// Just print this for Debug purpose
			System.out.println("Debug : -> Item "+i+" : "+ActualReportsList.get(i).getText());
		//	System.out.println("Debug : -> Expected List Item "+i+" : "+ExpectedUserList.get(i));
			ConvertedList.add(ActualReportsList.get(i).getText());
			
		//Assert.assertTrue(ConvertedList.get(i).equals(ExpectedUserList.get(i)),"Expected is "+ExpectedUserList.get(i)+" Actual is "+ConvertedList.get(i));

		}
		
		//Assert.assertTrue(ConvertedList.equals(ExpectedUserList),"Not Equal");
	
		for(int j = 1 ;j<=ActualReportsList.size()-1;j++)
		{
			Assert.assertTrue(ConvertedList.get(j).equals(ReportsOptions.get(j)),"Expected is "+ReportsOptions.get(j)+" Actual is "+ConvertedList.get(j));
		}
		
		
	}

	
}
