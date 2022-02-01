package com.crm.comcast.contacttest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.comcast.genericutility.BaseAnnoationClass;
import com.crm.comcast.genericutility.ExcelUtility;
import com.crm.comcast.genericutility.FileUtility;
import com.crm.comcast.genericutility.JavaUtility;
import com.crm.comcast.genericutility.WebDriverUtility;
import com.crm.comcast.objectrepositorylib.ContactPage;
import com.crm.comcast.objectrepositorylib.ContactInformationPage;
import com.crm.comcast.objectrepositorylib.CreateNewContactsPage;
import com.crm.comcast.objectrepositorylib.CreateNewOrganizationPage;
import com.crm.comcast.objectrepositorylib.HomePage;
import com.crm.comcast.objectrepositorylib.LoginPage;
import com.crm.comcast.objectrepositorylib.OrganizationInformationPage;
import com.crm.comcast.objectrepositorylib.OrganizationsPage;

public class ContactTest extends BaseAnnoationClass
{
	@Test(groups ="smokeTest"/*retryAnalyzer = com.crm.comcast.genericutility.ReTryImpclass.class*/)

	public  void  createContactTest() throws Throwable
	{
		wLib.waitUntilPageLoad(driver);
		/*test read Data*/
		String lastName = eLib.getDataFromExcel("contact",1,2)+jLib.getRanDomNumber();
		wLib.waitUntilPageLoad(driver);
		/*step 3: navigate to contact*/
		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();
		
		/*step 4: navigate to create contact page*/
	    ContactPage cp = new ContactPage(driver);
	    cp.getCreateContactImg().click();
	    
	    /*step 5: Create new Contact*/
	    CreateNewContactsPage cnp = new CreateNewContactsPage(driver);
	    cnp.createContact(lastName);
	    
	    /* step 6: verfiy with last Name*/
	    
	    ContactInformationPage cn = new ContactInformationPage(driver);
	    wLib.waitForElementVisibility(driver,cn.getSuccesfullMsg());
	    String actLastName = cn.getSuccesfullMsg().getText();
	    Assert.assertTrue(actLastName.contains(lastName),lastName +"Contact last name is not verified ==>FAIIL");
		System.out.println(lastName +"Contact last name is verified ==>PASS"); 
	}
	   
	   @Test(groups = "regressionTest")

		public  void   createContactWithOrgTest() throws Throwable
		{
		   
			/*test read Data*/
			String contactName = eLib.getDataFromExcel("contact",4,2)+"_"+jLib.getRanDomNumber();
			String orgName = eLib.getDataFromExcel("contact",4,3)+"_"+jLib.getRanDomNumber();
			wLib.waitUntilPageLoad(driver);

			/*step 1: Navigate to Org page*/
			HomePage hp = new HomePage(driver);
			hp.getOrganizationLink().click();

			/*step 2: Navigate create new Org Page*/
			OrganizationsPage op = new OrganizationsPage(driver);
			op.getCreateOrgImg().click();

			/*step 3: create org*/
			CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
			cnop.createOrg(orgName);

			/*wait for header element*/
			OrganizationInformationPage oi =  new OrganizationInformationPage(driver);
			wLib.waitForElementVisibility(driver,oi.getSuccesfullMsg());
			/*if orgName is not create the execution will stop*/
			//Assert.assertTrue(oi.getSuccesfullMsg().getText().contains(orgName));

			/*step 4: navigate to  create new Contact page*/
			hp.getContactLink().click();

			/* step 5: navigate to create new contact page*/
			ContactPage cn = new ContactPage(driver);
			cn.getCreateContactImg().click();

			/* step 6: create a new contact with orgNamr page*/
			CreateNewContactsPage cnp = new CreateNewContactsPage(driver);
			cnp.createContact(contactName, orgName);

			/* step 7: verfiy with last Name*/
			ContactInformationPage ci = new ContactInformationPage(driver);
			String actLastName = ci.getSuccesfullMsg().getText();
			Assert.assertTrue(actLastName.contains(contactName),contactName+" lastName is verified==FAIL");
			System.out.println(contactName+" lastName is verified==PASS");
			
			/* step 8: verfiy with OrgName*/
			String actOrgMsg = ci.getOrgMsgInfo().getText();
			SoftAssert soft=new SoftAssert();
			soft.assertEquals(actOrgMsg.trim(),orgName,orgName+" orgName is not verified ===> FAIL");
			System.out.println(orgName+" orgName is verified ===> PASS");
			soft.assertAll();
			

		}
}
