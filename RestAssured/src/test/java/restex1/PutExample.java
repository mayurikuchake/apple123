package restex1;

	import org.json.simple.JSONObject;
	import org.testng.annotations.Test;

	import io.restassured.http.ContentType;

	import static io.restassured.RestAssured.*;

	import java.io.File;

	public class PutExample {

		@Test
		public void test1() {
			
			JSONObject request = new JSONObject();
			request.put("name", "Tarun");
			request.put("job", "TestingTrainer");
			
			System.out.println(request);
			given()
				.body(request.toJSONString()).
			when()
				.put("https://reqres.in/api/users/2").
		    then()
		    	.statusCode(200)
		    	.log().all();
		}
		
		@Test
		public void test2() {
			File jsonDataFile=new File("C:\\\\Users\\\\mayur\\\\eclipse-workspace\\\\RestAssured\\\\Payload.java");
			String ROOT_URI="https://petstore.swagger.io/v2";
			given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(jsonDataFile)
		     .when()
		     	.put(ROOT_URI+"/pet")
		     .then()
		     	.statusCode(200)
		     	.log().all();
				 
		}
		
		
	}

