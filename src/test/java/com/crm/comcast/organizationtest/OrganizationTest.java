package com.crm.comcast.organizationtest;

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
import com.crm.comcast.objectrepositorylib.CreateNewOrganizationPage;
import com.crm.comcast.objectrepositorylib.HomePage;
import com.crm.comcast.objectrepositorylib.LoginPage;
import com.crm.comcast.objectrepositorylib.OrganizationInformationPage;
import com.crm.comcast.objectrepositorylib.OrganizationsPage;

public class OrganizationTest extends BaseAnnoationClass
{

	@Test(groups ="smokeTest")

	public  void  createOrganizationTest() throws Throwable 
	{


		/*test read Data*/
		wLib.waitUntilPageLoad(driver);
		String orgName = eLib.getDataFromExcel("org",1,2)+jLib.getRanDomNumber();


		/*step 1 : navigate to org*/
		HomePage hp = new HomePage(driver);
		hp.getOrganizationLink().click();

		/* step 2: navigate to create org page*/
	
		OrganizationsPage op = new OrganizationsPage(driver);
		wLib.waitForElementVisibility(driver,op.getCreateOrgImg());
		op.getCreateOrgImg().click();

		/*step 3: create new Org*/
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createOrg(orgName);

		/* step 4: verfiy with Organization Name*/

		OrganizationInformationPage oin = new OrganizationInformationPage(driver);
		//wLib.waitForElementVisibility(driver,oin.getSuccesfullMsg());
		String actualMsg = oin.getSuccesfullMsg().getText();
		Assert.assertTrue(actualMsg.contains(orgName),orgName+" OrgName  not is verified==FAIIL");
		System.out.println(orgName+" OrgName is verified ==PASS");
	}
	
	@Test(groups = "regressionTest")
	public  void createOrgWithIndustriesTest() throws Throwable
	{
		/*test read Data*/
		wLib.waitUntilPageLoad(driver);
		String orgName = eLib.getDataFromExcel("org",1,2)+jLib.getRanDomNumber();
		String industries = eLib.getDataFromExcel("org",4,3);

		/*step 1 : navigate to org*/
		HomePage hp = new HomePage(driver);
		hp.getOrganizationLink().click();

		/* step 2: navigate to create org page*/
		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateOrgImg().click();

		/*step 3: create new Org*/
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createOrg(orgName,industries);


		/* step 4: verfiy with Organization Name*/
		OrganizationInformationPage oin = new OrganizationInformationPage(driver);
		String actualMsg = oin.getSuccesfullMsg().getText();
		Assert.assertTrue(actualMsg.contains(orgName),orgName+" OrgName  not is verified==FAIIL");
		System.out.println(orgName+" OrgName is verified ==PASS");
		
		/* step 5: verfiy with Industry Name*/
		String actIndutriesinfo = oin.getIndutiresInfo().getText();
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(actIndutriesinfo,industries,industries+" Industry name  not is verified==FAIIL");
		System.out.println(industries+" Industry name is verified==PASS");
		soft.assertAll();

	}

}
