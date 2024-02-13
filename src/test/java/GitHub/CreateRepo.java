package GitHub;

import java.net.http.HttpResponse.BodyHandler;
import java.util.HashMap;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;

public class CreateRepo {
	
	@Test
	public void CreateUser() {
		HashMap repoData=new HashMap();
		repoData.put("name","FilmActors2");
		repoData.put("description", "Created repo for the Actors");
		repoData.put("private","true");
		
		RestAssured.given().body(repoData).log().all()
		.header("Authorization","Bearer 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")
		.when().post(" https://api.github.com/user/repos")
		.then().assertThat().statusCode(201).log().all()
		.body("name",equalTo("FilmActors2"))
		.body("description",equalTo("Created repo for the Actors"))
		.body("private",equalTo(true)).log().all();
		
	}
}
