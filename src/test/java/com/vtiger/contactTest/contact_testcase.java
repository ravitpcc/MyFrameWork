package com.vtiger.contactTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.util.PropertiesUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.comcast.genericutility.BaseAnnoationClass;

public class contact_testcase 
{
	@Test
	public void testcase_1() throws IOException
	{
		FileInputStream fis=new FileInputStream("./data/commondata.properties");
		Properties p =new Properties();
		p.load(fis);
		String URL = p.getProperty("url");
		String USERNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("password");
		WebDriver driver=new ChromeDriver();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("ContactPage")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		WebDriverWait wait =new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.alertIsPresent());
		Alert a =driver.switchTo().alert();
		String text = a.getText();
		a.accept();
		Reporter.log(text);
		Actions a1 =new Actions(driver);
		WebElement desc = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		a1.moveToElement(desc).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.close();
	}

	@Test
	public  void testcase_3 ()throws IOException {
		FileInputStream fis= new FileInputStream("./data/commondata.properties");
		Properties p = new Properties();
		p.load(fis);
		String URL = p.getProperty("url");
		String USERNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("password");
		FileInputStream fis1=new FileInputStream("./data/ContactName.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet seat = wb.getSheet("name");
		Row Row = seat.getRow(2);
		String fName = Row.getCell(0).toString();
		String lName = Row.getCell(1).toString();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("ContactPage")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.name("firstname")).sendKeys(fName);
		driver.findElement(By.name("lastname")).sendKeys(lName);
		File  f = new File("./data/download.jpg");
		String abspath = f.getAbsolutePath();
		driver.findElement(By.xpath("//input[@name='imagename']")).sendKeys(abspath);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String orgMsg =driver.findElement(By.id("dtlview_First Name")).getText();
		String actMsg = driver.findElement(By.className("dvHeaderText")).getText();
		if(actMsg.contains(orgMsg))
		{
			Reporter.log("Contact name should be display");
		}
		else
		{
			Reporter.log("Contact name should not be display");
		}
		driver.close();
	}
	@Test

	public  void testcase_4() throws IOException
	{

		FileInputStream fis= new FileInputStream("./data/commondata.properties");
		Properties p = new Properties();
		p.load(fis);
		String Browser = p.getProperty("browser");
		String URL = p.getProperty("url");
		String USERNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("password");
		FileInputStream fis1=new FileInputStream("./data/ContactName.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet seat = wb.getSheet("name");
		Row Row = seat.getRow(1);
		String fName = Row.getCell(0).toString();
		String lName = Row.getCell(1).toString();

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("ContactPage")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.name("firstname")).sendKeys(fName);
		driver.findElement(By.name("lastname")).sendKeys(lName);
		driver.findElement(By.xpath("(//img[@src='themes/softed/images/select.gif'])[2]")).click();
		Set<String> allwh = driver.getWindowHandles();
		Iterator<String>itr=allwh.iterator();
		String pwh = itr.next();
		String chw = itr.next();
		driver.switchTo().window(chw);
		driver.findElement(By.linkText("Patricia Johnson")).click();
		driver.switchTo().window(pwh);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String orgMsg =driver.findElement(By.id("dtlview_First Name")).getText();
		String actMsg = driver.findElement(By.className("dvHeaderText")).getText();
		if(actMsg.contains(orgMsg))
		{
			Reporter.log("Contact name should be display");
		}
		else
		{
			Reporter.log("Contact name notshould be display");
		}

		driver.close();	
	}
}
