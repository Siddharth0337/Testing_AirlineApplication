package com.simplilearn.RestAssured;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


public class ApiTesting {
	

		private static final Logger logger = LoggerFactory.getLogger(ApiTesting.class);
		@Test
		public void confirmbooking() {
			baseURI = "http://localhost:9090/FlyAway/";
			given()
			.get("completepurchase")
			.then()
			.statusCode(200);
			
			logger.info("Test case 'confirmbooking' executed");
	}
		@Test
		public void checkflights() {
			baseURI = "http://localhost:9090/FlyAway/";
			given()
			.get("home?source=1&destination=11")
			.then()
			.statusCode(200);
			
			logger.info("Test case 'checkflights' executed");
		}

}


