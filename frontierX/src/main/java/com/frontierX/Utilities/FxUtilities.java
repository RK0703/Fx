package com.frontierX.Utilities;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.xml.bind.DatatypeConverter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;

public class FxUtilities
{
	private static String downloadPath = "C:\\Users\\user\\Downloads";
	private static String localGoogleDriverMapper = "G:\\.shortcut-targets-by-id\\1_FpxrsdPY5eOoYYZ1SdoHTwUAL_8rx1b\\Prod Automation Report";
	
	private static String  Evidences = "./FailedTCs/";
	
	static String format = "dd-MMMM-yyyy";
    static DateFormat dateFormatter = new SimpleDateFormat(format);
    static Date FolderNamedate = new Date(); 
    
    static String date = dateFormatter.format(FolderNamedate);
	/*
	 * This method captures the screenshot and saves it in a location 
	 * 
	 */
	 public static void CaptureEvidance(WebDriver webdriver,String TCName,ITestResult result,String workFlow) throws Exception
	 {
		  
		 String EviName = TCName;
	        //Convert web driver object to TakeScreenshot

	        TakesScreenshot scrShot =((TakesScreenshot)webdriver);

	        //Call getScreenshotAs method to create image file

	                File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

	            //Move image file to new destination

	               // File DestFile=new File("D:\\AutomationEvidence\\Failed TCs\\"+EviName+".jpg");
	                File DestFile=new File(Evidences+"\\"+date+"\\"+workFlow+"\\"+EviName+".jpg");
	                //createDateBasedDirectory
	                	
	                //Copy file at destination

	                FileUtils.copyFile(SrcFile, DestFile);
	                
	                //File attachments[] = new File[] { new File(DestFile.toString())};
	               // result.setAttribute("attachments", attachments);
	    }
	 
		/*
		 * This Method Verifies if FIT/CSV file is downloaded or not
		 */
		public static boolean isFxFileDownloaded(String fileName) 
		{
			  File dir = new File(downloadPath);
			  File[] dirContents = dir.listFiles();

			  for (int i = 0; i < dirContents.length; i++) 
			  {
			      if (dirContents[i].getName().equals(fileName)) 
			      {
			    	  System.out.println(fileName+" Found in "+downloadPath+" Validating the file..");
			          // File has been found, it can now be deleted:
			    	  long fileSize =dirContents[i].length();
			    	  if((fileSize/1024) < 1)
			    	  {
			    		  System.out.println("Length of file is" + dirContents[i].length()/1024 +" KB");
			    		  Assert.fail(dirContents[i].getAbsolutePath().toString()+" is lesser than 1KB so its invalid file");
			    		  dirContents[i].delete(); 
			    	  }
			          System.out.println("File "+fileName+" has been validated , file size is "+fileSize+" and has been deleted as clean up for next test run");
			          dirContents[i].delete();
			          return true;
			      }
			  }
			      return false;
		}
	 
		/*
		 * This method will upload the final testng html file to google drive
		 * 
		 */
	 
		 public static void CopyReportToQAFolderInGoogleDrive(String SourcLocation)
		    {
		    	File source = new File(SourcLocation);
		    	File dest = new File(localGoogleDriverMapper);
		    	try 
		    	{
		    	    FileUtils.copyFileToDirectory(source, dest);
		    	    System.out.println("\n Parameter Information uploaded to Goolge Drive");
		    	} 
		    	catch (IOException e) 
		    	{
		    	    e.printStackTrace();
		    	}
		    }
		    
		 /*
		  * 
		  * This method detects if today's file with specific extension is downloaded
		  * 
		  */
	 
	  public static boolean isCurrentDaysFileDownloaded(String fileExtensions) throws IOException 
	  {
		  
		  File folder = new File(downloadPath);
          File fList[] = folder.listFiles();
          boolean fileFound = false;
          
          for (File f : fList)
          {
              if (f.getName().endsWith(fileExtensions))
              {
            		fileFound = true;
            		System.out.println("file Found in path : "+f.getAbsolutePath().toString());
            		if((f.length()/1024) < 1)
            		{
            			System.out.println("Length of file is" + f.length()/1024 +" KB");
            			Assert.fail(f.getAbsolutePath().toString()+" is lesser than 1KB so its invalid file");
            		}
            		break;
              }
           }
	        return fileFound;
	    }
	  
