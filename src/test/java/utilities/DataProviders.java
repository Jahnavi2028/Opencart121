package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	//DataProvider1
	
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException
	{
		String path=".\\testData\\Opencart_LoginData.xlsx";
		
		ExcelUtility xlutil=new ExcelUtility(path); //creating object for ExcelUtility
		
		int totalrows=xlutil.getRowCount("Opencart_LoginData");
		
		int totalcols=xlutil.getCellCount("Opencart_LoginData", 1);
		
		String logindata[][]=new String[totalrows][totalcols];  //created 2dim array which store row col
		
		for(int i=1;i<=totalrows;i++)
		{
			for(int j=0;j<totalcols;j++)
			{
				logindata[i-1][j]=xlutil.getCellData("Opencart_LoginData", i, j);  //1,0				
			}
		}
		return logindata;  //returning 2 dim array
		
	}
}
