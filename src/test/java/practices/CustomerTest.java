package practices;

import org.testng.annotations.Test;

public class CustomerTest
{
	@Test(invocationCount = 10 )
	public void createCustomerTest()
	{
		System.out.println("Execute HDFC create Customer Test ");
		//System.out.println(10/0);
	}
	@Test(dependsOnMethods = "createCustomerTest")
	public void modifyCustomerTest()
	{
		System.out.println("Execute modify HDFC to AIRTEL Customer Test ");
		//System.out.println(10/0);
	}
	@Test(dependsOnMethods = "modifyCustomerTest")
	public void deleteCustomerTest()
	{
		System.out.println("Execute delete AIRTEL Customer Test");
		
	}
	

}
