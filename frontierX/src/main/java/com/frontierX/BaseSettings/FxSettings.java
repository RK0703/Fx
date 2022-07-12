package com.frontierX.BaseSettings;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITest;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.frontierX.Utilities.FxUtilities;

public abstract class FxSettings //extends TestListenerAdapter 
{
	protected  WebDriver driver ;
	
	static 
	{
		if (FxUtilities.getOperatingSystemSystemUtils().contains("Win"))
		{
			String chromeKey = "webdriver.chrome.driver";
			String chromeDriverPath = "./drivers/chromedriver.exe";
			System.setProperty(chromeKey, chromeDriverPath);
			System.out.println("Launching Chrome in Environment : " +FxUtilities.getOperatingSystemSystemUtils());
		}
		else
		{
			String chromeKey = "webdriver.chrome.driver";
			String chromeDriverPath = "./drivers/chromedriverUbuntu";
			
			System.setProperty(chromeKey, chromeDriverPath);
			System.out.println("Launching Chrome in Environment : " +FxUtilities.getOperatingSystemSystemUtils());
		}
		
	}
	
	
	
	
	
	
	public static long justSleepFor(long seconds)
	{
		
		long millisecond = seconds * 1000 ;
		try {
			Thread.sleep(millisecond);
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return seconds;	
	}
	
	
	//@SuppressWarnings("deprecation")
	public static WebDriver DecideEnvironment(String env)
	{
		
		WebDriver driver = null;
	    
	    if (env.equalsIgnoreCase("staging") || env.equalsIgnoreCase("stage")) 
	    {				
			driver = setUp();
		}
		
		else if (env.equalsIgnoreCase("production") || env.equalsIgnoreCase("prod")) 
		{
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://app.fourthfrontier.com/#/login");
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}
		
		else 
		{
			Assert.fail("Environment not executable");
		}
		
		return driver;
	}
	
	
	@SuppressWarnings("deprecation")
	public static WebDriver setUp(String...config)
	{
		
		String browserName = null ;
		String url = null ;
		long ITO = 0 ;
		
		
		try {
			url = config[0] ;
		} catch (Exception e) {
			// TODO: handle exception
			url = "https://app.staging.heartos.org/#/login" ;
		}
		
		
		
		try 
		{
			browserName = config[1] ;
		} catch (Exception e)
		{
			// TODO: handle exception
			browserName = "chrome" ;
		}
		
		
		
		try {
			ITO = Long.parseLong(config[2]) ;
		} catch (Exception e) {
			// TODO: handle exception
			ITO = 20 ;
		}
		
		
		WebDriver driver = null ;
		
		if (browserName.equalsIgnoreCase("chrome")) 
		{
			driver = new ChromeDriver() ;
		}
		else if (browserName.equalsIgnoreCase("firefox")) 
		{
			driver = new FirefoxDriver() ;
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(ITO, TimeUnit.SECONDS) ;
		driver.get(url);
		
		return driver ;
		
		
	}
	
	public static void closeChildBrowsers(WebDriver driver, long delayInSeconds)
	{
		
		justSleepFor(delayInSeconds);
		String parentWid = driver.getWindowHandle();
		Set<String> windowIds = driver.getWindowHandles();
		windowIds.remove(parentWid);
		for (String wid : windowIds) {
			driver.switchTo().window(wid).close();
		}
		
		driver.switchTo().window(parentWid);
	}
	
	
	public enum UserLevel
	{
		  Admin
		  {
		      public String toString()
		      {
		          return "ADMIN";
		      }
		  },

		  Premium
		  {
		      public String toString()
		      {
		          return "PREMIUM";
		      }
		  },
		  
		  Doctor
		  {
		      public String toString()
		      {
		          return "DOCTOR";
		      }
		  },
		  
		  RegularUser
		  {
		      public String toString()
		      {
		          return "RAVIKIRAN";
		      }
		  },
		  Trainer
		  {
		      public String toString()
		      {
		          return "TRAINER";
		      }
		  },
		}
	
	
	
}
