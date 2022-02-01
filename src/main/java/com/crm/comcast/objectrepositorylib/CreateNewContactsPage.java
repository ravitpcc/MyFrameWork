package com.crm.comcast.objectrepositorylib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.genericutility.WebDriverUtility;
/**
 * 
 * @author Ravi
 *
 */

public class CreateNewContactsPage extends WebDriverUtility
{

	WebDriver driver;
	
	public  CreateNewContactsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name = "lastname")
	private WebElement lastNameEdt;
	
	@FindBy(xpath ="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(xpath ="//input[@name='account_name']/following-sibling::img")
	private WebElement orgLookupImg;

	/**
	 * 
	 * This method is used to create new contact with mandatory information
	 * @author Ravi
	 * @param contactLastName
	 */
	public void createContact(String contactLastName)
	{
		lastNameEdt.sendKeys(contactLastName);
		saveBtn.click();
	}
	/**
	 * 
	 * This method used to create new contact with orgName information
	 * @author Ravi
	 * @param contactLastName
	 * @param orgName
	 */
	
	public void createContact(String contactLastName,String orgName)
	{
		lastNameEdt.sendKeys(contactLastName);
		orgLookupImg.click();
		switchToWindow(driver,"Accounts&action");
		OrganizationsPage op =new OrganizationsPage(driver);
		op.getSearchEdt().sendKeys(orgName);
		op.getSearchBtn().click();
		
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		switchToWindow(driver,"Contacts&action");
		
		saveBtn.click();	
	}

}
