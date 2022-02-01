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
public class OrganizationInformationPage extends WebDriverUtility
{
	public OrganizationInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
     @FindBy(className="dvHeaderText")
     private WebElement succesfullMsg;
     
     @FindBy(id="mouseArea_Industry")
	 private WebElement indutiresInfo;
	 

	public WebElement getIndutiresInfo()
	{
		return indutiresInfo;
	}

	public WebElement getSuccesfullMsg()
	{
		return succesfullMsg;
	}


     
     
}
