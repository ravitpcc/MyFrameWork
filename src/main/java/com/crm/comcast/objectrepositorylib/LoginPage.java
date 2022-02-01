package com.crm.comcast.objectrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * This class is use to login the application ,logout and close the browser 
 * @author Ravi
 *
 */
public class LoginPage
{
	public LoginPage(WebDriver driver) /* Rule 3: Execute all the elements & initialize the elements pageFactory.initElements[initialization]*/
	{
		PageFactory.initElements(driver,this);
	}
	@FindBy(name="user_name")    /*Rule 2: Identify all the elements using @findBy & @findBys,@findALL [Declaration]*/
	private WebElement userNameEdit;
	
	@FindBy(name="user_password")
	private WebElement userPasswordEdit;
	
	@FindBy(id="submitButton")
	private WebElement loginBtn;
     /*Rule 4 : Declare all the element As private & provide getter method, Bussinesslogic method for [Utilization]*/
	public WebElement getUserNameEdit() {
		return userNameEdit;
	}

	public WebElement getUserPasswordEdit() {
		return userPasswordEdit;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	/**
	 * This method  use to login the application
	 * @author Ravi
	 * @param userName
	 * @param password
	 */
	
	public void loginToApp(String userName , String password)
	{
		/*step 1:login */
		userNameEdit.sendKeys(userName);
		userPasswordEdit.sendKeys(password);
		loginBtn.click();
		
		
		
	}

}
