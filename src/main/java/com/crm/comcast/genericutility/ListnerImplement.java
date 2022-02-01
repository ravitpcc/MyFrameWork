package com.crm.comcast.genericutility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListnerImplement implements ITestListener
{
	ExtentReports report;
	ExtentTest test;
	public void onTestStart(ITestResult result)
	{
		//@Test
		test=report.createTest(result.getMethod().getMethodName());
		
		
		
	}

	public void onTestSuccess(ITestResult result) {
		
	}

	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, result.getMethod().getMethodName()+" is skipped");				
	       test.log(Status.SKIP, result.getThrowable());		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context)
	{
		ExtentSparkReporter spark = new ExtentSparkReporter("./extentreport.html");
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("vtiger Automation");
		spark.config().setReportName("Execution Report");
		
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS","Window");
		report.setSystemInfo("Platform","Window 10");
		report.setSystemInfo("Reporter","Ravi");
		
	}

	public void onFinish(ITestContext context)
	{
		//@Aftersuite
		report.flush();
		
	}

	public void onTestFailure(ITestResult result) {
		 String failTestName=result.getMethod().getMethodName();
		 EventFiringWebDriver eDriver = new EventFiringWebDriver(BaseAnnoationClass.sDriver);
		  File scrFile = eDriver.getScreenshotAs(OutputType.FILE);
		//String Browser = result.getParameters(BROSWER);
		String sdate =new Date().toString().replace(":", "-").replace(" ", "-");
		
		try
		{  
			File  desc=new File("./ScreenShort/"+failTestName+"-"+sdate+".png");
			FileUtils.copyFile(scrFile,desc);
		}
		catch(IOException e)
		{
			e.printStackTrace();	
		}
		
		
		  
	}

}