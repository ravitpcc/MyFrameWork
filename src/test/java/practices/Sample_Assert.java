package practices;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.comcast.genericutility.BaseAnnoationClass;

public class Sample_Assert extends BaseAnnoationClass
{
	@Test
	public void verifyHomePageTest()
	{
		String expectedpage="Home";
		String actTitle = driver.getTitle();
		boolean status = actTitle.contains(expectedpage);
		Assert.assertTrue(status,"Home page is not Verified==>FAIL");
		System.out.println("Home page is Verified==>PASS");
		
		
	}
	@Test
 public void  verifyHomePageLogo()
 {
		boolean imgLogo = driver.findElement(By.xpath("//img[@title='vtiger-crm-logo.gif'")).isDisplayed();
		Assert.assertTrue(imgLogo,"Home page logo is not Verified==>FAIL");
		System.out.println("Home page logo is Verified==>PASS");
		
 }
}
