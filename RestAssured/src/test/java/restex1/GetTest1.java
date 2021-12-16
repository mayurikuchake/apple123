package restex1;

	import io.restassured.RestAssured;
	import io.restassured.response.Response;
	import static io.restassured.RestAssured.*;
	import static org.hamcrest.Matchers.*;

	import java.util.regex.Pattern;

	import org.testng.Assert;
	import org.testng.annotations.*;


	public class GetTest1 {

		@Test
		public void test1() {
			
			Response response = RestAssured.get("https://reqres.in/api/users?page=2");
		//	get("https://reqres.in/api/users?page=2");
			System.out.println(response.statusCode());
			System.out.println(response.asString());
			System.out.println(response.getBody().asString());
			System.out.println(response.getTime());
			System.out.println(response.statusLine());
			
			int statusCode = response.getStatusCode();
			Assert.assertEquals(statusCode,200);
		
		}
		
		
		@Test
		public void test2() {
			given()
				.get("https://reqres.in/api/users?page=2")
			.then()
				.statusCode(200)
				.body("data[1].id", equalTo(8))
				.body("data.first_name",hasItems("Michael","Lindsay","Tobias"))
				.log().all();
		}
	   
	}
	

