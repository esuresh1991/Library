package StepDefinitions;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.rest.util.Util;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class StepDefwithExcel {
	
	static int id, publisherId,authorId;
	
String sheetName = "Sheet1";
	
	@DataProvider
	public Object[][] getTestDate() {
		Object data[][] = Util.getTestData(sheetName);
		return data;
		
	}
	

	@SuppressWarnings("unchecked")
	@Test(dataProvider = "getTestDate") 	//Passing from excel
	@Given("^Create Book entry with Data from Excel$")
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
	
	@Test
	@Then("^Get the book details using Book ids$")
		public void Get_the_book_details() {
			Response response;
			
			JSONObject request = new JSONObject();
			baseURI	= "http://localhost:8080/";
			 RestAssured.defaultParser = Parser.JSON;
			response = given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.header("Content-Type","application/JSON")
			.body(request.toJSONString())
			.queryParam("bookId",id)
		.when()
			.get("/books/book")
		.then()
			.statusCode(200)
			.log().all()
			.assertThat().body("bookId",equalTo(id) )
			.contentType(ContentType.JSON).extract().response();
			
			System.out.println(id);
			
	//System.out.println(response);
	String a = response.asString();
	System.out.println(a);

		}

}