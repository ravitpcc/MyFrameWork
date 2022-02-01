package com.crm.comcast.objectrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.genericutility.WebDriverUtility;
/**
 * 
 * @author Ravi
 *
 */
public class HomePage extends WebDriverUtility
{
	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(linkText="Organizations")
	private WebElement organizationLink;
	
	@FindBy(linkText="Contacts")
	private WebElement ContactLink;
	
	
	public WebElement getContactLink() 
	{
		return ContactLink;
	}

	@FindBy(linkText="Products")
	private WebElement ProductLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminstratorImg;
	
	@FindBy(linkText="Sign Out")
	private WebElement SignOutLink;
	
	public WebDriver getDriver() 
	{
		return driver;
	}

	public WebElement getOrganizationLink()
	{
		return organizationLink;
	}

	public WebElement getProductLink() {
		return ProductLink;
	}

	public WebElement getAdminstratorImg() {
		return adminstratorImg;
	}

	public WebElement getSignOutLink() {
		return SignOutLink;
	}
	/**
	 * This method use to logout the application
	 * @author Ravi
	 */
	
	public void logout()
	{
		mouseOver(driver,adminstratorImg);
		SignOutLink.click();
	}
	

}
