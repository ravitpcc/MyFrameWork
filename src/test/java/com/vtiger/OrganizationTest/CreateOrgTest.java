package com.vtiger.OrganizationTest;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateOrgTest {

	public static void main(String[] args) throws IOException, EncryptedDocumentException, InvalidFormatException {
		FileInputStream fis= new FileInputStream("./data/commondata.properties");
		Properties p = new Properties();
		p.load(fis);
		String Browser = p.getProperty("browser");
		String URL = p.getProperty("url");
		String USERNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("password");
		
		Random ran = new Random();
		int ranDomNum = ran.nextInt(10000);
		
		FileInputStream fis_e= new FileInputStream("./data/testdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis_e);
		Sheet ch = wb.getSheet("org");
		Row row = ch.getRow(0);
		String orgName = row.getCell(0).toString() +ranDomNum ;
		WebDriver driver ;
		if(Browser.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(Browser.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else
		{
			driver=new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String actMsg = driver.findElement(By.className("dvHeaderText")).getText();
		System.out.println(actMsg);
		if(actMsg.contains(orgName))
		{
			System.out.println("New Organization is successfully created..PASS");
		}
		else
		{
			System.out.println("Organization is not created ..FAIL");
		}
		Actions a=new Actions(driver);
		WebElement desc = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		a.moveToElement(desc).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.close();
		
	}

}
