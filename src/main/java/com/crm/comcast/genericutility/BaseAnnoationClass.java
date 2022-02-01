package com.crm.comcast.genericutility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;
import com.crm.comcast.objectrepositorylib.HomePage;
import com.crm.comcast.objectrepositorylib.LoginPage;

public class BaseAnnoationClass 
{
	/* Object Creation for Lib*/
	public JavaUtility jLib=new JavaUtility();
	public FileUtility fLib=new FileUtility();
	public ExcelUtility eLib= new ExcelUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	public WebDriver driver= null;
	public static WebDriver sDriver=null;

	@BeforeSuite(groups = {"smokeTest","regressionTest"})
	public void configBS()
	{
		System.out.println("=======connect to Database=======");

	}
  // @Parameters("browser")
	@BeforeClass(groups = {"smokeTest","regressionTest"})
	public void configBC(/*String BROWSER*/) throws Throwable
	{
		/*Open Browser*/
		String BROWSER = fLib.getPropertyKeyValue("browser");
		System.out.println("========Launch the Browser=======");
		if(BROWSER .equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(BROWSER .equals("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else
		{
			driver=new InternetExplorerDriver();
		}
		wLib.waitUntilPageLoad(driver);
		driver.manage().window().maximize();
		String URL = fLib.getPropertyKeyValue("url");
		driver.get(URL);
		sDriver = driver;
		
	}

	@BeforeMethod(groups = {"smokeTest","regressionTest"})
	public void configBM() throws Throwable 
	{
		/*common Data*/
		String USERNAME = fLib.getPropertyKeyValue("username");
		String PASSWORD = fLib.getPropertyKeyValue("password");
	
		/*  login Application*/
		System.out.println("==========Login Appliction=======");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginToApp(USERNAME, PASSWORD);
	}


	@AfterMethod(groups = {"smokeTest","regressionTest"})
	public void configAM()
	{
		/* logout Application*/
		System.out.println("=========Logout Appliction=======");
		HomePage homePage = new HomePage(driver);
		homePage.logout();
	}

	@AfterClass(groups = {"smokeTest","regressionTest"})
	public void configAC()
	{
		/*close Browser*/
		System.out.println("=============Close the Browser=======");
		driver.quit();
	}

	@AfterSuite(groups = {"smokeTest","regressionTest"})
	public void configAS()
	{
		System.out.println("=======close Database Connection=====");
	}
}


