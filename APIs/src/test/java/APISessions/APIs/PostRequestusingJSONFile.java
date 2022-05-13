package APISessions.APIs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONObject;
import org.json.JSONTokener;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class PostRequestusingJSONFile 
{
	public static void main(String[] args) throws FileNotFoundException
	{
		File f = new File("../APIs/requestbodyData.json");
		FileReader fr = new FileReader(f);
		JSONTokener j = new JSONTokener(fr);
		JSONObject js = new JSONObject(j);
		
		Response resp =
		given()
		.contentType(ContentType.JSON)
		.body(js.toString())
		.when()
		.post("http://localhost:3000/APITesting");

		System.out.println("Status code is ");
		System.out.println(resp.statusCode());
		System.out.println("Response data is ");
		System.out.println(resp.asString());
	}
}
