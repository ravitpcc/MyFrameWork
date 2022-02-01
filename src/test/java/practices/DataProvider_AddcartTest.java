package practices;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider_AddcartTest 
{
	@Test(dataProvider = "dataProvider_AddcartTest")
	public void AddcartTest(String prd , int Qnt)
	{
		System.out.println("ProductName=>"+prd+" Quantity =>"+Qnt);
	}
	@DataProvider
	public Object [][] dataProvider_AddcartTest()
	{
		Object[][]objArr = new Object[5][2];
		
		objArr[0][0]="Sumsung a52";
		objArr[0][1]=10;
		
		objArr[1][0]="Sumsung a72";
		objArr[1][1]=20;
		
		objArr[2][0]="Mi 10lite";
		objArr[2][1]=6;
		
		objArr[3][0]="Realme 7 pro";
		objArr[3][1]=15;
		
		objArr[4][0]="Iphone 13";
		objArr[4][1]=14;
		
		return objArr;
		
	}
	

}
