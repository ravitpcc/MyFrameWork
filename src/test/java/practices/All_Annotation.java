package practices;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class All_Annotation
{
	@BeforeSuite
	public void connectDB()
	{
		System.out.println("====conncet TO DataBase=====");
	}
	
	@BeforeClass
	public void openBrowser()
	{
		System.out.println("====openBrowser=====");
	}
	
	@BeforeMethod
	public void loginApp()
	{
		System.out.println("====Login application=====");
	}
	
	@Test(priority = 1)
	public void createCustomerTest()
	{
		System.out.println("Execute HDFC create Customer Test ");
		//System.out.println(10/0);
	}
	
	@Test(priority = 2)
	public void modifyCustomerTest()
	{
		System.out.println("Execute modify HDFC to AIRTEL Customer Test ");
		//System.out.println(10/0);
	}
	
	@Test(priority = 3)
	public void deleteCustomerTest()
	{
		System.out.println("Execute delete AIRTEL Customer Test");
		
	}
	
	@AfterMethod
	public void logoutApp()
	{
		System.out.println("====Logout application=====");
	}
	
	@AfterClass
	public void closeBrowser()
	{
		System.out.println("====closeBrowser=====");
	}
	
	@AfterSuite
	public void disconnectDB()
	{
		System.out.println("====disconncet TO DataBase=====");
	}

}
