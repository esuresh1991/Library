package StepDefinitions;

import com.qa.rest.util.ExcelDataToDateTables;

import cucumber.api.DataTable;
import cucumber.api.Transform;
import cucumber.api.java.en.When;

public class LoginStepDfn {
	//To generate Example output from Excel		
	@When("^User login with the following username and password with data in excel at \"([^\"]*)\"$")
	public void user_login_with_the_following_username_and_password_with_data_in_excel_at(@Transform(ExcelDataToDateTables.class) DataTable table) throws Throwable {
		System.out.println(table.toString());
		
//		List<String> dataList = table.asList(String.class);
		
//		for(String str : dataList){
//			System.out.println(str);
//		}
		
	}
	
}