package StepDefinitions;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.rest.util.Util;

import cucumber.api.java.en.Given;

public class ReadExcel {
	
String sheetName = "Sheet1";
	
	@DataProvider
	public Object[][] getTestDate() {
		Object data[][] = Util.getTestData(sheetName);
		return data;
		
	}

	
	
	@Test(dataProvider = "getTestDate") 	//Passing from excel
	public void create_Book_entry_with_Data_from_Excel(Object bookName, Object authorId, Object publisherId, Object authorName, Object publisherName, Object genre , Object price, Object numberOfPages) 
	 {

		
	 }
	
}
