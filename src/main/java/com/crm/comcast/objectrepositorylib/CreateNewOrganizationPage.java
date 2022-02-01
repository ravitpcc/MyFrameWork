package com.crm.comcast.objectrepositorylib;

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
public class CreateNewOrganizationPage extends WebDriverUtility
{

	public  CreateNewOrganizationPage(WebDriver driver)
	{

		PageFactory.initElements(driver,this);
	}
	@FindBy(name="accountname")
	private WebElement orgNameEdt;

	@FindBy(name="industry")
	private WebElement indutiresList;

	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	/**
	 * This method is used to create new Organization with mandate info
	 *  @author Ravi
	 * @param orgName
	 */
	public void createOrg(String orgName )
	{
		orgNameEdt.sendKeys(orgName);
		saveBtn.click(); 
	}

	/**
	 * This method use to select the industrie from listbox	
	 * @author Ravi
	 * @param orgName
	 * @param industrie
	 */

	public void createOrg(String orgName,String industrie )
	{
		orgNameEdt.sendKeys(orgName);
		select(indutiresList,industrie);
		saveBtn.click(); 
	}


}




