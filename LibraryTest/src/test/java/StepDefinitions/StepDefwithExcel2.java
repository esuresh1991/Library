package StepDefinitions;

import org.json.simple.JSONObject;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cucumber.api.java.en.Given;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import com.qa.rest.util.Util;

public class StepDefwithExcel2 {
	
	
	static int id, publisherId,authorId;
	
String sheetName = "Sheet1";
	
	@DataProvider
	public Object[][] getTestDate() {
		Object data[][] = Util.getTestData(sheetName);
		return data;
		
	}
	

	@SuppressWarnings("unchecked")
	@Test(dataProvider = "getTestDate") 	//Passing from excel
	@Given("^User login with the following username and password with data in excel$")
	public void create_Book_entry_with_Data_from_Excel(Object bookName, Object authorId, Object publisherId, Object authorName, Object publisherName, Object genre , Object price, Object numberOfPages) 
	 {
		Response response;

		
		
		JSONObject request = new JSONObject();
		request.put( "bookName", bookName);
		request.put( "authorId", authorId);
		request.put( "publisherId", publisherId);
		request.put( "authorName", authorName);
		request.put( "publisherName", publisherName);
		request.put( "genre", genre);
		request.put( "price", price);
		request.put( "numberOfPages", numberOfPages);
	
	baseURI	= "http://localhost:8080/";

	response = given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.header("Content-Type","application/JSON")
		.body(request.toJSONString())
	.when()
		.post("/books/book")
	.then()
		.statusCode(200)
		.log().all()
		.contentType(ContentType.JSON).extract().response();
	
	String Res = response.asString();
	JsonPath jp=new JsonPath(Res);
    id=jp.getInt("bookId");
    System.out.println("Book id created : "+id);
	 }
		
	}