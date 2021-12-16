package restex1;

	import org.testng.annotations.*;
	import io.restassured.RestAssured;
	import io.restassured.http.ContentType;
	import io.restassured.response.Response;
	import static io.restassured.RestAssured.*;
	import static org.hamcrest.Matchers.*;

	public class PostTest {

		@Test
		public void test1() {
			String ROOT_URI="https://petstore.swagger.io/v2";
			given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body("{\"id\": 0,\r\n" + 
						"  \"category\": {\r\n" + 
						"    \"id\": 0,\r\n" + 
						"    \"name\": \"string\"\r\n" + 
						"  },\r\n" + 
						"  \"name\": \"doggie\",\r\n" + 
						"  \"photoUrls\": [\r\n" + 
						"    \"string\"\r\n" + 
						"  ],\r\n" + 
						"  \"tags\": [\r\n" + 
						"    {\r\n" + 
						"      \"id\": 0,\r\n" + 
						"      \"name\": \"string\"\r\n" + 
						"    }\r\n" + 
						"  ],\r\n" + 
						"  \"status\": \"available\"}")
		     .when()
		     	.post(ROOT_URI+"/pet")
		     .then()
		     	.statusCode(200)
		     	.log().all();
				 
			
		}
	}


	