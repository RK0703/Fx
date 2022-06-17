package com.frontierX.Utilities;

 
public class FXParameters 
{
	
	
    String HRValue;
    String HRUnit;
    String duriation;
    //getter and setter methods
 
    
    
    /*
     * Sets Value to all the parameters
     */
    public FXParameters(String HRValue,String HRUnit , String dur )
    {
    	this.duriation = dur;
    	this.HRValue = HRValue;
    	this.HRUnit = HRUnit;
    }
    
    
    /*
     * 
     * Getters 
     */
  
    public String getHRValue() 
    {
        return HRValue;
    }
    
    public String getHRUnit()
    {
    	return HRUnit;
    }
 
    public String getDuriation() 
    {
        return duriation;
    }
 
 
 
}
 