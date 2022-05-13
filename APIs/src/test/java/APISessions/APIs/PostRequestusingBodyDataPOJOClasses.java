package APISessions.APIs;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostRequestusingBodyDataPOJOClasses 
{
	public static void main(String[] args) 
	{
		AddressDetails[] address = new AddressDetails[2];
		
		address[0] = new AddressDetails();
		
		address[0].setDoorNo("G11");
		address[0].setStreet("M.G.Street");
		address[0].setLandmark("Opp to bus stand");
		
		address[1] = new AddressDetails();
		
		address[1].setDoorNo("D6");
		address[1].setStreet("J.N.Street");
		address[1].setLandmark("Near Railway Station");
		
		BasicInformation basic = new BasicInformation();
		basic.setId("Id5");
		basic.setDesignation("COO");
		basic.setFirstname("Dilip");
		basic.setLastname("Kumar");
		basic.setAddress(address);
		
		Response resp =
		given()
		.contentType(ContentType.JSON)
		.body(basic)
		.when()
		.post("http://localhost:3000/APITesting");
		
		System.out.println("Status code is ");
		System.out.println(resp.statusCode());
		System.out.println("Response data is ");
		System.out.println(resp.asString());
	}

}
