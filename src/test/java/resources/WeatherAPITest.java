package resources;

import org.testng.Assert;
import org.testng.annotations.Test;


import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class WeatherAPITest {
	
	@Test
	public void getWeatherDetails() {
		
		
		//RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city/";
		
		RequestSpecification reqSpec=new RequestSpecBuilder().setBaseUri("http://demoqa.com/utilities/weather/city")
											.addPathParam("city", "Hyderabad").build();
		
		ResponseSpecification resSpec=new ResponseSpecBuilder().expectStatusCode(200).build();
		
		Response res= given().spec(reqSpec).when().get("/{city}").then().spec(resSpec).extract().response();
		
		JsonPath js= new JsonPath(res.asString());
		
		System.out.println(res.asString());
		Assert.assertEquals(js.getString("City"), "Hyderabad");
		
	}

}
