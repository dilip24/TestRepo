package APISessions.APIs;

import static io.restassured.RestAssured.*;

import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetRequest 
{
	public static void main(String[] args)
	{
		Response resp =
		given()
		.contentType(ContentType.JSON)
		.when()
		.get("http://localhost:3000/APITesting");
		
		System.out.println("Status code is ");
		System.out.println(resp.statusCode());
		
		//System.out.println("Response data is ");
		//System.out.println(resp.asString());
		
		JSONArray arr = new JSONArray(resp.asString());
		JSONObject obj = arr.getJSONObject(14);
		JSONArray ar = obj.getJSONArray("address");
		JSONObject ob = ar.getJSONObject(1);
		System.out.println(ob.get("landmark"));	
	}
}
