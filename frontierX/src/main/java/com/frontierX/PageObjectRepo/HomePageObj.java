package com.frontierX.PageObjectRepo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import com.frontierX.BaseSettings.FxBasePage;




public class HomePageObj extends FxBasePage
{

	   private Date date = new Date();
	   private SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
	  
	   String strDate = formatter.format(date);
	   
	   String SmokeTestString = "Smoke Test on "+strDate;
	
   
	//	Creating WebElements
	@FindBy(xpath = "//input[@placeholder='Search by Title']")
	protected WebElement searchTextField ;
	
	@FindAll(@FindBy(className = "row w-list"))
	protected List<WebElement> ActivityRows;
	
	@FindBy(xpath = "//button[@class='search-button']")
	protected WebElement searchButton ;
	
	@FindBy(xpath = "//i[@class='fa fa-power-off']")
	protected WebElement logoutButton ;
	
	@FindBy(xpath = "//i[@class='fa fa-refresh']")
	protected WebElement refreshButton ;
	
	@FindBy(xpath = "//div[@class='donut-inner']") 
	protected WebElement trainingLoad ;
	
	@FindBy (className = "mini-toastr-notification__message")
	protected WebElement NotificationInfoPopUp;
	
	@FindBy(xpath = "//span[@class='alert_new_dl_1']")
	protected WebElement trainingLoad_ActivitySection ;
	
	@FindBy(xpath = "//div[@class='data alert_new_dl_1']")
	protected WebElement trainingLoad_RunPage ;
	
	@FindBy(xpath = "//div[@class='training-percentage']")
	protected WebElement trainingLoadPercent ; 
	
	@FindBy(xpath = "//i[@class='fa fa-chevron-down']")
	protected WebElement trainingLoadDownArrow ;
	
	@FindBy(xpath = "//i[@class='fa fa-bars']")
	protected WebElement AdminMenu ;
	
	@FindBy(xpath = "//i[@class='leftmenu_icon fa fa-address-card']")
	//@FindBy(className = "listbrdr")
	protected WebElement AdminPanel ;
	
	@FindBy(xpath = "//span[contains(text(),'Frontier Coach Platform')]")
	protected WebElement FCP;
	
	@FindBy(xpath = "//input[@placeholder='Search by Name']")
	protected WebElement SearchUserTextBox ;
	
	@FindBy(xpath = "//div[@class='col-12 col-md-4']") //longContentControl
	//@FindBy(className = "col-12 col-md-4")
	protected WebElement UserRecord_Email ;
	
	@FindBy(xpath = "//div[@class='col-md-2 col-10 w-name-info']")
	protected WebElement UserRecord_UserName ;
	
	@FindBy(xpath = "//i[@class='fa fa-chevron-up']")
	protected WebElement trainingLoadUpArrow ;
	
	@FindBy(xpath = "//img[@src='/images/Dropdown_change.png?1954b4fed9b0b4f0befe41fc6c9f36fb']")
	protected WebElement activityButton;
	
	@FindBy(xpath = "(//a[@class='dropdown-item w-time download-wtext'])[1]")
	protected WebElement shareActivityLink ;
	
	@FindBy(partialLinkText = "Download Summary Data (CSV)")
	protected WebElement downloadCSVFile ;
	
	@FindBy(partialLinkText = "Download ECG Data (ZIP)")
	protected WebElement downloadZIPFile ;
	
	@FindBy(partialLinkText = "Generate ECG PDF")
	protected WebElement ecgPDF ;
	
	@FindBy(partialLinkText = "Download Fit File")
	protected WebElement downloadFITFile ;
	
	@FindBy(className = "current-user-dashboard")
	protected WebElement CurrentUserName;
	
	@FindBy(className = "edit-name")
	protected WebElement ECGPDFPopUpTitle;
	
	@FindBy(className = "sectionGenerate")
	protected WebElement TimeIntervelInstrunction;
	
	@FindBy(partialLinkText = "Tag") 
	protected WebElement DeletTag ;
	
	@FindBy(xpath = "//span[@class='btn live-ecg-dashboard']")
	protected WebElement liveECG ;
	
	@FindBy(xpath = "//span[.='Live User Dashboard']")
	protected WebElement liveUserDashboard ;
	
	@FindBy(partialLinkText = "Edit Activity")
	protected WebElement editActivity ;
	
	@FindBy(xpath = "(//button[.='Cancel'])[1]")
	protected WebElement cancelButtonEdit ;
	
	@FindBy(xpath = "//button[@class='search-button']")
	protected WebElement searchButton_Admin ;
	
	@FindBy(xpath = "//button[.='Save']")
	protected WebElement saveButtonEdit ;
	
	@FindBy(partialLinkText = "Delete Activity")
	protected WebElement deleteActivity ;
	
