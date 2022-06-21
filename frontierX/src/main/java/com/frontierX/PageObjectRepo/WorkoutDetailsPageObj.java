package com.frontierX.PageObjectRepo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import com.frontierX.BaseSettings.FxBasePage;

public class WorkoutDetailsPageObj extends FxBasePage
{
	public WorkoutDetailsPageObj(WebDriver driver)
	{
		super(driver);
		// TODO Auto-generated constructor stub
	}

	//	Identifying WebElements
	@FindBy(id = "e1")
	protected WebElement ECGBlock1 ;
	
	@FindBy(id = "e2")
	protected WebElement ECGBlock2 ;
	
	@FindBy (id ="charthr")
	protected WebElement HeartRateBlock;
	
	@FindBy(className = "dygraph-legend")
	protected WebElement HeartRateGraph;
	
	@FindBy(className = "vs-popup")
	protected WebElement AnnotationWindow;
	
	@FindBy(xpath = "//body/div[@id='app']/div/div[@class='wrapper row-offcanvas']/aside[@class='right-aside']/section[@class='content']/div/div[@class='header-information']/div[@class='training-statistics']/div[@class='my-col-1 my-md-col-2 my-sm-col-3']/div[1]")
	protected WebElement TrainingLoadCard;
	
	
	@FindBy (id ="chartst")
	protected WebElement CardiacStrain;
	
	@FindBy (id ="charthrv")
	protected WebElement HRVBlock;
	
	@FindBy (id ="chartbr")
	protected WebElement BreathingRate;
	//
	@FindBy (id ="mapid")
	protected WebElement MapArea;
	
	@FindBy (id ="speed")
	protected WebElement SeepChart;
	
	@FindBy (id ="altitude")
	protected WebElement Alltitude;
	
	@FindBy (id ="chartcadence")
	protected WebElement StepCadence;
	
	@FindBy (id ="chartshock")
	protected WebElement BodyShock;
	
	@FindBy(xpath = "//button[@class='add-notes']")//button[@class='add-notes'])
	protected WebElement AddNotes ;
	
	@FindBy(id = "note-title")
	protected WebElement NoteTextArea ;
	
	//@FindBy (className = "btn save-button")
	protected WebElement SaveButton;
	
	@FindBy(className = "vs-popup")
	protected WebElement AddNotePopUp;
	
	@FindBy(xpath = "(//div[@class='training-info'])[2]")
	protected  WebElement TrainigLoadCard  ;//= driver.findElement(By.xpath("//div[contains(@class, ‘alert_new_dl’)]"));//input[contains(@id, ‘subscribe’)]));
	
	@FindBy(className = "insights-notes")
	protected WebElement InsightNotes;
	
	@FindBy(className = "training-info")
	protected WebElement duriation;// = driver.findElement(By.className("training-info"));//.findElement(By.className("data"));
	
	@FindAll(@FindBy(className = "training-info"))
	protected List<WebElement> TrainingInofs;
								
	//@FindBy(xpath ="//div[@class='graph ecg-graph']//button[@name='button']")
	protected List<WebElement> ECGInfoButtons = driver.findElements(By.name("button")) ;
	
	//@FindBy(className = "my-col-2 my-md-col-4 my-sm-col-5")
	protected WebElement DerivedParameters;
	
}
