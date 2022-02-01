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

public class ContactPage
{
	public  ContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//img[@src ='themes/softed/images/btnL3Add.gif']")
	private WebElement createContactImg;
	
	public WebElement getCreateContactImg() {
		return createContactImg;
	}
	

}
