package practices;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.comcast.genericutility.ExcelUtility;

public class DataProvider_AddcartExcel  
{
	
	@Test(dataProvider ="dp_addcardBill")
	public void addcardBill(String prd , String Qnt)
	{
		System.out.println("ProductName=>"+prd+" Quantity =>"+Qnt);
	}
	
	@DataProvider
	
	public Object[][] dp_addcardBill() throws EncryptedDocumentException, IOException
	{
		ExcelUtility eLib = new ExcelUtility();
	   int rowCount = eLib.getRowCount("addToCart");
	   
	   Object[][]objArr = new Object[rowCount][2];
	   
	   for(int i=0;i<rowCount;i++)
	   {
		   objArr[i][0]=eLib.getDataFromExcel("addToCart",i, 0);
		   objArr[i][1]=eLib.getDataFromExcel("addToCart",i, 1);
	   }
	return objArr;
		
	}

}
