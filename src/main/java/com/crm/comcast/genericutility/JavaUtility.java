package com.crm.comcast.genericutility;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.Random;
/**
 *this class contains java specific generic libraries   
 * @author Ravi
 *
 */

public class JavaUtility
{
	/**
	 * This method will generate a random number and return it to the caller
	 * @return
	 */
	public  int getRanDomNumber()
	{
		Random ran = new Random();
		int ranDomNum = ran.nextInt(1000);
		return ranDomNum;
		
	}
	/**
	 * This method will return the current date
	 * @return
	 */
	public String getSystmeDate_YYYY_MM__DD() {
		Date date = new Date();
		String systemDateAndTime = date.toString();
		System.out.println(systemDateAndTime);
		String[] arr = systemDateAndTime.split(" ");
        String DD = arr[2];
        String YYYY = arr[5];
        
        int MM = date.getMonth()+1;
        
        String finalFromat = YYYY+"-"+MM+"-"+DD;
		return finalFromat;	  
	}

	/**
	 * This method will return date in specified format
	 * @return
	 */
	public  String getFinalDateFormat()
	{
		Date date = new Date();
		String d = date.toString();
		String[] dte = d.split(" ");
		String YYYY = dte[5];
		String DD = dte[2];
		String MM = dte[1];
		 String today = YYYY+"-"+MM+"-"+DD;
		return today;
	}
	/**
	 * This method is used to pass Virtual Key to OS
	 * @throws AWTException
	 */
	public void pressVritualEnterKey() throws AWTException
	{
		Robot rc = new Robot();
		rc.keyPress(KeyEvent.VK_ENTER);
		rc.keyRelease(KeyEvent.VK_ENTER);
	}

}
