package restex1;

	import org.testng.annotations.Test;

	import io.restassured.http.ContentType;

	import static io.restassured.RestAssured.*;
	public class DeleteTest {
		
		@Test
		public void delete_test() {
			
			given()
			.when()
			   .delete("https://reqres.in/api/users/2")
			.then()
				.statusCode(204);
			
		}

	}
	
	


	
	