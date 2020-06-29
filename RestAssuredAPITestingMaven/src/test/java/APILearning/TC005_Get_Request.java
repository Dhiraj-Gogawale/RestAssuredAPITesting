//In below script we are Validating Json Response body message. Here we have validated only one text of node employee_name.
package APILearning;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;


public class TC005_Get_Request {
	
	@Test
	public void GetWeatherdetails() {

	RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
	
	//Now we need send above URL as a GET Request. So we will be sending Get type of request. So we need to create below RequestSpecification Object.
    //RequestSpecification is one of the predefine class in RestAssured.
	//With the below httprequest object we will be sending request to the server. hence it is a Request Object.
	RequestSpecification httpRequest=RestAssured.given();
	
	//Now we need to create Response Object to store the Response. For That we will create object of Response. Response is one of the class in RestAssured
	//Below Method.GET is use because the request which we are sending is of GET type. Also we need to pass parameter as an input.
	Response response=httpRequest.request(Method.GET,"/employees");
	
	//Print Responce in Console Window
	String responseBody=response.getBody().asString();
	System.out.println("Response Body is :" +responseBody);
	 
	
	//Validating Tiger Nixon Text in Json Response body message
	Assert.assertEquals(responseBody.contains("Tiger Nixon"), true); // Here we have validated only one text of node employee_name.
	
	
	
  }
}