	@FindBy(xpath = "(//button[@class='btn cancel-button") //btn cancel-button 
	protected WebElement keepButton;
	
	@FindBy(xpath = "(//button[@class='btn cancel-button'])[3]")
	protected WebElement cancelShareActivity;
	
	@FindBy(xpath = "//div[@class='col-lg-3 col-10 w-name-info']") //col-lg-3 col-10 w-name-info
	protected WebElement FirstRecord; //   col-lg-10 col-6 w-name-info
	
	protected WebElement DeleteTagBtn = driver.findElement(By.xpath("//body/div[5]/div[2]/div[1]/div[1]/div[1]/button[2]"));
	
	protected WebElement DeletePopUpText = driver.findElement(By.xpath("//body/div[5]/div[2]/div[1]/div[1]"));

	@FindBy(xpath = "//span[@class='col-lg-4 col-11 w-name-info']") 
	protected WebElement HealthEntryInfoBtn;
	

	@FindBy(xpath = "//div[@class='col-lg-10 col-6 w-name-info']") 
	protected WebElement FirstHealthTag;
	
	
	@FindBy(xpath = "//span[@class='mr-2']")
	protected WebElement ECGMarker;
	
	@FindBy(xpath ="//i[@class='fa fa-check']")
	protected WebElement ECGSyncMarker;
	
	@FindBy(xpath = "(//div[@class='col-md-6'])[4]")
	protected WebElement MapMarker;
	
	@FindBy(id = "workout-title-edit")
	protected WebElement EditTextBox;
	
	@FindBy(xpath = "//*[contains(text(), 'ECG PDF Generated')]")
	protected WebElement ECGPDFPopUp;
	
	@FindBy(xpath = "(//button[@class='btn cancel-button']")
	protected WebElement ECGPDFPopUp_OKBtn;
	
	@FindBy(xpath = "(//div[@class='v-switch-core'])")
	protected WebElement Arrhythmia ;
	
	@FindBy(xpath = "(//span[@class='v-switch-label v-left'])")
	protected WebElement ArrhythmiaEnabled ;
	
	@FindBy(xpath = "(//span[@class='v-switch-label v-right'])")
	protected WebElement  ArrhythmiaDisabled;
	
	@FindBy(className = "btn-health-entry")
	protected WebElement AddHealthEntryBtn;
	
	@FindAll(@FindBy(className = "lb_item"))
	protected List<WebElement> HealthTags;
	
	@FindBy(id = "wrap")
	protected WebElement sPOxygen;
	
	@FindBy(className = "search-tag")
	protected WebElement sPO2Value;
	
	@FindBy(id = "note-title")
	protected WebElement HealthTagNote;
	
	
	@FindBy(xpath = "//div[@class='vs-component con-vs-popup vs-popup-primary']//div[@class='form-modal']//div[2]//button[2]")
	protected WebElement HealthEntrySaveBtn;
	protected WebElement HelthTreandBtn = driver.findElement(By.className("user_forum_max"));
	
	protected WebElement ECGPDF_Title = driver.findElement(By.className("edit-name"));
	
	protected WebElement slider = driver.findElement(By.id("slider-range"));
	
	protected WebElement ECGPDFTextSection = driver.findElement(By.className("sectionGenerate"));
	
	protected WebElement ActivityHistoryHeader = driver.findElement(By.className("table-board-header"));
	
	protected WebElement CalanderIcon = driver.findElement(By.className("show-calendar"));
	
	protected WebElement RecoSection = driver.findElement(By.className("statistic-box-header"));
	
	protected WebElement UserNameSection = driver.findElement(By.className("user_name_max"));
	
	
	protected WebElement AddReportBtn = driver.findElement(By.xpath("//button[normalize-space()='Add Report']"));
	
	protected WebElement UploadBtn = driver.findElement(By.xpath("//button[normalize-space()='Upload']"));
	
	protected WebElement FileChooseArea = driver.findElement(By.xpath("//input[@id='file']"));

	protected WebElement CancelBtn_AR = driver.findElement(By.xpath("//body/div/div/div/div/div[2]/button[1]"));
	
	protected WebElement AddCoachBtn = driver.findElement(By.xpath("//button[@id='addNewTrainerBtn']"));
	protected WebElement Coach_FirstName = driver.findElement(By.id("first_name"));
	
	protected WebElement Coach_LastName = driver.findElement(By.id("last_name"));
	
	protected WebElement Coach_email = driver.findElement(By.id("trainer_email"));
	
	protected WebElement Coach_deviceLink = driver.findElement(By.id("device_purchase_link"));
	
	//	Constructor
	public HomePageObj(WebDriver driver) 
	{
		super(driver);
	}
	
	
	
}