	  /*
	   * This method deletes the file with specific extension passed as parameter
	   * 
	   */
	 public static void deleteFiles(String extension)
	    {
	 
		// Lists all files in folder
		  File folder = new File(downloadPath);
		  File fList[] = folder.listFiles();
		  // Searchs .FIT
		  for (int i = 0; i < fList.length; i++)
		  {
		      File fileToBeDeleted = fList[i];
		      if (fileToBeDeleted.getName().endsWith(extension))
		      {
		    	  fList[i].delete();
		          // and deletes
		        //  boolean success = (new File(fList[i]).delete());
		      }
		  }
	    }
	 

	 public static String getCurrentDateInSpecificFormat(Calendar currentCalDate)
		{
		    String dayNumberSuffix = getDayNumberSuffix(currentCalDate.get(Calendar.DAY_OF_MONTH));
		    DateFormat dateFormatnew = new SimpleDateFormat(" MMMM d'" + dayNumberSuffix + ", 'yyyy");
		    return dateFormatnew.format(currentCalDate.getTime());
		}
	 
	 
		private static String getDayNumberSuffix(int day) 
		{
		    if (day >= 11 && day <= 13) {
		        return "th";
		    }
		    switch (day % 10) {
		    case 1:
		        return "st";
		    case 2:
		        return "nd";
		    case 3:
		        return "rd";
		    default:
		        return "th";
		    }
		}
	 
		public void ScrollTillElement(WebElement element,WebElement driver)
		{
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", element);
			
			
		}
		
		public static String DecryptPass(String pass)
		{
		    byte[] DecryptPass = DatatypeConverter.parseBase64Binary(pass);
		    String dPass = new String(DecryptPass, StandardCharsets.UTF_8);
		    return dPass;
		}
		
	 
		public static String createDateBasedDirectory()
		{
		    String newDir = null;
		   
		    if (Evidences != null) 
		    {
		        try 
		        {
		            
		            // check if the directory exists:
		            String todaysLogDir = Evidences + "\\" + date; // create the path as String
		            // then create a Path (java.nio, alternatives possible)
		            Path todaysDirectoryPath = Paths.get(todaysLogDir);
		            // and check if this Path exists
		            if (Files.exists(todaysDirectoryPath))
		           {
		                // if present, just return it in order to write (into) a log file there
		                return todaysDirectoryPath.toUri().toString();
		            } 
		            else 
		            {
		                // create it the way you want and return the path as String
		            	new File(todaysLogDir).mkdir(); 
		            	return todaysDirectoryPath.toUri().toString(); 
		            
		            }
		           
		        } catch (Exception e) 
		        {
		            e.printStackTrace();
		        }
		    }
		    System.out.println("New Directory name is "+newDir);
		    return newDir;
		   // System.out.println("New Directory name is "+newDir);
		}
		
		
		public static String createWorkFlowFolder(String WorkFlowName)
		{
		    String newDir = null;
		    if (Evidences != null) 
		    {
		        try 
		        {
		           
		            // check if the directory exists:
		            String WorkFlowDirectory = Evidences +"\\"+date+"\\"+WorkFlowName; // create the path as String
		            // then create a Path (java.nio, alternatives possible)
		            Path workFlowDirectoryPath = Paths.get(WorkFlowDirectory);
		            // and check if this Path exists
		            if (Files.exists(workFlowDirectoryPath))
		           {
		                // if present, just return it in order to write (into) a log file there
		            	return workFlowDirectoryPath.toUri().toString();
		            	
		              //  return todaysDirectoryPath.toUri().toString();
		            } 
		            else 
		            {
		                // create it the way you want and return the path as String
		            	new File(WorkFlowDirectory).mkdir(); 
		            	return workFlowDirectoryPath.toUri().toString(); 
		            
		            }
		           
		           
		        } catch (Exception e) 
		        {
		            e.printStackTrace();
		        }
		    }
		    System.out.println("New Directory name is "+newDir);
		    return newDir;
		   // System.out.println("New Directory name is "+newDir);
		}
		
		
}