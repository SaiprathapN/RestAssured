package GitHub;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

public class Shopperstack {
	String baseUrl="https://www.shoppersstack.com/shopping";
	int shopperId;
	String Token;
	int productId;
	//@Test
//	public void Login()
//	{
//		HashMap hm=new HashMap();
//		hm.put("email","hdfc123@gmail.com");
//		hm.put("password","Fireflink@123");
//		hm.put("role","SHOPPER");
//		
//		String logindetails = RestAssured.given().contentType(ContentType.JSON).body(hm).log().all()
//		.when().post("https://www.shoppersstack.com/shopping/users/login")
//		.then().assertThat().statusCode(200).log().all().extract().response().asString();
//		
//		JsonPath js=new JsonPath(logindetails);
//		shopperId=js.get("data.userId");
//		Token=js.get("data.jwtToken");
//		System.out.println(shopperId);
//		System.out.println(Token);
//		
//	}
	@Test 
	public void Productview()
	{
		String Productdetails = RestAssured.given()
		.when().get(baseUrl+"/products/alpha")
		.then().assertThat().statusCode(200).log().all().extract().response().asString();
		
		JsonPath js=new JsonPath(Productdetails);
		productId=js.get("data[0].productId");
		
		System.out.println(productId);
	}
	@Test
	public void AddToCart()
	{
		HashMap hm=new HashMap();
		hm.put("productId",productId);
		hm.put("quantity", 2);
		
		
		RestAssured.given().contentType(ContentType.JSON).body(hm).log().all()
		.when().post(baseUrl+"/shoppers/shopperId/wishlist")
		.then().assertThat().statusCode(201).log().all();
		
		
	}
	
}
