//package StepDefinitions;
//
//import static io.restassured.RestAssured.baseURI;
//import static io.restassured.RestAssured.given;
//import static org.hamcrest.Matchers.equalTo;
//
//import org.json.simple.JSONObject;
//
//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
//import io.restassured.RestAssured;
//import io.restassured.http.ContentType;
//import io.restassured.parsing.Parser;
//import io.restassured.path.json.JsonPath;
//import io.restassured.response.Response;
//
//public class BookStepDefinition {
//
//	//static String BookId;
//	static int id, publisherId,authorId;
//	@SuppressWarnings("unchecked")
//	@Given("^Create Book entry with \"(.*)\",\"(.*)\",\"(.*)\",\"(.*)\",\"(.*)\",\"(.*)\",\"(.*)\",\"(.*)\"$")
//	public static void Create_Book_entry(String bookName,int authorId,int publisherId,String authorName,String publisherName,String genre,int price,int numberOfPages) 
//	{
//
//		Response response;
//						
//		JSONObject request = new JSONObject();
//		request.put( "bookName", bookName);
//		request.put( "authorId", authorId);
//		request.put( "publisherId", publisherId);
//		request.put( "authorName", authorName);
//		request.put( "publisherName", publisherName);
//		request.put( "genre", genre);
//		request.put( "price", price);
//		request.put( "numberOfPages", numberOfPages);
//		
//		baseURI	= "http://localhost:8080/";
//
//		response = given()
//			.contentType(ContentType.JSON)
//			.accept(ContentType.JSON)
//			.header("Content-Type","application/JSON")
//			.body(request.toJSONString())
//		.when()
//			.post("/books/book")
//		.then()
//			.statusCode(200)
//			.log().all()
//			.contentType(ContentType.JSON).extract().response();
//		
////		BookId = response.jsonPath().getString("bookId");
////		System.out.println(BookId);
//		
//		String Res = response.asString();
//		JsonPath jp=new JsonPath(Res);
//        id=jp.getInt("bookId");
//        System.out.println("Book id created : "+id);
//		
//	}
//	
//	@Then("^Get the book details using Book id$")
//	public void Get_the_book_details() {
//		Response response;
//		
//		JSONObject request = new JSONObject();
//		baseURI	= "http://localhost:8080/";
//		 RestAssured.defaultParser = Parser.JSON;
//		response = given()
//		.contentType(ContentType.JSON)
//		.accept(ContentType.JSON)
//		.header("Content-Type","application/JSON")
//		.body(request.toJSONString())
//		.queryParam("bookId",id)
//	.when()
//		.get("/books/book")
//	.then()
//		.statusCode(200)
//		.log().all()
//		.assertThat().body("bookId",equalTo(id) )
//		.contentType(ContentType.JSON).extract().response();
//		
//		System.out.println(id);
//		
////System.out.println(response);
//String a = response.asString();
//System.out.println(a);
//
//
//	}
//	
//	@SuppressWarnings("unchecked")
//	@Then("^Create Publisher entry with \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
//	public void create_Publisher_entry_with(String publisherName, String address, String country)  {
//
//		Response response;
//		
//		JSONObject request = new JSONObject();
//		request.put( "publisherName", publisherName);
//		request.put( "address", address);
//		request.put( "country", country);
//		
//		baseURI	= "http://localhost:8080/";
//
//		response = given()
//			.contentType(ContentType.JSON)
//			.accept(ContentType.JSON)
//			.header("Content-Type","application/JSON")
//			.body(request.toJSONString())
//		.when()
//			.post("publishers/publisher")
//		.then()
//			.statusCode(200)
//			.log().all()
//			.contentType(ContentType.JSON).extract().response();
//		
//		String Res = response.asString();
//		JsonPath jp=new JsonPath(Res);
//		publisherId=jp.getInt("publisherId");
//        System.out.println("publisher Id created : "+publisherId);
//		
//	    
//	}
//	
//	@SuppressWarnings("unchecked")
//	@Then("^Create Author entry with \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
//	public void create_Author_entry_with(String Name, String address, String country)  {
//
//		Response response;
//		
//		JSONObject request = new JSONObject();
//		request.put( "name", Name);
//		request.put( "address", address);
//		request.put( "country", country);
//		
//		baseURI	= "http://localhost:8080/";
//
//		response = given()
//			.contentType(ContentType.JSON)
//			.accept(ContentType.JSON)
//			.header("Content-Type","application/JSON")
//			.body(request.toJSONString())
//		.when()
//			.post("authors/author")
//		.then()
//			.statusCode(200)
//			.log().all()
//			.contentType(ContentType.JSON).extract().response();
//		
//		String Res = response.asString();
//		JsonPath jp=new JsonPath(Res);
//		authorId=jp.getInt("authorId");
//        System.out.println("Author Id created : "+authorId);
//		
//	    
//	}
//	
//	 
//	 
//}