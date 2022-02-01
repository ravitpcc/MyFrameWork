package com.crm.comcast.objectrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * 
 * @author Ravi
 *
 */
public class OrganizationsPage 
{
	public OrganizationsPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement createOrgImg;
	
	@FindBy(id="search_txt")
	private WebElement searchEdt;
	
	@FindBy(name="search")
	private WebElement searchBtn;
	
	public WebElement getSearchEdt()
	{
		return searchEdt;
	}

	public WebElement getSearchBtn()
	{
		return searchBtn;
	}

	public WebElement getCreateOrgImg()
	{
		return createOrgImg;
	}

	
	

}
