package restex1;

	import org.testng.annotations.DataProvider;
	import org.testng.annotations.Test;

	import groovy.util.logging.Log;
	import io.restassured.RestAssured;
	import io.restassured.filter.log.LogDetail;
	import io.restassured.http.ContentType;
	import io.restassured.response.Response;
	import static io.restassured.RestAssured.*;
	import static org.hamcrest.Matchers.*;

	public class RestExample {

	/*	@Test
		public void test_noOfCircuits() {
			 given()
			.when()
				.get("https://ergast.com/api/f1/2017/circuits.json")
			.then()
				.assertThat()
				.body("MRData.CircuitTable.Circuits.circuitId", hasSize(20))
				.log().all()
				;
		}
		
		@Test
		public void test_responseHeader() {
			given()
		    .when()
		    	.get("https://ergast.com/api/f1/2017/circuits.json")
		    .then()
		    	.assertThat()
		    	.statusCode(200)
		    .and()
		    	.contentType(ContentType.JSON)
		    .and()
		    	.header("Content-Length", equalTo("4551"));
		}
		
		
		//Parametrization
		@Test
		public void test_queryParam() {
			String pagenumber = "2";
			given()
			    .param("page", pagenumber)
			.when()
				.get("https://reqres.in/api/users")
		    .then()
		    	.assertThat()
		    	.body("total", equalTo(12));
		}
		
		//Path Parametrization
		@Test
		public void test_pathParametrization() {
			String year ="2019";
			int noOfRaces=21;
			
			given()
				.pathParam("raceSeason", year)
			.when()
				.get("http://ergast.com/api/f1/{raceSeason}/circuits.json")
			.then()
				.assertThat()
				.body("MRData.CircuitTable.Circuits.circuitId", hasSize(noOfRaces));
		}
		
		//Parametrization using data provider
		@DataProvider(name="seasonAndNoOfRaces")
		public Object[][] createTestData(){
			return new Object[][] {
				{"2017",20},
				{"2019",21},
				{"1980",14}
			};
		}
		
		@Test(dataProvider="seasonAndNoOfRaces")
		public void test_DataDrivenTest(String season, int numberOfRaces) {
			given()
				.pathParam("raceSeason1", season)
			.when()
				.get("http://ergast.com/api/f1/{raceSeason1}/circuits.json")
			.then()
				.assertThat()
				.body("MRData.CircuitTable.Circuits.circuitId", hasSize(numberOfRaces));
		}
		
		
		//passing parameters between tests
		@Test
		public void test_parametersBetweenTests() {
			//Retrive the first circuit id for 2017
			String circuitId = 
			 given()
			    .get("http://ergast.com/api/f1/2017/circuits.json")
			.then()
				.extract()
				.path("MRData.CircuitTable.Circuits[1].circuitId");
			System.out.println(circuitId);
			//Get the info about that circuit and verify country is USA
			given()
				.pathParam("circuitId", circuitId)
			.when()
				.get("http://ergast.com/api/f1/circuits/{circuitId}.json")
			.then()
				.assertThat()
				.body("MRData.CircuitTable.Circuits[0].Location.country", equalTo("USA"));
			
		}
		
		//If to use this in multiple tests create a method
		public String getFirstCircuit() {
			//Retriving the first circuit for 2017
			String cid = given()
		    .get("http://ergast.com/api/f1/2017/circuits.json")
		.then()
			.extract()
			.path("MRData.CircuitTable.Circuits[1].circuitId");
		return cid;
		}
		
		@Test
		public void test_parameterBetwnTests2() {
			given()
				.pathParam("circuitId", getFirstCircuit())
				.when()
				.get("http://ergast.com/api/f1/circuits/{circuitId}.json")
			.then()
				.assertThat()
				.body("MRData.CircuitTable.Circuits[0].Location.country", equalTo("USA"))
				.log().all();
		} */
		
		
		@Test
		public void testLogging() {
			given()
			.when()
		    	.log().headers()
				.get("http://ergast.com/api/f1/2017/circuits.json")
			.then()
				//.log().all();
			   // .log().body()
			   // .log().everything();
			    //.log().status();
			//.log().headers()
			//.log().ifValidationFails().statusCode(202);
			.log().ifValidationFails(LogDetail.STATUS).statusCode(200);
		}
	}

