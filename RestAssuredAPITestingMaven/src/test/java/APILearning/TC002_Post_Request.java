//Below code is for Post Request. Here we will also be sending data to the server and then server will give you success response. Here we have also validated success response & Status Code.

package APILearning;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC002_Post_Request {
	@Test
	void Create_new_record_in_database() {

		//Specify base URl
		RestAssured.baseURI="http://restapi.demoqa.com/customer";

		//Creating object of RequestSpecification class(Creating object of Request).		
		RequestSpecification httpRequest=RestAssured.given();

		//In post Request we need to pass some employee data such as name, salary, age etc which is in Json Format.
		//Therefore we need to send the request along with the body which is in Json format & then it will create new record in database.
        // Before sending the request we need to first create the body which is the data. For that we have use below JSONObject. We also need to add parameter to send data which will be send with Post request
		JSONObject requestParams =  new JSONObject();
		requestParams.put("FirstName", "JohnXYZ");
		requestParams.put("LastName", "XYZJohn");
		requestParams.put("UserName", "JohnXYZ");
		requestParams.put("Password", "JohnXYZxyx");
		requestParams.put("Email", "JohnXYZ@gmail.com");
		
		
		httpRequest.header("Content_Type","application/json");
		
		httpRequest.body(requestParams.toJSONString()); //attached data to the request
		
		//Now we need to create Response Object to store the Response. For That we will create object of Response. Response is one of the class in RestAssured
		//Below Method.POST is use because the request which we are sending is of POST type. Also we need to pass parameter as an input.
		Response response=httpRequest.request(Method.POST,"/register");
		
		
		//Print Responce in Console Window
		String responseBody=response.getBody().asString();
		System.out.println("Response Body is :" +responseBody);
		
		//status code validation
		int statusCode=response.getStatusCode();
		System.out.println("Status Code is :" +statusCode);
		Assert.assertEquals(504, statusCode);
		
		//Success Code Validation. Success code is a part of response body.
		String successCode = response.jsonPath().get("SuccessCode");
		Assert.assertEquals("SuccessCo", successCode);
		
		

	}
}
