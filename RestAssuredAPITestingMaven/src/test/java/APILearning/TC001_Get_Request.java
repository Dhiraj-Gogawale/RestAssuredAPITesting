//Below code is for Get Request. Here we have also verify the Status code and Status Line.
package APILearning;



import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC001_Get_Request {
	
	@Test
    void Get_all_employee_data() {
		
		//Specify base URl
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
		
		//status code validation
		int statusCode=response.getStatusCode();
		System.out.println("Status Code is :" +statusCode);
		Assert.assertEquals(200, statusCode);
		
		//Status line verification
		String statusline = response.getStatusLine();
		System.out.println("Status Line is :" +statusline);
		Assert.assertEquals("HTTP/1.1 200 OK", statusline);
	}

}