package resources;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class TC002_POST_RegCustomer {
	
	
	@Test
	public void customerRegister() {
		
				
		RequestSpecification reqSpec= new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
										.addQueryParam("key", "qaclick123").build();
		
		ResponseSpecification resSpec= new ResponseSpecBuilder().expectStatusCode(200).build();
		Response res=given().spec(reqSpec).body(TestData.getCustomerData()).when().post("/maps/api/place/add/json")
							.then().spec(resSpec).extract().response();
		
		System.out.println(res.jsonPath().prettify());
		
		
	}

}
