package com.frontierX.BaseSettings;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import com.frontierX.Utilities.FxUtilities;

public abstract class FxSettings //extends TestListenerAdapter 
{
	protected  WebDriver driver ;
	
	
	/*
	 * This Logic will reads the OS , 
	 * if Windows specific to win chrome driver will launch 
	 * else Chrome driver comptible to Ubuntu will launch
	 */
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
			String chromeDriverPath = "/var/lib/jenkins/workspace/Demo/frontierX/drivers/Ubuntu/chromedriver";
			
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
			
			if (FxUtilities.getOperatingSystemSystemUtils().contains("Win"))
			{
				System.out.println("Chrome options are being set for "+FxUtilities.getOperatingSystemSystemUtils()+" Environment");
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.get("https://app.fourthfrontier.com/#/login");
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			}
			else
			{
				System.out.println("Chrome options are being set for "+FxUtilities.getOperatingSystemSystemUtils()+" Environment");
				ChromeOptions options = new ChromeOptions();
				options.addArguments("start-maximized"); // open Browser in maximized mode
				options.addArguments("disable-infobars"); // disabling infobars
				options.addArguments("--disable-extensions"); // disabling extensions
				options.addArguments("--disable-gpu"); // applicable to windows os only
				options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
				options.addArguments("--no-sandbox"); // Bypass OS security model
				driver = new ChromeDriver(options);
				driver.get("https://app.fourthfrontier.com/#/login");
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			}
			
			/*
			 * 
			 *  driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.get("https://app.fourthfrontier.com/#/login");
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			 * 
			 * 
			 */
			
			
			
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
