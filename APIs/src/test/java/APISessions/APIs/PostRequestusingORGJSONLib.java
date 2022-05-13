package APISessions.APIs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class PostRequestusingORGJSONLib 
{
	public static void main(String[] args) throws FileNotFoundException
	{
		JSONObject innerObj1 = new JSONObject();
		innerObj1.put("Type", "Primary");
		innerObj1.put("Door no", "21B");
		innerObj1.put("Street", "6th Cross");
		innerObj1.put("Area", "Ashok Nagar");
		
		JSONObject innerObj2 = new JSONObject();
		innerObj2.put("Type", "Secondary");
		innerObj2.put("Door no", "23C");
		innerObj2.put("Street", "4th Cross");
		innerObj2.put("Area", "MGR Nagar");
		
		JSONArray innerArray1 = new JSONArray();
		innerArray1.put(0,innerObj1);
		innerArray1.put(1,innerObj2);
		
		JSONObject innerObj3 = new JSONObject();
		innerObj3.put("Type", "Primary");
		innerObj3.put("Door no", "18A");
		innerObj3.put("Street", "12th Cross");
		innerObj3.put("Area", "Ashok Nagar");
		
		JSONObject innerObj4 = new JSONObject();
		innerObj4.put("Type", "Secondary");
		innerObj4.put("Door no", "14D");
		innerObj4.put("Street", "11th Cross");
		innerObj4.put("Area", "MGR Nagar");
		
		JSONArray innerArray2 = new JSONArray();
		innerArray2.put(0,innerObj3);
		innerArray2.put(1,innerObj4);
		
		JSONArray innerArray3 = new JSONArray();
		innerArray3.put(0,innerArray1);
		innerArray3.put(1,innerArray2);
		
		JSONObject outerObj = new JSONObject();
		outerObj.put("firstname", "Dilip");
		outerObj.put("lastname", "Kumar");
		outerObj.put("id", "DK4");
		outerObj.put("designation", "Deputy GM");
		outerObj.put("Address", innerArray3);
		
		Response resp =
		given()
		.contentType(ContentType.JSON)
		.body(outerObj.toString())
		.when()
		.post("http://localhost:3000/APITesting");

		System.out.println("Status code is ");
		System.out.println(resp.statusCode());
		System.out.println("Response data is ");
		System.out.println(resp.asString());
	}
}
