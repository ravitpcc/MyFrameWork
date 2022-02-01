package practices;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SampleTest_dataProvide2 
{

	@Test(dataProvider = "dataProvider_bookTicketTest")
	public void bookTicketTest(String src ,String dest,int ticket)
	{
		System.out.println("Execute source => "+src+" Destion=> "+dest);
	}
	
	@DataProvider
	public Object[][]dataProvider_bookTicketTest()
	{
		Object[][] objArr = new Object[3][3];
		
		objArr[0][0]="Banglore";
		objArr[0][1]="Kolkart";
		objArr[0][2]=10;
		
		objArr[1][0]="Banglore";
		objArr[1][1]="Goa";
		objArr[1][2]=20;
		
		objArr[2][0]="Banglore";
		objArr[2][1]="Delhi";
		objArr[2][2]=15;
		
		return objArr;
	}

}
