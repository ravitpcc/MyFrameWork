package practices;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.comcast.genericutility.BaseAnnoationClass;
import com.crm.comcast.objectrepositorylib.HomePage;

@Listeners(com.crm.comcast.genericutility.ListnerImplement.class)
public class sampleTestForScreenShot extends BaseAnnoationClass
{
	@Test
	public void contactTest()
	{
	HomePage hp =new HomePage(driver);
	hp.getContactLink();
	Assert.assertEquals("A", "B");
	}
	@Test(retryAnalyzer = com.crm.comcast.genericutility.ReTryImpclass.class)
	public void contactLinkTest()
	{
	HomePage hp =new HomePage(driver);
	hp.getContactLink();
	Assert.assertEquals("A", "B");
	}

}
