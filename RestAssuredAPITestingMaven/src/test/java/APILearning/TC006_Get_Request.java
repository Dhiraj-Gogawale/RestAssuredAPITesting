//Below code is for Get Request. Here we have are verifying the text of all nodes .
package APILearning;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC006_Get_Request {
	
		
		@Test
		public void GetEmployeeDetails() {

		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		
		//Now we need to send above URL as a GET Request. So we will be sending Get type of request. So we need to create below RequestSpecification Object.
	    //RequestSpecification is one of the predefine class in RestAssured.
		//With the below httprequest object we will be sending request to the server. hence it is a Request Object.
		RequestSpecification httpRequest=RestAssured.given();
		
		//Now we need to create Response Object to store the Response. For That we will create object of Response. Response is one of the class in RestAssured
		//Below Method.GET is use because the request which we are sending is of GET type. Also we need to pass parameter as an input.
		Response response=httpRequest.request(Method.GET,"/employees");
		
		String responseBody=response.getBody().asString();
		System.out.println("Response Body is :" +responseBody);
		
		//JosnPath is one of the predefine class on RestAssured.
		JsonPath jsonpath = response.jsonPath();
		
		System.out.println(jsonpath.get("employee_name"));
		System.out.println(jsonpath.get("status"));
		System.out.println(jsonpath.get("id"));
		System.out.println(jsonpath.get("employee_salary"));
		System.out.println(jsonpath.get("employee_age"));
		
		Assert.assertEquals("320800", "employee_salary");
		}
		
}
