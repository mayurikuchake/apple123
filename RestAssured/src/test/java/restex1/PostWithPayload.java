package restex1;

	import static io.restassured.RestAssured.given;

	import java.io.File;

	import org.testng.annotations.Test;

	import io.restassured.http.ContentType;

	public class PostWithPayload {

		@Test
		public void test1() {
			File jsonDataFile=new File("C:\\Users\\mayur\\eclipse-workspace\\RestAssured\\Payload.java");
			String ROOT_URI="https://petstore.swagger.io/v2";
			given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(jsonDataFile)
		     .when()
		     	.post(ROOT_URI+"/pet")
		     .then()
		     	.statusCode(200)
		     	.log().all();
				 
		}
	}

