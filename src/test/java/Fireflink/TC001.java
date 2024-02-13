package Fireflink;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class TC001 {
	@Test
	public void listUsers()
	{
		RestAssured.given()
		.when().get("https://reqres.in/api/users?page=2")
		.then().assertThat().statusCode(200).log().all();
	}
	@Test
	public void Createuser()
	{
		HashMap data = new HashMap();
		data.put("name", "morpheus");
		data.put("job", "leader");
		
		
		
		RestAssured.given().body(data).log().all()
		.when().post("https://reqres.in/api/users")
		.then().assertThat().statusCode(201).log().all();
	}
		
}
